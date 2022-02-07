package com.harustation.backend.dto;

import com.harustation.backend.domain.Preference_folder;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateFolderDto {
    private String folder_name;
    private Long user_idx;

    @Builder
    public CreateFolderDto(String folder_name, Long user_idx){
        this.folder_name=folder_name;
        this.user_idx=user_idx;
    }

    public Preference_folder toEntity(){
        return Preference_folder.builder()
                .folder_name(folder_name)
                .user_idx(user_idx)
                .build();

    }
}
