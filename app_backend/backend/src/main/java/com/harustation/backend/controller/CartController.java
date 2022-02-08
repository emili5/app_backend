package com.harustation.backend.controller;

import com.harustation.backend.domain.Cart;
import com.harustation.backend.domain.LoginInfo;
import com.harustation.backend.domain.Product;
import com.harustation.backend.dto.CartDto;
import com.harustation.backend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class CartController {
    //장바구니 정보
    private CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    //장바구니 전체 조회
    @GetMapping("/cart")
    public String getCartMain(@RequestParam int cart_idx, Model model) {
        Map<String, Object> map = cartService.cartSelectAll(cart_idx);

        model.addAttribute("cartList", map.get("cartList"));
        model.addAttribute("allTotalPrice", map.get("allTotalPrice"));

        return "/cart";
    }

    @PostMapping("/cart/delete")
    public String cartDelete(@RequestParam int user_idx, @RequestParam int product_delete, Model model) {
        List<Cart> cartList = cartService.deleteCart(user_idx, product_delete);

        model.addAttribute("cartList", cartList);
        return "";
    }

    //장바구니를 통한 구매
    @PostMapping("/order")
    public String createOrder(CartDto cartDto, Model model) {

        List<Cart> cartList = cartService.createOrder(cartDto);
        model.addAttribute("cartList", cartList);

        return "/order";

    }
    //결제 -> 상품 결제 테이블에 상품이 등록되면 장바구니에서 목록 삭제



}




