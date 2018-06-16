package com.jeffreyahn.productscategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jeffreyahn.productscategories.models.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();
	List<Category> findByNameNotIn(List<String> names);
}
