package com.harustation.backend.service;

import com.harustation.backend.domain.Product;
import com.harustation.backend.dto.SearchResponseDto;
import com.harustation.backend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public List<SearchResponseDto> responseListMaker(List<Product> productList){
        List<SearchResponseDto> searchResponseDtoList=new ArrayList<>();

        for(Product product : productList){
            SearchResponseDto searchResponseDto = SearchResponseDto.builder()
                    .product_name(product.getProduct_name())
                    .product_image(product.getProduct_image())
                    .discount_rate(product.getProduct_discount())
                    .build();

            searchResponseDtoList.add(searchResponseDto);
        }
        return searchResponseDtoList;
    }

    @Transactional
    public List<SearchResponseDto> findByProduct_name(String product_name){
        List<Product> productList = productRepository.getProductByProduct_nameContaining(product_name);
        return responseListMaker(productList);

    }

    @Transactional
    public List<SearchResponseDto> orderByProduct_hit(String product_name){
        List<Product> productList= productRepository.orderProductByProduct_hit(product_name);
        return responseListMaker(productList);
    }

    @Transactional
    public List<SearchResponseDto> orderByProduct_recent(String product_name){
        List<Product> productList=productRepository.orderProductByProduct_createdate(product_name);
        return responseListMaker(productList);

    }

    @Transactional
    public List<SearchResponseDto> orderByProduct_price(String product_name){
        List<Product> productList=productRepository.orderProductByProduct_price(product_name);
        return responseListMaker(productList);

    }

    @Transactional
    public List<SearchResponseDto> orderByProduct_priceDesc(String product_name){
        List<Product> productList=productRepository.orderProductByProduct_priceDesc(product_name);
        return responseListMaker(productList);

    }
}
