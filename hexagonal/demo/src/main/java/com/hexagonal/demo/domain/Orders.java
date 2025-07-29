package com.hexagonal.demo.domain;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Builder
@Data
public class Orders {
    private String id;
    private String customerId;
    private BigDecimal total;
}
