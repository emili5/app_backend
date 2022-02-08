package com.harustation.backend.repository;

import com.harustation.backend.domain.Cart;
import com.harustation.backend.domain.Product;
import com.harustation.backend.dto.CartDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    //장바구니 생성
    int createCart(Cart cart);

    //장바구니 정보 확인
    int checkCart(int cart_idx);
    List<Cart> getCartAllList(int cart_idx);
    int cartGetTotalPrice(int cart_idx);
    int cartGetProductPrice(int product_idx);
    void cartDeleteAll(int cart_idx);
    int cartDeleteById(int cart_idx);
    int changeCartAmount(Cart cart);
    Cart cartSelectProduct(int user_idx,int product_idx);
    Product cartProductRemainAmount(int product_idx);
    Cart cartSelectAll(int user_idx,int product_idx);
    Cart cartPoint(int user_idx,int product_idx);
    Cart cartGetDeliveryfee(int user_idx, int product_idx);
    Cart cartProductDiscount(int product_idx);



}
