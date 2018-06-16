package com.jeffreyahn.productscategories.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jeffreyahn.productscategories.models.Category;
import com.jeffreyahn.productscategories.models.Product;
import com.jeffreyahn.productscategories.repositories.ProductRepository;

@Service
public class ProductService {
	private final ProductRepository productRepository;
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	public List<Product> allProducts(){
		return productRepository.findAll();
	}
	public Product findById(Long id) {
		Optional<Product> optProd = productRepository.findById(id);
		if (optProd.isPresent()) {
			return optProd.get();
		} else {
			return null;
		}
	}
	public List<Product> availableProducts(Category category){
		List<String> names = new ArrayList<String>();
		List<Product> currentProds = category.getProducts();
		if(currentProds.isEmpty()) {
			names.add("");
		} else {
			for(Product p: currentProds) {
				names.add(p.getName());
			}
		}
		return productRepository.findByNameNotIn(names);
	}
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	public void updateProduct(Product product) {
		productRepository.save(product);
	}
}
