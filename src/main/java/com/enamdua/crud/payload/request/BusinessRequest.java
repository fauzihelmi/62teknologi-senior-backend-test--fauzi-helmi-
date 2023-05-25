package com.enamdua.crud.payload.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BusinessRequest {
    private String name, phone, address1, address2, address3, city, country, state, zipCode,
            displayPhone, imageUrl, price, url, transaction, alias, title, location;
    private Boolean isClosed;
    private Integer distance, rating, reviewCount, total;
    private BigDecimal latitude, longitude;
}
