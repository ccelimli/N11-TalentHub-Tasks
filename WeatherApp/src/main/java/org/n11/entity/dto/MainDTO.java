package org.n11.entity.dto;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
public record MainDTO(
        Double temp,
        Double feels_like,
        Double temp_min,
        Double temp_max,
        Integer pressure,
        Integer humidity
) {
}
