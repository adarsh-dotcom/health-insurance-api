package com.healthinsurance.service;

import com.healthinsurance.dto.HospitalResponse;

import java.util.List;

public interface HospitalService {

    List<HospitalResponse> getAllHospitals();

    HospitalResponse getHospitalById(Long hospitalId);

    List<HospitalResponse> getNetworkHospitals();

    List<HospitalResponse> getHospitalsByCity(String city);

    List<HospitalResponse> getHospitalsByState(String state);

    List<HospitalResponse> getHospitalsByMinimumRating(Double minimumRating);
}