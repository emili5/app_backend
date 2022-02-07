package com.harustation.backend.controller;

import com.harustation.backend.domain.Product;
import com.harustation.backend.domain.User;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bucket/product/list")
public class BucketController {

    @Autowired
    private Product product;

    @Autowired
    private User user;

    //장바구니 상품 추가
    public ResponseEntity<Message> insertBucket(@RequestBody Product product) {

        Message message = new Message() {
            @Override
            public String getFormattedMessage() {
                return null;
            }

            @Override
            public String getFormat() {
                return null;
            }

            @Override
            public Object[] getParameters() {
                return new Object[0];
            }

            @Override
            public Throwable getThrowable() {
                return null;
            }
        };


        return null;
    }
}
