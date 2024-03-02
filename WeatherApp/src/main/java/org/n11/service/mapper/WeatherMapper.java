package org.n11.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.n11.entity.*;
import org.n11.entity.dto.*;
import org.n11.entity.request.WeatherInfoRequest;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface WeatherMapper {
    WeatherMapper INSTANCE = Mappers.getMapper(WeatherMapper.class);

    Weather convertToWeather(WeatherInfoRequest weatherInfoRequest);

    @Mapping(target = "city", source = "name")
    @Mapping(target = "country", source = "sys.country")
    @Mapping(target = "temperature", source = "main.temp")
    WeatherInfoDTO convertToWeatherInfoDTO(Weather weather);

}
