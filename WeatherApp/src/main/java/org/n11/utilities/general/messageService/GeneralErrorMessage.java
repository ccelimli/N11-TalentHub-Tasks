package org.n11.utilities.general.messageService;

import lombok.Getter;
import org.n11.utilities.exceptions.ServiceUnavailableException;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
@Getter
public enum GeneralErrorMessage implements BaseErrorMessage {

    ITEM_NOT_FOUND("Item not found!"),
    BAD_REQUEST("Hatalı İstek"),
    SERVICE_UNAVAIBLE_EXCEPTION("Sunucu Hatası");



    private final String message;

    GeneralErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
