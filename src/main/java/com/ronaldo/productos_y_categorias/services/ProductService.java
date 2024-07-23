package com.ronaldo.productos_y_categorias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ronaldo.productos_y_categorias.models.Product;
import com.ronaldo.productos_y_categorias.repositories.ProductRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> opProduct = productRepository.findById(id);
        return opProduct == null ? null : opProduct.get();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
