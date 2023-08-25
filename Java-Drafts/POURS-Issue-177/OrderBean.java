package com.avnet.pours.ejb;

import com.avnet.pours.entities.Order;
import com.avnet.pours.socket.UpdatesHandler;

import javax.ejb.Stateless;
import javax.inject.Inject;
 
@Stateless
public class OrderBean {

    @Inject
    private UpdatesHandler updates;

    public void processOrder(Order order) {
        // TODO: All order logic goes here
        System.out.println("This was called");
        System.out.println(updates);
    }
}
