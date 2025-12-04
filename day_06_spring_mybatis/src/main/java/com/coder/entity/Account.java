package com.coder.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Account {
    private Integer id;
    private String account;
    private String password;
    private Integer coupon;
}
