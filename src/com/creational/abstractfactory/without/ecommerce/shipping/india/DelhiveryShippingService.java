package com.creational.abstractfactory.shipping.india;

import com.creational.abstractfactory.shipping.ShippingService;

public class DelhiveryShippingService implements ShippingService {

    @Override
    public void shipOrder() {
        System.out.println("Shipping via Delhivery (India)");
    }
}
