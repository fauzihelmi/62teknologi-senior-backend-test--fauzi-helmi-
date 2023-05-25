package com.enamdua.crud.service;

import com.enamdua.crud.model.Business;
import com.enamdua.crud.payload.request.BusinessRequest;
import com.enamdua.crud.payload.response.BusinessResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface BusinessService {

    Business saveBusiness(BusinessRequest businessrequest);

    Business updateBusiness(String id, BusinessRequest businessrequest);

    void deleteBusiness(String id);

    List<BusinessResponse> getDataBusiness(String location, BigDecimal latitude,
                                           BigDecimal longitude, String price, Integer rating);
}
