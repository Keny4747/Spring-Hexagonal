package com.hexagonal.demo.domain;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Customer {
    private String id;
    private String name;
    private String country;
}
