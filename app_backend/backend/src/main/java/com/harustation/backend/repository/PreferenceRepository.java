package com.harustation.backend.repository;

import com.harustation.backend.domain.Preference_folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreferenceRepository extends JpaRepository<Preference_folder, Long> {

    @Query("select p from Preference_folder p where p.user_idx=?1")
    public List<Preference_folder> findAllByUser_idx(Long user_idx);
}
