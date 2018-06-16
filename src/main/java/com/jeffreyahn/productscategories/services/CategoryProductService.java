package com.jeffreyahn.productscategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jeffreyahn.productscategories.models.CategoryProduct;
import com.jeffreyahn.productscategories.repositories.CategoryProductRepository;

@Service
public class CategoryProductService {
	private final CategoryProductRepository categoryProductRepository;
	public CategoryProductService(CategoryProductRepository categoryProductRepository) {
		this.categoryProductRepository = categoryProductRepository;
	}
	public List<CategoryProduct> allCategoryProducts(){
		return categoryProductRepository.findAll();
	}
}
