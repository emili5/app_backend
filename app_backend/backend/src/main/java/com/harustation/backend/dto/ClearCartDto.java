package com.harustation.backend.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// 장바구니 정보 전체 삭제
public class ClearCartDto {

    private Integer cart_idx;

    public ClearCartDto(){
        super();
    }

    public ClearCartDto(Integer cart_idx){
        super();
        this.cart_idx=cart_idx;
    }




}
