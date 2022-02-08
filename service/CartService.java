package com.harustation.backend.service;

import com.harustation.backend.domain.Cart;
import com.harustation.backend.domain.Product;
import com.harustation.backend.dto.CartDto;
import com.harustation.backend.repository.CartRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static java.lang.Long.valueOf;
import static sun.jvm.hotspot.runtime.BasicObjectLock.size;

@Service("CartService")
public class CartService {
    private CartRepository cartRepository;

    public CartService(CartRepository cartRepository){
        this.cartRepository=cartRepository;
    }

    public int createCart(Cart cart){
        int result=0;
        //장바구니에 담기 전 상품이 있는지 먼저 조회
        Cart cartOld = cartRepository.cartSelectProduct(cart.getUser_idx(),cart.getProduct_idx());
        //장바구니가 비어있지 않은 경우
        if(cartOld!=null) {
            //장바구니에 등록되어 있지 않은 상품일 경우
            if (cartOld.getUser_idx() != cart.getUser_idx() || cartOld.getProduct_idx() != cart.getProduct_idx()) {
                result = cartRepository.createCart(cart);
            }
            //장바구니가 비어있는 경우
        }else{
            result = cartRepository.createCart(cart);
        }
        return result;
    }
    public Map<String,Object> cartSelectAll(int user_idx){
        Map<String,Object> map = new HashMap<>();
        List<Cart>cartList = new ArrayList<>();
        String allTotalPrice =String.valueOf(0) ;

        cartList = cartRepository.getCartAllList(user_idx);
        for(int i=0 ; i<cartList.size();i++){
            //cartList.get(i).setProduct_totalprice(cartList.get(i).getProduct().getProduct_Price())*cartList.get(i).getProduct_count());
            allTotalPrice+=cartList.get(i).getProduct_totalprice();
        }
        map.put("cartList",cartList);
        map.put("allTotalPruce",allTotalPrice);
        return map;
    }
    //수량 수정
    public Map<String, Object> changeCartAmount(Cart cart) {
        int result = cartRepository.changeCartAmount(cart);
        Map<String, Object> map = new HashMap<>();
        String allTotalPrice =String.valueOf(0);
        List<Cart> cartList = new ArrayList<>();
        if(result>0) {
            cartList =cartRepository.getCartAllList(cart.getUser_idx());
            for(int i=0; i<cartList.size(); i++) {
                //cartList.get(i).setProduct_totalprice(cartList.get(i).getProduct().getProduct_Price())*cartList.get(i).getProduct_count());
                allTotalPrice+=cartList.get(i).getProduct_totalprice();
            }
            map.put("cartList", cartList);
            map.put("allTotalPrice", allTotalPrice);

        }
        return map;
    }
    //장바구니에서 목록 삭제
    public List<Cart> deleteCart(int user_idx, int product_delete) {
        int result = cartRepository.cartDeleteById(product_delete);
        List<Cart> cartList = new ArrayList<>();
        if(result>0) {
            cartList = cartRepository.getCartAllList(user_idx);
            for(int i=0; i<cartList.size(); i++) {
                //cartList .get(i).setProduct_totalprice(cartList .get(i).getProduct().getProduct_Price()*cartList .get(i).getProduct_count());
            }


        }
        return cartList;
    }

    public List<Cart> createOrder(CartDto cartDto) {
        List<Cart> cartList = new ArrayList<>();
        for(int i=0; i<cartDto.getCartList().size(); i++) {
            Cart cart =cartRepository.cartSelectAll(cartDto.getCartList().get(i).getUser_idx(),
                    cartDto.getCartList().get(i).getCart_idx());
            cartList.add(cart);
        }

        return cartList;
    }
    //실시간 제품 잔여재고 조회
    public Product cartProductRemainAmount(int product_idx){
        Product product = cartRepository.cartProductRemainAmount(product_idx);
        return product;
    }


    //주문완료내역 입력

    //제품 주문 후 주문한 장바구니에서 삭제








}
