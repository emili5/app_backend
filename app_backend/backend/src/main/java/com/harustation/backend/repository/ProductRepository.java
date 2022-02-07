package com.harustation.backend.repository;

import com.harustation.backend.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    // 제품명 검색 (parameter : product_name)
    // QueryDSL 로 수정하기...
    @Query("select p from Product p where p.product_name=?1")
    List<Product> getProductByProduct_nameContaining(String product_name);

    @Query("select p from Product p where p.product_name=?1 order by p.product_hit")
    List<Product> orderProductByProduct_hit(String product_name);

    @Query("select p from Product p where p.product_name=?1 order by p.create_date")
    List<Product> orderProductByProduct_createdate(String product_name);

    @Query("select p from Product p where p.product_name=?1 order by p.product_Price")
    List<Product> orderProductByProduct_price(String product_name);

    @Query("select p from Product p where p.product_name=?1 order by p.product_Price desc")
    List<Product> orderProductByProduct_priceDesc(String product_name);
}
