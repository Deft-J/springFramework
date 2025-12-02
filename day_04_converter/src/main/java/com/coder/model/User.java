package com.coder.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class User {
    private String name;
    private BigDecimal salary;
}