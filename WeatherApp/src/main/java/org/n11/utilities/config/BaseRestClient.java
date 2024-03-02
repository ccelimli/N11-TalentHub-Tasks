package org.n11.utilities.config;

import org.springframework.http.ResponseEntity;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
public interface BaseRestClient {
    <T> ResponseEntity<T> getRequest(String url, Class<T> responseType);
    <T> T getObject(String url, Class<T> responseType);
    <T, R> ResponseEntity<T> postRequest(String url, R requestBody, Class<T> responseType);
}
