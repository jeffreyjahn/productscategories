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
@RequestMapping("/categories")
public class CategoriesController {
	private final CategoryService categoryService;
	private final ProductService productService;
	public CategoriesController(CategoryService categoryService, ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}
	@RequestMapping("/new")
	public String cat(@ModelAttribute("category") Category category) {
		return "/categories/new.jsp";
	}
	@RequestMapping(value="/new", method=RequestMethod.POST)
	public String newCategory(@ModelAttribute("category") Category category) {
		categoryService.createCategory(category);
		return "redirect:/categories/"+ Long.toString(category.getId());
	}
	@RequestMapping("/{cid}")
	public String showCategory(Model model, @PathVariable("cid") Long cId) {
		Category category = categoryService.findCategory(cId);
		List<Product> myProducts = category.getProducts();
		model.addAttribute("category", category);
		model.addAttribute("products", myProducts);
		model.addAttribute("others", productService.availableProducts(category));
		return "/categories/show.jsp";
	}
	@RequestMapping(value="/{cid}", method=RequestMethod.POST)
	public String addCategoriesProduct(@PathVariable("cid") Long cId, @RequestParam(value="addProd", required=false) Long pId) {
		Product product = productService.findById(pId);
		Category category = categoryService.findCategory(cId);
		List<Product> products = category.getProducts();
		products.add(product);
		category.setProducts(products);
		categoryService.updateCategory(category);
		return "redirect:/categories/"+Long.toString(cId);
	}

}
