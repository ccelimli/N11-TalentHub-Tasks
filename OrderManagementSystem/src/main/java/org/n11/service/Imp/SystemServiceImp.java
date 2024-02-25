package org.n11.service.Imp;

import org.n11.entity.Customer;
import org.n11.entity.Invoice;
import org.n11.entity.Order;
import org.n11.service.*;

import java.time.LocalDateTime;

import java.util.Scanner;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
public class SystemServiceImp implements SystemService {
    private final Scanner input = new Scanner(System.in);
    private final CustomerService customerService;
    private final OrderService orderService;
    private final ProductService productService;
    private final InvoiceService invoiceService;

    public SystemServiceImp(CustomerService customerService, OrderService orderService, ProductService productService, InvoiceService invoiceService) {
        this.customerService = customerService;
        this.orderService = orderService;
        this.productService = productService;
        this.invoiceService = invoiceService;
    }


    @Override
    public void start() {
        System.out.println("Hoşgeldiniz");

        while (true) {
            System.out.println("İşlemler");
            System.out.println("1 - Müşteri İşlemleri");
            System.out.println("2 - Fatura İşlemleri");
            System.out.println("3 - Sipariş İşlemleri");
            System.out.println("4 - Ürün İşlemleri");
            System.out.println("0 - Çıkış Yap");
            System.out.println("Seçim : ");

            int selectLoc = input.nextInt();

            switch (selectLoc) {
                case 0 -> {
                    System.out.println("Hoşçakal");
                    return;
                }
                case 1 -> selectedCustomer();
                case 2 -> selectedInvoice();
                case 3 -> selectedOrder();
                case 4 -> selectedProduct();
                default -> throw new IllegalStateException("Unexpected value: " + selectLoc);
            }
        }
    }

    private void selectedCustomer() {
        while (true) {
            System.out.println("1 - Müşterileri Ekle");
            System.out.println("2 - Müşterileri Listele");
            System.out.println("3 - Id'ye göre müşteri listele müşteriler");
            System.out.println("4 - C harfi ile başlayan müşteriler");
            System.out.println("5 - Faturası 500'ün altında olan müşteriler");
            System.out.println("6 - 750'nin altında olan müşterilerin ortalaması");
            System.out.println("0 - Çıkış Yap");

            int value = input.nextInt();
            while (value < 0 || value > 6) {
                System.out.println("Geçersiz değer");
                value = input.nextInt();
            }

            switch (value) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    System.out.println("Müşterini Id: ");
                    Long id = input.nextLong();
                    System.out.println("Müşteri Adı: ");
                    String firstName = input.next();
                    System.out.println("Müşteri Soyadı:");
                    String lastName = input.next();

                    customerService.addCustomer(new Customer(id, firstName, lastName));
                    System.out.println("Müşteri Eklendi");
                }
                case 2 -> System.out.println(customerService.getAllCustomers());
                case 3 -> {
                    System.out.println("Id: ");
                    Long id = input.nextLong();
                    customerService.getCustomerById(id);
                }
                case 4 -> customerService.getCustomersWithCName();
                case 5 -> customerService.getCustomersWithInvoicesUnder500();
                case 6 -> customerService.getCustomersWithInvoicesUnder750Average();

                default -> throw new IllegalStateException("Unexpected value: " + value);
            }
        }
    }

    private void selectedInvoice(){
        while (true) {
            System.out.println("1 - Faturaları Ekle");
            System.out.println("2 - Faturaları Listele");
            System.out.println("3 - Haziran Ayı Faturaların Toplamı");
            System.out.println("4 - 1500 üzeri faturaları listele");
            System.out.println("5 - 1500 üzeri faturaların ortalaması");
            System.out.println("0 - Çıkış Yap");

            int value = input.nextInt();
            while (value < 0 || value > 5) {
                System.out.println("Geçersiz değer");
                value = input.nextInt();
            }

            switch (value) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    System.out.println("Id: ");
                    Long id=input.nextLong();

                    LocalDateTime createdTime=LocalDateTime.now();

                    System.out.println("Müşterini Id: ");
                    Long customerId = input.nextLong();
                    System.out.println("Sipariş Id: ");
                    Long orderId = input.nextLong();
                    double amount= orderService.getOrderById(orderId).getAmount();


                    invoiceService.add(new Invoice(id,createdTime,customerId, orderId, amount));
                    System.out.println("Fatura Eklendi");
                }
                case 2 -> System.out.println(invoiceService.getAllInvoices());
                case 3 -> System.out.println(invoiceService.getTotalInvoicesForJune());
                case 4 -> System.out.println(invoiceService.getInvoicesOver1500());
                case 5 -> System.out.println(invoiceService.getAverageInvoicesOver1500());
                default -> throw new IllegalStateException("Unexpected value: " + value);
            }
        }
    }

    private void selectedOrder(){
        while (true) {
            System.out.println("1 - Sipariş Ekle");
            System.out.println("2 - Siparişleri Listele");
            System.out.println("3 - Id'ye Göre Sipariş Listele");
            System.out.println("0 - Çıkış Yap");

            int value = input.nextInt();
            while (value < 0 || value > 3) {
                System.out.println("Geçersiz değer");
                value = input.nextInt();
            }

            switch (value) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    Order order= new Order();
                    System.out.println("Id: ");
                    Long id=input.nextLong();

                    LocalDateTime createdTime=LocalDateTime.now();

                    System.out.println("Müşterini Id: ");
                    Long customerId = input.nextLong();

                    System.out.println("Ürün sayısı: ");
                    int productCount=input.nextInt();

                    System.out.println("Ürünler: ");
                    Long[] products=new Long[productCount];
                    for (int i=0; i<productCount;i++ ){
                        Long productId=input.nextLong();
                        products[i]= productId;
                    }

                    order.setProducts(productService.addSelectedProduct(products));

                    Long orderId = input.nextLong();
                    double amount= orderService.getOrderById(orderId).getAmount();

                    orderService.addOrder(order);
                    System.out.println("Sipariş Eklendi");
                }
                case 2 -> System.out.println(orderService.getOrders());
                case 3 -> {
                    System.out.println("Id: ");
                    Long id=input.nextLong();
                    System.out.println(orderService.getOrderById(id));}

                default -> throw new IllegalStateException("Unexpected value: " + value);
            }
        }
    }

    private void selectedProduct(){
        while (true) {
            System.out.println("1 - Ürünleri Listele");
            System.out.println("0 - Çıkış Yap");

            int value = input.nextInt();
            while (value < 0 || value > 2) {
                System.out.println("Geçersiz değer");
                value = input.nextInt();
            }

            switch (value) {
                case 0 -> {
                    return;
                }
                case 1 -> System.out.println(productService.getProducts());

                case 2 -> {
                    System.out.println("Id:");
                    Long productId= input.nextLong();
                    System.out.println(productService.getProductById(productId));
                }
                default -> throw new IllegalStateException("Unexpected value: " + value);
            }
        }
    }
}

