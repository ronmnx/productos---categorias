package com.ronaldo.productos_y_categorias.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ronaldo.productos_y_categorias.models.Category;
import com.ronaldo.productos_y_categorias.models.Product;
import com.ronaldo.productos_y_categorias.services.CategoryService;
import com.ronaldo.productos_y_categorias.services.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("products")
public class ProductsController {
    private final ProductService productService;
    private final CategoryService categoryService;

    public ProductsController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/new")
    public String getMethodName(@ModelAttribute Product product) {
        return "products/new.jsp";
    }

    @PostMapping("/new")
    public String saveProduct(@ModelAttribute Product product) {
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String showProduct(@PathVariable Long id, Model model, @ModelAttribute Category category) {
        Product product = productService.findById(id);
        List<Category> categories = categoryService.findAll();
        categories.removeAll(product.getCategories());
        model.addAttribute("product", product);
        model.addAttribute("productCategories", product.getCategories());
        model.addAttribute("categories", categories);

        return "products/show.jsp";
    }

    @PostMapping("/{id}")
    public String addCategoryToProduct(@PathVariable Long id, @RequestParam("categoryId") Long categoryId) {
        Product product = productService.findById(id);
        Set<Category> categories = product.getCategories();

        Category category = categoryService.findById(categoryId);
        categories.add(category);

        product.setCategories(categories);
        productService.save(product);
        return "redirect:/products/" + product.getId();
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/";
    }

}
