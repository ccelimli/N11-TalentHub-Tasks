package org.n11.controller.contact;

import org.n11.entity.dto.WeatherInfoDTO;
import org.n11.entity.request.WeatherInfoRequest;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
public interface WeatherControllerContact {
    WeatherInfoDTO getWeatherInfo(WeatherInfoRequest weatherInfoRequest);
}
