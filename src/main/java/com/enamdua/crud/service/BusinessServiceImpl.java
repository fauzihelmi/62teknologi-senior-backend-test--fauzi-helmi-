package com.enamdua.crud.service;

import com.enamdua.crud.dto.BusinessDTO;
import com.enamdua.crud.exception.BadRequestException;
import com.enamdua.crud.exception.ResourceNotFoundException;
import com.enamdua.crud.model.Business;
import com.enamdua.crud.payload.request.BusinessRequest;
import com.enamdua.crud.payload.response.BusinessResponse;
import com.enamdua.crud.repository.BusinessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class BusinessServiceImpl implements BusinessService{

    @Autowired
    BusinessRepository businessRepository;

    private Business findById(String id) {
        return businessRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(Business.class.getSimpleName(), id));
    }

    @Override
    public Business saveBusiness(BusinessRequest businessrequest) {
        List<BusinessDTO> businessDTOS = businessRepository.getDataByName(businessrequest.getName());
        Business business = new Business();
        if (businessDTOS.isEmpty()) {
            setData(businessrequest, business);
        } else {
            throw new BadRequestException(businessrequest.getName(),"Already Exist");
        }
        return business;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Business updateBusiness(String id, BusinessRequest businessrequest) {
        Business business = findById(id);
        if (business.getId() != null) {
            setData(businessrequest, business);
        }
        return business;
    }

    @Transactional
    @Override
    public void deleteBusiness(String id) {
        Business business = findById(id);
        if (business.getId() != null) {
            businessRepository.delete(business);
        }
    }

    @Override
    public List<BusinessResponse> getDataBusiness(String location, BigDecimal latitude,
                                            BigDecimal longitude, String price, Integer rating) {
        List<Business> businessList = businessRepository.getDataByParameters(location, latitude,
                longitude, price, rating);
        List<BusinessResponse> businessResponses = new ArrayList<>();
        businessList.forEach((data) -> {
            BusinessResponse businessResponse = new BusinessResponse(data);
            businessResponses.add(businessResponse);
        });
        return businessResponses;
    }

    private void setData(BusinessRequest businessrequest, Business business) {
        business.setName(businessrequest.getName());
        business.setAddress1(businessrequest.getAddress1());
        business.setAddress2(businessrequest.getAddress2());
        business.setAddress3(businessrequest.getAddress3());
        business.setPhone(businessrequest.getPhone());
        business.setCity(businessrequest.getCity());
        business.setAlias(businessrequest.getAlias());
        business.setCountry(businessrequest.getCountry());
        business.setDisplayPhone(businessrequest.getDisplayPhone());
        business.setReviewCount(businessrequest.getReviewCount());
        business.setState(businessrequest.getState());
        business.setZipCode(businessrequest.getZipCode());
        business.setLatitude(businessrequest.getLatitude());
        business.setLongitude(businessrequest.getLongitude());
        business.setDistance(businessrequest.getDistance());
        business.setDistance(businessrequest.getDistance());
        business.setImageuUrl(businessrequest.getImageUrl());
        business.setIsClosed(businessrequest.getIsClosed());
        business.setPrice(businessrequest.getPrice());
        business.setRating(businessrequest.getRating());
        business.setUrl(businessrequest.getUrl());
        business.setTotal(businessrequest.getTotal());
        business.setTransaction(businessrequest.getTransaction());
        business.setTitle(businessrequest.getTitle());
        business.setLocation(businessrequest.getLocation());
        businessRepository.save(business);
    }
}
