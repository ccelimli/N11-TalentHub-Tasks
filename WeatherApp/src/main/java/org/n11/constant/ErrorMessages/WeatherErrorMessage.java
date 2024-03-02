package org.n11.constant.ErrorMessages;

import org.n11.utilities.general.messageService.BaseErrorMessage;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
public enum WeatherErrorMessage implements BaseErrorMessage {
    NOT_VALID_API_KEY("Not Valid Api Key");
    private final String message;

    WeatherErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
