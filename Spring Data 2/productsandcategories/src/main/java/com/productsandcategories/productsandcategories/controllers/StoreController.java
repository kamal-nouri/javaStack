package com.productsandcategories.productsandcategories.controllers;

import com.productsandcategories.productsandcategories.models.Category;
import com.productsandcategories.productsandcategories.models.Product;
import com.productsandcategories.productsandcategories.services.ProCatService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class StoreController {
    private final ProCatService proCatService;

    public StoreController(ProCatService proCatService) {
        this.proCatService = proCatService;
    }
    @RequestMapping("")
    public String root(){
        return "root.jsp";
    }
    @RequestMapping( "/products/new")
    public String newProduct(@ModelAttribute("product")Product product){
        return "product.jsp";
    }
    @RequestMapping(value = "/product",method = RequestMethod.POST)
    public String addProduct(@Valid @ModelAttribute("product")Product product, BindingResult result){
        if(result.hasErrors()){
            return "product.jsp";
        }
        else {
            Product product1 = proCatService.createProduct(product);
            return "redirect:/";
        }
    }
    @RequestMapping("/categories/new")
    public String newCategory(@ModelAttribute("category") Category category){
        return "category.jsp";
    }
    @RequestMapping(value = "/category",method = RequestMethod.POST)
    public String addCategory(@Valid @ModelAttribute("category")Category category, BindingResult result){
        if(result.hasErrors()){
            return "category.jsp";
        }
        else {
            Category category1 = proCatService.createCategory(category);
            return "redirect:/";
        }
    }
    @RequestMapping("/products/{id}")
    public String showProduct(@PathVariable("id")Long id, Model model){
        Product product=proCatService.findProduct(id);
        model.addAttribute("product",product);
        List<Category> unlisted =proCatService.productNotIncludeCategories(product);
        model.addAttribute("unlisted",unlisted);
        return "showproduct.jsp";
    }
    @RequestMapping("/categories/{id}")
    public String showCategory(@PathVariable("id")Long id, Model model){
        Category category=proCatService.findCategory(id);
        model.addAttribute("category",category);
        model.addAttribute("unlisted",proCatService.uncategorizedProducts(category));
        return "showcategory.jsp";
    }
    @RequestMapping(value = "/addcategory/{id}",method = RequestMethod.POST)
    public String addCategory(@PathVariable("id")Long pro_id, @RequestParam("category")Long cat_id,Model model){
        proCatService.add(pro_id,cat_id);
        return "redirect:/products/"+pro_id;
    }
    @RequestMapping(value = "/addproduct/{id}",method = RequestMethod.POST)
    public String addProduct(@PathVariable("id")Long cat_id, @RequestParam("product")Long pro_id,Model model){
        proCatService.add(pro_id,cat_id);
        return "redirect:/categories/"+cat_id;
    }

}
