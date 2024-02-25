package org.n11.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Invoice extends BaseEntity {
    private Long orderId;
    private double amount;
    private Long customerId;

    public Invoice(Long id, LocalDateTime createdDate,Long customerId, Long orderId, double amount) {
        super(id, createdDate);
        this.customerId=customerId;
        this.orderId = orderId;
        this.amount=amount;
    }
}
