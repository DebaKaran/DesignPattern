package com.creational.abstractfactory.without.ecommerce.shipping.europe;

import com.creational.abstractfactory.without.ecommerce.shipping.ShippingService;

public class DhlShippingService implements ShippingService {

    @Override
    public void shipOrder() {
        System.out.println("Shipping via DHL (Europe)");
    }
}
