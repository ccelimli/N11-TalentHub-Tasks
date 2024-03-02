package org.n11.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.n11.entity.dto.WeatherInfoDTO;
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

    WeatherInfoDTO convertToWeatherDTO(WeatherInfoRequest weatherInfoRequest);
}
