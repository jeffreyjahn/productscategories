package com.jeffreyahn.productscategories.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jeffreyahn.productscategories.models.Category;
import com.jeffreyahn.productscategories.models.Product;
import com.jeffreyahn.productscategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	public Category findCategory(Long id) {
		Optional<Category> optCat = categoryRepository.findById(id);
		if(optCat.isPresent()) {
			return optCat.get();
		}else{
			return null;
		}
	}
	public List<Category> findCategories(){
		return categoryRepository.findAll();
	}
	public List<Category> availableCategories(Product product){
		List<String> names = new ArrayList<String>();
		List<Category> currentCategories = product.getCategories();
		if(currentCategories.isEmpty()) {
			names.add("");
		} else {
			for(Category c: currentCategories) {
				names.add(c.getName());
			}
		}
		return categoryRepository.findByNameNotIn(names);
	}
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}
	public void updateCategory(Category category) {
		categoryRepository.save(category);
	}
}
