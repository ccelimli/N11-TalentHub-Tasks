package org.n11.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Main {
    private Double temp;
    private Double feelsLike;
    private Double temMin;
    private Double tempMax;
    private Integer pressure;
    private Integer humidity;
}
