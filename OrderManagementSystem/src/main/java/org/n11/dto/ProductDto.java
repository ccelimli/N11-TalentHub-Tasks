package org.n11.dto;

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
public class ProductDto {
    public String name;
    public double amount;

    @Override
    public String toString() {
        return
               "name='" + name + '\'' +
               ", amount=" + amount;
    }
}
