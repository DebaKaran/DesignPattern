package com.creational.abstractfactory.services.shipping.usa;

import com.creational.abstractfactory.services.shipping.ShippingService;

public class FedexShippingService implements ShippingService {

    @Override
    public void shipOrder() {
        System.out.println("Shipping via FedEx (USA)");
    }
}
