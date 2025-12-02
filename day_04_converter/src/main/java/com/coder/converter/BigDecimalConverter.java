package com.coder.converter;

import org.springframework.core.convert.converter.Converter;

import java.math.BigDecimal;

public class BigDecimalConverter implements Converter<Double, BigDecimal> {

    @Override
    public BigDecimal convert(Double source) {
        if (source == null) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(source);
    }
}
