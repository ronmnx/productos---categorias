package com.ronaldo.productos_y_categorias.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ronaldo.productos_y_categorias.models.Category;
import com.ronaldo.productos_y_categorias.models.Product;
import com.ronaldo.productos_y_categorias.services.CategoryService;
import com.ronaldo.productos_y_categorias.services.ProductService;

@Controller
public class HomeController {
    private final ProductService productService;
    private final CategoryService categoryService;

    public HomeController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<Product> products = productService.findAll();
        List<Category> categories = categoryService.findAll();

        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        return "index.jsp";
    }

}
