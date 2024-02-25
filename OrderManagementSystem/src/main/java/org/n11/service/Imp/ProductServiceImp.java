package org.n11.service.Imp;

import org.n11.dto.ProductDto;
import org.n11.entity.Product;
import org.n11.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Copyright (c) 2024
 * All rights reserved.
 *
 * @author Çağatay Çelimli
 */
public class ProductServiceImp implements ProductService {
    private List<Product> productList;
    private List<Product> selectedProduct;

    public ProductServiceImp() {
        this.productList = new ArrayList<>();
        this.selectedProduct = new ArrayList<>();
    }
     @Override
    public List<ProductDto> getProducts(){
        return productList.stream()
                .map(product -> {
                    ProductDto dto = new ProductDto();
                    dto.setName(product.getName());
                    dto.setAmount(product.getPrice());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Product getProductById(Long id) {
      return productList.stream().filter(product -> product.getId().equals(id)).findFirst().orElseThrow();
    }

    @Override
    public List<Product> addSelectedProduct(Long... id){
        for (Long itemId : id){
            selectedProduct.add(getProductById(itemId));
        }
        return selectedProduct;
    }


}
