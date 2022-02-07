package com.harustation.backend.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "Product")
@Getter
public class Product {
    @Id
    @GeneratedValue
    private Long product_idx;
    private String product_name;
    private String product_contents;
    private String product_Price;
    private String product_stock;
    private String product_image;
    private Timestamp create_date;
    private Integer product_hit;
    private Integer review_count;
    private Integer product_discount;
}
