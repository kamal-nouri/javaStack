package com.productsandcategories.productsandcategories.services;

import com.productsandcategories.productsandcategories.models.Category;
import com.productsandcategories.productsandcategories.models.Product;
import com.productsandcategories.productsandcategories.repositories.CategoryRepository;
import com.productsandcategories.productsandcategories.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProCatService {
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public ProCatService(CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
    }
    public List<Product> allProducts(){
        return productRepository.findAll();
    }
    public List<Category> allCategory(){
        return categoryRepository.findAll();
    }
    public Product findProduct(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            return optionalProduct.get();
        }else {
            return null;
        }
    }
    public Category findCategory(Long id){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()){
            return optionalCategory.get();
        }else {
            return null;
        }
    }
    public Product createProduct(Product product){
        return productRepository.save(product);
    }
    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }
    public List<Product> uncategorizedProducts(Category category){
        return productRepository.findByCategoriesNotContains(category);
    }
    public List<Category> productNotIncludeCategories(Product product){
        return categoryRepository.findByProductsNotContains(product);
    }
    public void add(Long product_id,Long category_id){
        Product product=productRepository.findById(product_id).orElse(null);
        Category category = categoryRepository.findById(category_id).orElse(null);
        assert product != null;
        List<Category> categories= product.getCategories();
        categories.add(category);
        product.setCategories(categories);
        productRepository.save(product);

    }
}
