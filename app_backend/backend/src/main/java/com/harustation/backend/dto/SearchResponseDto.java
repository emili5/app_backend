package com.harustation.backend.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchResponseDto {
    private String product_image;
    private int discount_rate;
    private int price;
    private String product_name;
    private String store_name;

    @Builder
    public SearchResponseDto(String product_image, int discount_rate, int price, String product_name, String store_name){
        this.product_image=product_image;
        this.discount_rate=discount_rate;
        this.price=price;
        this.product_name=product_name;
        this.store_name=store_name;
    }
}
