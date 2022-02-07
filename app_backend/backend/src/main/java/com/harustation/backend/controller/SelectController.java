package com.harustation.backend.controller;

import com.harustation.backend.domain.Product;
import com.harustation.backend.repository.ProductRepository;
import com.harustation.backend.service.ProductService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public class SelectController {

    @Autowired
    private Product product;


}
