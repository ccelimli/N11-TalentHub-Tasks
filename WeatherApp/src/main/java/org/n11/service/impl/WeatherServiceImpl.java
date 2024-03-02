package org.n11.service.impl;

import lombok.RequiredArgsConstructor;
import org.n11.constant.Constants;
import org.n11.constant.ErrorMessages.WeatherErrorMessage;
import org.n11.entity.dto.WeatherInfoDTO;
import org.n11.entity.enums.Frequency;
import org.n11.entity.request.WeatherInfoRequest;
import org.n11.service.WeatherService;
import org.n11.utilities.config.BaseRestClient;
import org.n11.utilities.exceptions.BusinessException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final BaseRestClient baseRestClient;


    @Override
    public WeatherInfoRequest getWeatherInfo(WeatherInfoRequest weatherInfoRequest) {
       try{
           String url=urlGenerator(weatherInfoRequest);
           return baseRestClient.getObject(url, WeatherInfoRequest.class);
       }catch (RestClientException error){
            throw new BusinessException(WeatherErrorMessage.NOT_VALID_API_KEY);
       }
    }

    private String urlGenerator(WeatherInfoRequest weatherInfoRequest){
        String queryByRequestParams=Constants.API_QUERY.getMessage()+weatherInfoRequest.city()+","+weatherInfoRequest.country();
        switch (weatherInfoRequest.frequency()){
            case Frequency.DAILY ->{
                return Constants.API_URL.getMessage()+
                       Constants.API_WEATHER.getMessage()+
                       queryByRequestParams+
                       Constants.API_KEY.getMessage()+
                       Constants.API_UNITS_PARAM.getMessage();
            }
            case Frequency.WEEKLY ->{
                return Constants.API_URL.getMessage()+
                       Constants.API_WEATHER.getMessage()+
                       queryByRequestParams+
                       Constants.API_PARAM_WEEKLY+
                       Constants.API_UNITS_PARAM.getMessage();
            }
            case Frequency.MONTHLY ->{
                return Constants.API_URL.getMessage()+
                       Constants.API_WEATHER.getMessage()+
                       queryByRequestParams+
                       Constants.API_PARAM_MONTHLY+
                       Constants.API_UNITS_PARAM.getMessage();
            }
            default -> throw new IllegalStateException("Unexpected value: " + weatherInfoRequest.frequency());
        }
    }
}