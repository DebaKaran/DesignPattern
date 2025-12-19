package com.creational.abstractfactory.without.ecommerce.shipping.usa;

import com.creational.abstractfactory.without.ecommerce.shipping.ShippingService;

public class FedexShippingService implements ShippingService {

    @Override
    public void shipOrder() {
        System.out.println("Shipping via FedEx (USA)");
    }
}
