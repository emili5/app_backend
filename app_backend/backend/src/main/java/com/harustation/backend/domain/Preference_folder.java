package com.harustation.backend.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name="Preference_folder")
public class Preference_folder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long folder_idx;

    private String folder_name;
    private Long user_idx;

    @Builder
    public Preference_folder(Long folder_idx, String folder_name, Long user_idx){
        this.folder_idx=folder_idx;
        this.folder_name=folder_name;
        this.user_idx=user_idx;
    }

    public Preference_folder() {

    }
}
