package org.n11.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Order extends BaseEntity{
    private Long customerId;
    private List<Product> products;
    private Double amount;

    public Order(Long id, LocalDateTime createdDate,Long customerId, List<Product> products,Double amount) {
        super(id, createdDate);
        this.customerId=customerId;
        this.products = products;
        this.amount=amount;
    }
}
