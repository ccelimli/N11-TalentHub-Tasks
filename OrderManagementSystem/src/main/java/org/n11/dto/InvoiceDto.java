package org.n11.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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
public class InvoiceDto {
    public String customerFirstName;
    public String customerLastName;
    public Long orderId;
    public LocalDateTime createdDate;
    public Double amount;

    @Override
    public String toString() {
        return "FirstName='" + customerFirstName +
               " LastName='" + customerLastName +
               " OrderId=" + orderId +
               " CreatedDate=" + createdDate +
               " Amount=" + amount;
    }
}
