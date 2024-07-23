package com.ronaldo.productos_y_categorias.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ronaldo.productos_y_categorias.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
