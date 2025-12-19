package com.creational.abstractfactory.shipping.usa;

import com.creational.abstractfactory.shipping.ShippingService;

public class FedexShippingService implements ShippingService {

    @Override
    public void shipOrder() {
        System.out.println("Shipping via FedEx (USA)");
    }
}
