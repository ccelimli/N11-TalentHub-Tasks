package org.n11.constant;


import org.springframework.beans.factory.annotation.Value;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
public enum Constants {
    API_URL("http://api.openweathermap.org/data/2.5/"),
    API_WEATHER("weather?"),
    API_KEY("&appid="+"f691373bdb98d39b09e90cff4b4c2307"),
    API_QUERY("q="),
    API_UNITS_PARAM("&units=metric"),
    API_PARAM_WEEKLY("&cnt=7"),
    API_PARAM_MONTHLY("&cnt=30");


    private final String message;

    Constants(String message){
        this.message=message;
    }

    public String getMessage() {
        return this.message;
    }

}
