package org.n11.service;

import org.n11.dto.CustomerDto;
import org.n11.dto.InvoiceDto;
import org.n11.entity.Customer;

import java.time.LocalDate;
import java.util.List;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
public interface CustomerService {
    void addCustomer(Customer customer);
    List<CustomerDto> getAllCustomers();
    List<CustomerDto> getCustomersWithCName();
    List<CustomerDto> getCustomersWithInvoicesUnder500();
    Customer getCustomerById(Long id);
    List<CustomerDto> getCustomersWithInvoicesUnder750Average();



}
