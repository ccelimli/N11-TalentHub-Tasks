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
public class Sys {
    private Integer type;
    private String country;
    private Integer sunrise;
    private Integer sunset;
}
