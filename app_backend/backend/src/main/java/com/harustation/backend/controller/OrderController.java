package com.harustation.backend.controller;

import com.harustation.backend.domain.Product;
import com.harustation.backend.domain.User;
import com.harustation.backend.dto.SearchResponseDto;
import com.harustation.backend.repository.ProductRepository;
import com.harustation.backend.service.OrderService;
import com.harustation.backend.service.ProductService;
import com.harustation.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@RequiredArgsConstructor
public class OrderController {

    private OrderService orderService;
    private UserService userService;
    private ProductService productService;

    @GetMapping(value = "/order")
    public String createForm(Model model) {

        List<User> users = userService.findMembers();
        List<SearchResponseDto> products = productService.findByProduct_name(ProductRepository.class.getName());

        model.addAttribute("Users", users);
        model.addAttribute("Products", products);

        return "order/orderForm";
    }
    @PostMapping(value = "/order")
    public String order(){
        return "";
    }

}
