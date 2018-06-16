package com.jeffreyahn.productscategories.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jeffreyahn.productscategories.models.Category;
import com.jeffreyahn.productscategories.models.Product;
import com.jeffreyahn.productscategories.services.CategoryService;
import com.jeffreyahn.productscategories.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductsController {
	private final ProductService productService;
	private final CategoryService categoryService;
	public ProductsController(ProductService productService, CategoryService categoryService) {
		this.productService = productService;
		this.categoryService = categoryService;
	}
	@RequestMapping("/new")
	public String prod(@ModelAttribute("product") Product product) {
		return "/products/new.jsp";
	}
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String newProduct(@ModelAttribute("product") Product product) {
		Product thisProd = productService.createProduct(product);
		return "redirect:/products/" + Long.toString(thisProd.getId());
	}
	
	@RequestMapping("/{pid}")
	public String showProduct(Model model, @PathVariable("pid") Long pId) {
		Product product = productService.findById(pId);
		List<Category> myCategories = product.getCategories();
		model.addAttribute("product", product);
		model.addAttribute("categories", myCategories);
		model.addAttribute("others", categoryService.availableCategories(product));
		return "/products/show.jsp";
	}
	@RequestMapping(value="/{pid}", method=RequestMethod.POST)
	public String addProductsCategory(@RequestParam(value="addCat", required=false) Long cId, @PathVariable("pid") Long pId) {
		Category category = categoryService.findCategory(cId);
		Product product = productService.findById(pId);
		List<Category> categories = product.getCategories();
		categories.add(category);
		product.setCategories(categories);
		productService.updateProduct(product);
		return "redirect:/products/"+Long.toString(pId);
	}

}
