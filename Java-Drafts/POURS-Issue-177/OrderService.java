package com.avnet.pours.api.services;

import com.avnet.pours.ejb.OrderBean;
import com.avnet.pours.entities.Order;

import javax.ejb.EJB;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("order")
public class OrderService extends CrudService<Order> {

    @EJB
    private OrderBean orderBean;

    @Override
    protected Class<Order> getEntityClass() { return Order.class; }

    @Override
    public Response read() throws Exception {
        List<Order> orders = em.createQuery("from Order where part.companyId = :companyId", Order.class)
                .setParameter("companyId", getCompanyId()).getResultList();
        return Response.ok(orders).build();
    }

    @Override
    public void prepareForSave(Order order) {
        orderBean.processOrder(order);
    }

}
