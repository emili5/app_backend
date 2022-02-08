package com.harustation.backend.service;

import com.harustation.backend.domain.Product;
import com.harustation.backend.domain.Store;
import com.harustation.backend.dto.SearchResponseDto;
import com.harustation.backend.dto.StoreSearchResponseDto;
import com.harustation.backend.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class StoreService {
    private final StoreRepository storeRepository;

    public List<StoreSearchResponseDto> responseListMaker(List<Store> storeList){
        List<StoreSearchResponseDto> storeSearchResponseDtoList=new ArrayList<>();

        for(Store store : storeList){
            StoreSearchResponseDto storeSearchResponseDto= StoreSearchResponseDto.builder()
                    .store_name(store.getStore_name())
                    .store_thumbnail(store.getStore_image())
                    .hashtag1(store.getStore_hashtag())
                    .hashtag2("example")
                    .build();

            storeSearchResponseDtoList.add(storeSearchResponseDto);
        }
        return storeSearchResponseDtoList;
    }

    @Transactional
    public List<StoreSearchResponseDto> findStoreByName(String storeName){
        List<Store> storeList=storeRepository.findStoreByStore_nameContaining(storeName);
        return responseListMaker(storeList);
    }

}
