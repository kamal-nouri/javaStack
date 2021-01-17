package com.productsandcategories.productsandcategories.repositories;

import com.productsandcategories.productsandcategories.models.Category;
import com.productsandcategories.productsandcategories.models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category,Long> {
    List<Category> findAll();
    List<Category> findByProductsNotContains(Product product);
}
