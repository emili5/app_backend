package com.harustation.backend.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchRequestDto {
    private String product_name;
    private String order_type;

    @Builder
    public SearchRequestDto(String product_name, String order_type){
        this.product_name=product_name;
        this.order_type=order_type;
    }
}
