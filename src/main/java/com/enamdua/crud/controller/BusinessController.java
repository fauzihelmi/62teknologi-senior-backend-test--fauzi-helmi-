package com.enamdua.crud.controller;

import com.enamdua.crud.exception.BadRequestException;
import com.enamdua.crud.exception.ResourceNotFoundException;
import com.enamdua.crud.payload.request.BusinessRequest;
import com.enamdua.crud.payload.response.ResponseHandler;
import com.enamdua.crud.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/business")
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @PostMapping()
    public ResponseEntity<?> saveBusiness(@RequestBody BusinessRequest businessrequest) {
        try {
            return ResponseEntity.ok(businessService.saveBusiness(businessrequest));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping()
    public ResponseEntity<?> updateBusiness(@RequestParam(value = "id") String id,
                                            @RequestBody BusinessRequest businessrequest) {
        try {
            return ResponseEntity.ok(businessService.updateBusiness(id, businessrequest));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteBusiness(@RequestParam(value = "id") String id) {
        try {
            businessService.deleteBusiness(id);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping()
    public ResponseEntity<Object> getBusiness(@RequestParam(value = "location") String location,
                                            @RequestParam(value = "latitude") BigDecimal latitude,
                                            @RequestParam(value = "longitude") BigDecimal longitude,
                                            @RequestParam(value = "price") String price,
                                            @RequestParam(value = "rating")  Integer rating) {
        try {
            return ResponseHandler.generateResponse(businessService.getDataBusiness(location, latitude, longitude,
                            price, rating),"Successfully retrieved data!", HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (BadRequestException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
