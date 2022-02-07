package com.harustation.backend.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StoreSearchResponseDto {
    private String store_name;
    private String store_thumbnail;
    private String hashtag1;
    private String hashtag2;

    @Builder
    private StoreSearchResponseDto(String store_name, String store_thumbnail, String hashtag1, String hashtag2){
        this.store_name=store_name;
        this.store_thumbnail=store_thumbnail;
        this.hashtag1=hashtag1;
        this.hashtag2=hashtag2;
    }
}
