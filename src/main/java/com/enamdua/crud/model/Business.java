package com.enamdua.crud.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Data
@Table(name = "busines")
public class Business {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id", columnDefinition = "varchar DEFAULT uuid_generate_v4()")
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address1")
    private String address1;

    @Column(name = "address2")
    private String address2;

    @Column(name = "address3")
    private String address3;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "latitude")
    private BigDecimal latitude;

    @Column(name = "longitude")
    private BigDecimal longitude;

    @Column(name = "display_phone")
    private String displayPhone;

    @Column(name = "distance")
    private Integer distance;

    @Column(name = "image_url")
    private String imageuUrl;

    @Column(name = "is_closed")
    private Boolean isClosed;

    @Column(name = "price")
    private String price;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "review_count")
    private Integer reviewCount;

    @Column(name = "url")
    private String url;

    @Column(name = "total")
    private Integer total;

    @Column(name = "transaction")
    private String transaction;

    @Column(name = "alias")
    private String alias;

    @Column(name = "title")
    private String title;

    @Column(name = "location")
    private String location;

}
