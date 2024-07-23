package com.ronaldo.productos_y_categorias.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ronaldo.productos_y_categorias.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
