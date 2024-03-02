package org.n11.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.n11.entity.enums.Frequency;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */

public record WeatherInfoDTO(
        String country,
        String city,
        Frequency frequency,
        Double temperature,
        String main
) { }

