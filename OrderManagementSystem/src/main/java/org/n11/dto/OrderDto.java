package org.n11.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.n11.entity.Product;

import java.time.LocalDateTime;
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
public class OrderDto {
    public String firstName;
    public String lastName;
    public List<ProductDto> products;
    public Double amount;
    public LocalDateTime localDateTime;

    @Override
    public String toString() {
        return
               "firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", products=" + products +
               ", amount=" + amount +
               ", localDateTime=" + localDateTime;
    }
}

