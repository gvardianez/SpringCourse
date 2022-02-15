package ru.alov.lesson_3_mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.alov.lesson_3_mvc.entities.Product;
import ru.alov.lesson_3_mvc.services.ICategoryService;
import ru.alov.lesson_3_mvc.services.IProductService;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoriesController {

    private final ICategoryService categoryService;
    private final IProductService productService;

    public CategoriesController(ICategoryService categoryService, IProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("categories", categoryService.getCategoriesList());
        return "categories/index";
    }

    @GetMapping("/{id}")
    public String showCategory(@PathVariable("id") Long id, Model model) {
        System.out.println("showCategory");
//        List<Product> products = productService.getProductsByCategory(id);
//        List<Product> products = categoryService.getCategory(id).getProductList();
        List<Product> products = categoryService.getProductsByCategory(id);
        model.addAttribute("products", products);
        return "categories/showCategory";
    }

}
