package org.n11.dto;

import lombok.*;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter

public class CustomerDto {
    public String firstName;
    public String lastName;

    @Override
    public String toString() {
        return " Ad Soyad='" + firstName + " " + lastName + '\'';
    }
}
