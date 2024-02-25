package org.n11.service.Imp;


import org.n11.dto.CustomerDto;
import org.n11.entity.Customer;
import org.n11.service.CustomerService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
public class CustomerServiceImp implements CustomerService {
    List<Customer> customerList;


    public CustomerServiceImp() {
        this.customerList= new ArrayList<>();
        customerList.add(new Customer(1L, "First", "Customer"));
        customerList.add(new Customer(2L, "Second", "Customer"));
        customerList.add(new Customer(3L, "Third", "Customer"));
        customerList.add(new Customer(4L, "Fourth", "Customer"));
        customerList.add(new Customer(5L, "Fiveth", "Customer"));
    }

    @Override
    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerList.stream()
                .map(customer -> {
                    CustomerDto dto = new CustomerDto();
                    dto.setFirstName(customer.getFirstName());
                    dto.setLastName(customer.getLastName());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerDto> getCustomersWithCName() {
        return customerList
                .stream()
                .filter(customer -> customer.getFirstName().startsWith("C"))
                .map(customer -> {
                    CustomerDto dto = new CustomerDto();
                    dto.setFirstName(customer.getFirstName());
                    dto.setLastName(customer.getLastName());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerDto> getCustomersWithInvoicesUnder500() {
        return customerList.stream()
                .filter(customer -> customer.getOrders().stream()
                        .anyMatch(order -> order.getAmount()<500)).map(customer -> {
                    CustomerDto dto = new CustomerDto();
                    dto.setFirstName(customer.getFirstName());
                    dto.setLastName(customer.getLastName());
                    return dto;
                })
                .collect(Collectors.toList());
    }


    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> optionalCustomer = customerList.stream().filter(customer -> customer.getId().equals(id)).findFirst();
        return optionalCustomer.orElseThrow();
    }

    @Override
    public List<CustomerDto> getCustomersWithInvoicesUnder750Average() {
        return customerList.stream()
                .filter(customer -> customer.getOrders().stream()
                        .anyMatch(order -> order.getAmount() < 750))
                .map(customer -> {
                    CustomerDto dto = new CustomerDto();
                    dto.setFirstName(customer.getFirstName());
                    dto.setLastName(customer.getLastName());
                    return dto;
                })
                .collect(toList());
    }

}
