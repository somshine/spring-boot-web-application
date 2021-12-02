package com.somshine.webApp.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.somshine.webApp.model.Product;
import com.somshine.webApp.model.User;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<Product, Long> {
//	@Query("SELECT products.id, products.name, products.company_id FROM products "
//			+ "INNER JOIN companies ON companies.id = products.company_id "
//			+ "ORDER BY products.quantity (:sorting)")
	
	@Query("SELECT pro FROM Product pro WHERE deleted = 0 ORDER BY quantity ASC")
    List<Product> findProductByStockAscSorting();
	
	@Query("SELECT pro FROM Product pro WHERE deleted = 0 ORDER BY quantity DESC")
    List<Product> findProductByStockDescSorting();
	
	@Query("SELECT pro FROM Product pro")
    List<Product> getAllProductBySql();
	
	Product findByName(String name);
}
