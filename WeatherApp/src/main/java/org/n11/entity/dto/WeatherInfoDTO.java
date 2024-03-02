package org.n11.entity.dto;


import java.util.List;
import java.util.TimeZone;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */

public record WeatherInfoDTO(
        String city,
        String country,
        String temperature,
        String mainStatus
) { }

