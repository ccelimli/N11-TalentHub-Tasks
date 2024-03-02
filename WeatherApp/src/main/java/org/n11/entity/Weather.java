package org.n11.entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.n11.entity.enums.TimeZone;

import java.util.List;

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
public class Weather {
    private Coord coord;
    private String base;
    private Main main;
    private Integer visibility;
    private Wind wind;
    private Clouds clouds;
    private Integer dt;
    private Sys sys;
    @Enumerated(EnumType.STRING)
    private TimeZone timezone;
    private String name;
    private Integer cod;
}
