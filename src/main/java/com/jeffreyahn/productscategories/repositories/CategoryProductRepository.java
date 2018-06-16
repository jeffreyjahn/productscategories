package com.jeffreyahn.productscategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jeffreyahn.productscategories.models.CategoryProduct;

public interface CategoryProductRepository extends CrudRepository<CategoryProduct, Long>{
	List<CategoryProduct> findAll();
}
