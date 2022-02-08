package com.harustation.backend.controller;

import com.harustation.backend.domain.Preference;
import com.harustation.backend.domain.Preference_folder;
import com.harustation.backend.repository.PreferenceRepository;
import com.harustation.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public class PreferenceController {

    @Autowired
    private PreferenceRepository preferenceRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Preference_folder> findAll(){
        return preferenceRepository.findAll();
    }


    //찜한 상품 폴더 이름 변경

}
