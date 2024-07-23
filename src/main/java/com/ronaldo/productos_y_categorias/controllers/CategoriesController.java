package com.ronaldo.productos_y_categorias.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.ronaldo.productos_y_categorias.models.Category;
import com.ronaldo.productos_y_categorias.models.Product;
import com.ronaldo.productos_y_categorias.services.CategoryService;
import com.ronaldo.productos_y_categorias.services.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("categories")
public class CategoriesController {
    private final CategoryService categoryService;
    private final ProductService productService;

    public CategoriesController(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping("/new")
    public String newCategory(@ModelAttribute Category category) {
        return "categories/new.jsp";
    }

    @PostMapping("/new")
    public String createCategory(@ModelAttribute Category category) {
        categoryService.save(category);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String showCategory(@PathVariable Long id, Model model) {
        Category category = categoryService.findById(id);
        List<Product> products = productService.findAll();
        products.removeAll(category.getProducts());
        model.addAttribute("category", category);
        model.addAttribute("products", products);
        return "categories/show.jsp";
    }

    @PostMapping("/{id}")
    public String addProductToCategory(@PathVariable Long id, @RequestParam Long productId) {
        Category category = categoryService.findById(id);
        List<Product> products = category.getProducts();
        Product product = productService.findById(productId);
        products.add(product);

        categoryService.save(category);

        return "redirect:" + category.getId();
    }

    @DeleteMapping("{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        return "redirect:/";

    }
}
