package com.healthinsurance.controller;

import com.healthinsurance.dto.HospitalResponse;
import com.healthinsurance.service.HospitalService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/hospitals")
public class HospitalController {
    private final HospitalService service;
    public HospitalController(HospitalService service){this.service=service;}

    @GetMapping public List<HospitalResponse> getAllHospitals(){return service.getAllHospitals();}
    @GetMapping("/{hospitalId}") public HospitalResponse getHospitalById(@PathVariable Long hospitalId){return service.getHospitalById(hospitalId);}
    @GetMapping("/network") public List<HospitalResponse> getNetworkHospitals(){return service.getNetworkHospitals();}
    @GetMapping("/city/{city}") public List<HospitalResponse> getHospitalsByCity(@PathVariable String city){return service.getHospitalsByCity(city);}
    @GetMapping("/state/{state}") public List<HospitalResponse> getHospitalsByState(@PathVariable String state){return service.getHospitalsByState(state);}
    @GetMapping("/rating") public List<HospitalResponse> getHospitalsByMinimumRating(@RequestParam Double rating){return service.getHospitalsByMinimumRating(rating);}
}
