package com.hexagonal.demo.infra.inputport;

import com.hexagonal.demo.domain.Orders;

import java.math.BigDecimal;

public interface OrderInputPort {
    public Orders createOrder(String customerId, BigDecimal total);
}
