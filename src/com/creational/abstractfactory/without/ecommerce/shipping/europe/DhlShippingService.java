package com.creational.abstractfactory.shipping.europe;

import com.creational.abstractfactory.shipping.ShippingService;

public class DhlShippingService implements ShippingService {

    @Override
    public void shipOrder() {
        System.out.println("Shipping via DHL (Europe)");
    }
}
