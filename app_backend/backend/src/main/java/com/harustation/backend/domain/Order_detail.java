package com.harustation.backend.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Order_detail")
@Getter
public class Order_detail {
    @Id
    @GeneratedValue
    private Long order_detail_idx;
    private int product_count;
    private String product_price;
    private String product_status;
    private String product_discount;
    private String order_check;
}
