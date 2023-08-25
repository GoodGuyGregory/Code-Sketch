// All Examples can be seen inside of SCops
// src/main/java/com/avnet/scops/rest/services/CustomerProfileService.java

@GET
	@Path("/query_runner_reports/all/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadAllQueryRunnerReports() {
		try {

			Query queryAllQRreports = em.createNativeQuery("SELECT qss.script_id, qss.SCRIPT_NAME, qss.SCHEDULE, qss.DESCRIPTION FROM QR_SQL_SCRIPTS qss");

			List<Object[]> scripts = (List<Object[]>) queryAllQRreports.getResultList();
//			for each found script return an object to reference
			return Response.ok(scripts).build();
		} catch (Exception e) {
			return serverError("Failed to load all query runner reports", e);
		}
	}

	@POST
	@Path("/query_runner_reports")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadQueryRunnerReports(ProfileIdentifierParams params) {
		try {
			//					Retrieves the List of Reports:
//					=====================================================
			List<CustomerReports> queryRunnerReports = em.createQuery(
							"from CustomerReports qrReports where qrReports.pk.customerId = :cid", CustomerReports.class)
					.setParameter("cid", params.getCustomerId())
					.getResultList();

//			 Produce Query for additional display details:
			for (CustomerReports custrep : queryRunnerReports) {
//				get the details of the reports:
				Query q = em.createNativeQuery("SELECT qrs.script_name, qrs.description, qrs.schedule FROM QR_SQL_SCRIPTS qrs where qrs.script_id = :repID");
				q.setParameter("repID", custrep.getPk().getScriptId());
//				 set custom attributes from this query object
//				 no schedule set for them = manual report
//				  or no recipients.
				Object[] singleQRscriptDetails = (Object[]) q.getSingleResult();
// 				 set attributes for the customer report:
				custrep.setReportName((String) singleQRscriptDetails[0]);
				custrep.setReportDescription((String) singleQRscriptDetails[1]);
//				schedule parsing logic:
//				=====================================================================
				if (singleQRscriptDetails[2] != null) {
					CronDescriptor descriptor = CronDescriptor.instance(Locale.US);
					CronParser parser = new CronParser(CronDefinitionBuilder.instanceDefinitionFor(CronType.CRON4J));
					String convertedCron = descriptor.describeHHmmss(parser.parse((String) singleQRscriptDetails[2]).retrieveFieldsAsMap());
					custrep.setReportSchedule(convertedCron);
				} else {
					custrep.setReportSchedule("Manual Run");
				}

				Query destinationQuery = em.createNativeQuery("SELECT action.destination FROM QR_SCRIPT_ACTION_DESTINATIONS action WHERE script_id = :scriptID AND action.action_type = 'EMAIL_OUTPUT'");
				destinationQuery.setParameter("scriptID", custrep.getPk().getScriptId());
				List<Object[]> QRScriptRecipients = (List<Object[]>) destinationQuery.getResultList();
//					append each recipient to the string of recipients...
				custrep.setReportRecipients(new ArrayList<String>());
				for (Object recipList : QRScriptRecipients) {
					custrep.getReportRecipients().add((String) recipList);
				}
			}

			return Response.ok(queryRunnerReports).build();
		} catch (Exception e) {
			return serverError("Failed to load profile's query runner reports", e);
		}
	}

	@POST
	@Path("/query_runner_reports/delete/{scriptId}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteQueryRunnerReport(
			ProfileIdentifierParams customerProfile,
			@PathParam("scriptId") String paramsQRScriptId) {
		try {
			//					Retrieves the Reports to Remove:
			//		 =====================================================
			utx.begin();
			em.createQuery("DELETE FROM CustomerReports cr WHERE cr.pk.customerId = :customerProfileId AND cr.pk.scriptId = :paramsQRScriptId")
					.setParameter("customerProfileId", customerProfile.getCustomerId())
					.setParameter("paramsQRScriptId", Double.valueOf(paramsQRScriptId))
					.executeUpdate();
			utx.commit();
			return Response.noContent().build();
		} catch (Exception e) {
			try {
				utx.rollback();
			} catch (Exception re) {
				logger.error("Failed to delete script associated with customer " + customerProfile.getCustomerId() + re.getLocalizedMessage());
			}
			return serverError("Failed to delete script associated with customer " + customerProfile.getCustomerId(), e);
		}
	}

	@POST
	@Path("/query_runner_reports/add/{scriptId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Transactional
	public Response addQueryRunnerReport(
			ProfileIdentifierParams customerProfile,
			@PathParam("scriptId") String paramsQRScriptId) {
		try {
			//					Add additional report to CUSTOMER_REPORTS:
			//		 =====================================================
			CustomerReports newReport = new CustomerReports();

//				Set all CustomerReportPK details:
//			=====================================
			CustomerReportPK newCustPK = new CustomerReportPK(customerProfile.getCustomerId(), customerProfile.getSalesOrgCode(), customerProfile.getServiceModel(),Double.valueOf(paramsQRScriptId));
			newReport.setPk(newCustPK);

//			Set transient variables:
//			=====================================
			try {
//			reportSchedule, reportName, reportDescription
			Query scriptDetails = em.createNativeQuery("SELECT  qrs.script_name, qrs.description, qrs.schedule FROM QR_SQL_SCRIPTS qrs WHERE qrs.script_id = :scriptId")
					.setParameter("scriptId", paramsQRScriptId);


				Object[] qrReportdetails = (Object[]) scriptDetails.getSingleResult();
// 				 set attributes for the customer report:
				newReport.setReportName((String) qrReportdetails[0]);
				newReport.setReportDescription((String) qrReportdetails[1]);

//				schedule parsing logic:
//				=====================================================================
				if (qrReportdetails[2] != null) {
					CronDescriptor descriptor = CronDescriptor.instance(Locale.US);
					CronParser parser = new CronParser(CronDefinitionBuilder.instanceDefinitionFor(CronType.CRON4J));
					String convertedCron = descriptor.describeHHmmss(parser.parse((String) qrReportdetails[2]).retrieveFieldsAsMap());
					newReport.setReportSchedule(convertedCron);
				} else {
					newReport.setReportSchedule("Manual Run");
				}

//				Establish Recipients:
				Query destinationQuery = em.createNativeQuery("SELECT action.destination FROM QR_SCRIPT_ACTION_DESTINATIONS action WHERE script_id = :scriptID AND action.action_type = 'EMAIL_OUTPUT'");
				destinationQuery.setParameter("scriptID", paramsQRScriptId);
				List<Object[]> QRScriptRecipients = (List<Object[]>) destinationQuery.getResultList();
//					append each recipient to the string of recipients...
				newReport.setReportRecipients(new ArrayList<String>());
				for (Object recipList : QRScriptRecipients) {
					newReport.getReportRecipients().add((String) recipList);
				}

			}
			catch (Exception e) {
				logger.error("Failed to locate script " + paramsQRScriptId + " associated with customer " + customerProfile.getCustomerId());
			}
//			pass in the object
			em.persist(newReport);
			return Response.noContent().build();
		} catch (Exception e) {
			try {
				utx.rollback();
			} catch (Exception re) {
				logger.error("Failed to add script associated with customer " + customerProfile.getCustomerId() + re.getLocalizedMessage());
			}
			return serverError("Failed to add script" + paramsQRScriptId +  " associated with customer " + customerProfile.getCustomerId(), e);
		}
	}