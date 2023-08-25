-- DROP TABLE scops_customer_apet;

Select * from SCOPS_CUSTOMER_APET;

-- New Table Creation for Entity
                  create table SCOPS_CUSTOMER_APET
(
    SAP_CUSTOMER_ID          VARCHAR2(10) not null,
    SAP_SALES_ORG_CD         VARCHAR2(4)  not null,
    SERVICE_MODEL            VARCHAR2(15) not null,
    EXISTING_SALES           NUMBER,
    NEW_SALES                NUMBER(11),
    TOTAL_APET_SALES         NUMBER(11),
    APET_MARGIN              NUMBER(5, 2),
    COMMODITY_SPLIT_EMBEDDED NUMBER(3),
    COMMODITY_SPLIT_IPE      NUMBER(3),
    APET_INVENTORY_TURNS     NUMBER(11, 1),
    OP                       NUMBER(4, 1),
    ROWC                     NUMBER(4, 1),
    PROFIT_INDEX             NUMBER(11),
    SERVICE_FEE              VARCHAR2(100),
    SERVICE_FEE_AMOUNT       NUMBER(11),
    PAYMENT_TERMS            VARCHAR2(100),
    VPA_AGREEMENT            VARCHAR2(400),
    VPA_AGREEMENT_DETAILS    VARCHAR2(400),
    FREIGHT                  VARCHAR2(100),
    RA_APPROVAL_LEVEL        VARCHAR2(100),
    APET_ATTACHMENT          BLOB,
    APET_ATTACHMENT_NAME     VARCHAR2(100),
    APET_APPROVAL_ATTACHMENT BLOB,
    APET_APPROVAL_ATTACHMENT_NAME     VARCHAR2(100),
    COMMENTS                 CLOB,
    SERVICE_FEE_COMMENT      VARCHAR2(400),
    constraint SCOPS_CUSTOMER_APET_PK
        primary key (SAP_CUSTOMER_ID, SAP_SALES_ORG_CD, SERVICE_MODEL)
)
