package com.creational.abstractfactory.without.ecommerce.shipping.india;

import com.creational.abstractfactory.without.ecommerce.shipping.ShippingService;

public class DelhiveryShippingService implements ShippingService {

    @Override
    public void shipOrder() {
        System.out.println("Shipping via Delhivery (India)");
    }
}
