package org.n11.service;

import org.n11.dto.InvoiceDto;
import org.n11.entity.Customer;
import org.n11.entity.Invoice;
import org.n11.entity.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
public interface InvoiceService {
    double getTotalInvoicesForJune();
    List<InvoiceDto> getAllInvoices();
    List<InvoiceDto> getInvoicesOver1500();
    double getAverageInvoicesOver1500();
    void add(Invoice invoice);


}
