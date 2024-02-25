package org.n11.service.Imp;

import org.n11.dto.InvoiceDto;
import org.n11.entity.Invoice;
import org.n11.service.InvoiceService;
import org.n11.service.OrderService;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
public class InvoiceServiceImp implements InvoiceService {
    private List<Invoice> invoiceList;
    private OrderService orderService;
    public InvoiceServiceImp( OrderService orderService) {
        this.invoiceList = new ArrayList<>();
        this.orderService = orderService;
    }

    @Override
    public double getTotalInvoicesForJune() {

        return this.getAllInvoices()
                .stream()
                .filter(Invoice -> Invoice.getCreatedDate().getMonth().equals(Month.JUNE))
                .mapToDouble(invoice->invoice.getAmount()).sum();
    }

    @Override
    public List<InvoiceDto> getAllInvoices() {

        return invoiceList.stream()
                .map(invoice -> {
                    InvoiceDto dto = new InvoiceDto();
                    dto.setCreatedDate(invoice.getCreatedDate()); // Eğer bu özellik varsa
                    dto.setCustomerFirstName(orderService.getOrderById(invoice.getOrderId()).getFirstName());
                    dto.setCustomerLastName(orderService.getOrderById(invoice.getOrderId()).getLastName());
                    dto.setAmount(invoice.getAmount());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<InvoiceDto> getInvoicesOver1500() {
        return invoiceList.stream()
                .filter(invoice -> invoice.getAmount() > 1500)
                .map(invoice -> {
                    InvoiceDto dto = new InvoiceDto();
                    dto.setCreatedDate(invoice.getCreatedDate()); // Eğer bu özellik varsa
                    dto.setCustomerFirstName(orderService.getOrderById(invoice.getOrderId()).getFirstName());
                    dto.setCustomerLastName(orderService.getOrderById(invoice.getOrderId()).getLastName());
                    dto.setAmount(invoice.getAmount());
                    // Diğer özelliklerin atanması
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public double getAverageInvoicesOver1500() {
        return getAllInvoices().stream()
                .filter(invoice -> invoice.getAmount()>1500)
                .mapToDouble(invoice->invoice.getAmount())
                .average()
                .orElseThrow();
    }

    @Override
    public void add(Invoice invoice) {
        invoiceList.add(invoice);
    }
}
