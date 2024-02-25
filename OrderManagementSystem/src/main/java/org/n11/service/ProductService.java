package org.n11.service;

import org.n11.dto.ProductDto;
import org.n11.entity.Product;

import java.util.List;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
public interface ProductService {
    List<ProductDto> getProducts();
    List<Product> addSelectedProduct(Long... id);
    Product getProductById(Long id);


}
