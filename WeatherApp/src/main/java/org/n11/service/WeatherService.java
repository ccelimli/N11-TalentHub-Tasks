package org.n11.service;

import org.n11.entity.dto.WeatherInfoDTO;
import org.n11.entity.request.WeatherInfoRequest;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
public interface WeatherService {
    public WeatherInfoRequest getWeatherInfo(WeatherInfoRequest weatherInfoRequest);
}
