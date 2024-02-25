package org.n11.service;

import org.n11.dto.OrderDto;
import org.n11.entity.Order;
import org.n11.entity.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2024 Çağatay Çelimli
 * All rights reserved.
 *
 * @author cceli
 */
public interface OrderService {
    void addOrder(Order order);
     List<OrderDto> getOrders();
     OrderDto getOrderById(Long id);
}
