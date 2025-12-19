package com.creational.abstractfactory.services.shipping.europe;

import com.creational.abstractfactory.services.shipping.ShippingService;

public class DhlShippingService implements ShippingService {

    @Override
    public void shipOrder() {
        System.out.println("Shipping via DHL (Europe)");
    }
}
