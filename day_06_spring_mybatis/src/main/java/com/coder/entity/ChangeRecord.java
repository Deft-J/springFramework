package com.coder.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class ChangeRecord {
    private Integer id;
    private String account;
    private Date updateTime;
    private String category;
    private Integer num;
}
