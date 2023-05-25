package com.enamdua.crud.repository;

import com.enamdua.crud.dto.BusinessDTO;
import com.enamdua.crud.model.Business;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface BusinessRepository extends JpaRepository<Business, String> {

    @Query(value = "SELECT name FROM busines WHERE name = :name", nativeQuery = true)
    List<BusinessDTO> getDataByName(String name);

    @Query(value = "SELECT * FROM busines WHERE location = :location and " +
            "latitude = :latitude and longitude = :longitude and price = :price and rating = :rating ", nativeQuery = true)
    List<Business> getDataByParameters(String location, BigDecimal latitude,
                                          BigDecimal longitude, String price, Integer rating);
}
