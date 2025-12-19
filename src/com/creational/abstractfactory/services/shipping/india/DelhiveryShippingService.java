package com.creational.abstractfactory.services.shipping.india;

import com.creational.abstractfactory.services.shipping.ShippingService;

public class DelhiveryShippingService implements ShippingService {

    @Override
    public void shipOrder() {
        System.out.println("Shipping via Delhivery (India)");
    }
}
