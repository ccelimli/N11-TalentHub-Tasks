package org.n11.controller;

import lombok.RequiredArgsConstructor;
import org.n11.controller.contact.WeatherControllerContact;
import org.n11.entity.dto.WeatherInfoDTO;
import org.n11.entity.request.WeatherInfoRequest;
import org.n11.utilities.general.entity.RestResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/weathers")
public class WeatherController {
    private final WeatherControllerContact weatherControllerContact;


    @PostMapping
    public ResponseEntity<RestResponse<WeatherInfoDTO>> getWeather(@RequestBody WeatherInfoRequest weatherInfoRequest){
        return ResponseEntity.ok(RestResponse.of(weatherControllerContact.getWeatherInfo(weatherInfoRequest)));
    }
}
