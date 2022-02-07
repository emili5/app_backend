package com.harustation.backend.controller;

import com.harustation.backend.domain.Preference_folder;
import com.harustation.backend.domain.Product;
import com.harustation.backend.domain.Store;
import com.harustation.backend.dto.CreateFolderDto;
import com.harustation.backend.dto.SearchRequestDto;
import com.harustation.backend.dto.SearchResponseDto;
import com.harustation.backend.dto.StoreSearchResponseDto;
import com.harustation.backend.service.PreferenceService;
import com.harustation.backend.service.ProductService;
import com.harustation.backend.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.InvalidParameterException;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class SearchController {
    private final ProductService productService;
    private final PreferenceService preferenceService;
    private final StoreService storeService;

    @GetMapping("/search")
    public List<SearchResponseDto> searchProduct(@RequestBody SearchRequestDto searchRequestDto){
        if(searchRequestDto.getOrder_type()==null){
            return productService.findByProduct_name(searchRequestDto.getProduct_name());
        }
        else{
            //QueryDSL로 수정필요...
            switch (searchRequestDto.getOrder_type()){
                case "hit":
                    return productService.orderByProduct_hit(searchRequestDto.getProduct_name());
                case "recent":
                    return productService.orderByProduct_recent(searchRequestDto.getProduct_name());
                case "price":
                    return productService.orderByProduct_price(searchRequestDto.getProduct_name());
                case "price_desc":
                    return productService.orderByProduct_priceDesc(searchRequestDto.getProduct_name());
                default:throw new InvalidParameterException("invalid parameter");
            }
        }
    }


    //스토어 이름 검색
    @GetMapping("/search/store/{store_name}")
    public List<StoreSearchResponseDto> findStoreByName(@PathVariable("store_name")String store_name){
        return storeService.findStoreByName(store_name);
    }

    //SQL DB 구조 -> preference_folder 추가
    // preference 전체 리스트
    @GetMapping("/folder/list/{user_idx}")
    public List<Preference_folder> getPreferenceFolderList(@PathVariable("user_idx")Long user_idx){
        return preferenceService.getListByUser_idx(user_idx);
    }

    // preference 폴더 생성
    @PostMapping("/folder/create")
    public Long createFolderList(@RequestBody CreateFolderDto createFolderDto){
        return preferenceService.save(createFolderDto);
    }



}
