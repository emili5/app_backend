package com.harustation.backend.repository;

import com.harustation.backend.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store,Long> {

    @Query("select p from Store p where p.store_name LIKE %?1%")
    List<Store> findStoreByStore_nameContaining(String StoreName);

}
