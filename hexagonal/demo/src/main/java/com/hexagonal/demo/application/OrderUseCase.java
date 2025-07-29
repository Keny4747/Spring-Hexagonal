package com.hexagonal.demo.application;

import com.hexagonal.demo.domain.Orders;
import com.hexagonal.demo.infra.outputport.EntityRepository;
import com.hexagonal.demo.infra.inputport.OrderInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class OrderUseCase implements OrderInputPort {

    @Autowired
    EntityRepository entityRepository;

    @Override
    public Orders createOrder(String customerId, BigDecimal total) {
        Orders order = Orders.builder()
                .id( UUID.randomUUID().toString() )
                .customerId( customerId )
                .total( total )
                .build();

        return entityRepository.save( order );
    }

}
