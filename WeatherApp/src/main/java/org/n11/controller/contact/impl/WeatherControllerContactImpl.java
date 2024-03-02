package org.n11.controller.contact.impl;

import lombok.RequiredArgsConstructor;
import org.n11.controller.contact.WeatherControllerContact;
import org.n11.entity.Weather;
import org.n11.entity.dto.WeatherInfoDTO;
import org.n11.entity.request.WeatherInfoRequest;
import org.n11.service.WeatherService;
import org.n11.service.mapper.WeatherMapper;
import org.springframework.stereotype.Service;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
@Service
@RequiredArgsConstructor
public class WeatherControllerContactImpl implements WeatherControllerContact {
    private final WeatherService weatherService;

    @Override
    public WeatherInfoDTO getWeatherInfo(WeatherInfoRequest weatherInfoRequest) {
        Weather weather = weatherService.getWeatherInfo(weatherInfoRequest);
        return WeatherMapper.INSTANCE.convertToWeatherInfoDTO(weather);
    }

}
