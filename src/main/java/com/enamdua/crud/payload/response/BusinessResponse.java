package com.enamdua.crud.payload.response;

import com.enamdua.crud.model.Business;
import lombok.Data;

import java.math.BigDecimal;
@Data
public class BusinessResponse {
    private String id, name, phone, address1, address2, address3, city, country, state, zipCode,
            displayPhone, imageUrl, price, url, transaction, alias, title, location;
    private Boolean isClosed;
    private Integer distance, rating, reviewCount, total;
    private BigDecimal latitude, longitude;

    public BusinessResponse(Business business) {
        this.id = business.getId();
        this.name = business.getName();
        this.phone = business.getPhone();
        this.address1 = business.getAddress1();
        this.address2 = business.getAddress2();
        this.address3 = business.getAddress3();
        this.city = business.getCity();
        this.country = business.getCountry();
        this.state = business.getState();
        this.zipCode = business.getZipCode();
        this.displayPhone = business.getDisplayPhone();
        this.imageUrl = business.getImageuUrl();
        this.price = business.getPrice();
        this.url = business.getUrl();
        this.transaction = business.getTransaction();
        this.alias = business.getAlias();
        this.title = business.getTitle();
        this.isClosed = business.getIsClosed();
        this.distance = business.getDistance();
        this.rating = business.getRating();
        this.reviewCount = business.getReviewCount();
        this.total = business.getTotal();
        this.latitude = business.getLatitude();
        this.longitude = business.getLongitude();
        this.location = business.getLocation();
    }
}
