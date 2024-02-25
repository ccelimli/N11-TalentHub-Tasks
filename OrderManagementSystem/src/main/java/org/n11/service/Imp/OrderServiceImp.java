package org.n11.service.Imp;

import org.n11.dto.OrderDto;
import org.n11.dto.ProductDto;
import org.n11.entity.Order;
import org.n11.entity.Product;
import org.n11.service.OrderService;
import org.n11.service.ProductService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
public class OrderServiceImp implements OrderService {
    private ProductService productService;
    List<Order> orderList;

    public OrderServiceImp(ProductService productService) {
        this.productService = productService;
        this.orderList= new ArrayList<>();
    }

    @Override
    public void addOrder(Order order) {
        orderList.add(order);
    }

    @Override
    public List<OrderDto> getOrders() {
        return orderList.stream()
                .map(order -> {
                    OrderDto dto = new OrderDto();
                    List<ProductDto> productDtos = order.getProducts().stream()
                            .map(product -> {
                                ProductDto productDto = new ProductDto();
                                productDto.setName(product.getName());
                                productDto.setAmount(product.getPrice());
                                return productDto;
                            })
                            .collect(Collectors.toList());
                    dto.setProducts(productDtos);
                    dto.setAmount(order.getAmount());
                    // Diğer özelliklerin atanması
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto getOrderById(Long orderId){
        Optional<Order> optionalOrder = orderList.stream()
                .filter(order -> order.getId().equals(orderId))
                .findFirst(); // İlk bulunan siparişi almak için findFirst() kullanıyoruz

        OrderDto dto = optionalOrder.map(order -> {
            OrderDto orderDto = new OrderDto();
            List<ProductDto> productDtos = order.getProducts().stream()
                    .map(product -> {
                        ProductDto productDto = new ProductDto();
                        productDto.setName(product.getName());
                        productDto.setAmount(product.getPrice());
                        return productDto;
                    })
                    .collect(Collectors.toList());

            orderDto.setProducts(productDtos);
            orderDto.setAmount(order.getAmount());
            // Diğer özelliklerin atanması
            return orderDto;
        }).orElseThrow(() -> new NoSuchElementException("Sipariş bulunamadı")); // Bulunamayan durumda NoSuchElementException fırlatılır

        return dto;
    }
    private double calculatorAmount(List<Product> productList){
        return productList.stream().mapToDouble(Product::getPrice).sum();
    }
}
