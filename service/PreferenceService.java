package com.harustation.backend.service;

import com.harustation.backend.domain.Preference_folder;
import com.harustation.backend.dto.CreateFolderDto;
import com.harustation.backend.repository.PreferenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PreferenceService {
    private final PreferenceRepository preferenceRepository;

    public List<Preference_folder> getListByUser_idx(Long user_idx){
        return preferenceRepository.findAllByUser_idx(user_idx);
    }

    @Transactional
    public Long save(CreateFolderDto createFolderDto){
        return preferenceRepository.save(createFolderDto.toEntity()).getFolder_idx();
    }

}
