package com.harustation.backend.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
//수정 필요
public class CartDto {
    private int user_idx;
    private int cart_idx;
    private String product_count;
    private String product_delete;
    private String product_change;
    private String product_discount;
    private String product_totalprice;
    private String deliveryfee;
    private String after_point;
    private int Product_product_number;
    private List<CartDto> cartList;


}
