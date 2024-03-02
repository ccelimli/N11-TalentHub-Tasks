package org.n11.entity.request;

import jakarta.validation.constraints.NotNull;
import org.n11.entity.enums.Frequency;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */

public record WeatherInfoRequest(
        @NotNull
        String country,
        @NotNull
        String city,
        @NotNull
        Frequency frequency) {

}
