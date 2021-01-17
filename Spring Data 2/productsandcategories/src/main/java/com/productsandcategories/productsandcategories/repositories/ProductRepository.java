package com.productsandcategories.productsandcategories.repositories;

import com.productsandcategories.productsandcategories.models.Category;
import com.productsandcategories.productsandcategories.models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Long> {
    List<Product> findAll();
    List<Product> findByCategoriesNotContains(Category category);
}