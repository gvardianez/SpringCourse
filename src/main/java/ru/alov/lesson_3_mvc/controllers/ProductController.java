package ru.alov.lesson_3_mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.alov.lesson_3_mvc.entities.Category;
import ru.alov.lesson_3_mvc.entities.Product;
import ru.alov.lesson_3_mvc.services.ICategoryService;
import ru.alov.lesson_3_mvc.services.IClientService;
import ru.alov.lesson_3_mvc.services.IProductService;

import javax.validation.Valid;


@Controller
@RequestMapping("/product")
public class ProductController {

    private final IProductService productService;
    private final ICategoryService categoryService;
    private final IClientService clientService;

    public ProductController(IProductService productService, ICategoryService categoryService, IClientService clientService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.clientService = clientService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("product", productService.getAllProducts());
        return "product/index";
    }

    @GetMapping("/{id}")
    public String showProduct(@PathVariable("id") Long id, Model model) {
        Product product = productService.getProduct(id);
        product.setCategoryType((Product.CategoryTypes.values()[(int) (product.getCategory().getId() - 1)]));
        model.addAttribute("product", product);
        return "product/showProduct";
    }

    @GetMapping("/new")
    public String newProduct(@ModelAttribute("product") Product product) {
        return "product/new";
    }

    @PostMapping()
    public String createProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) return "/product/new";
        Category category = categoryService.getCategory((long) product.getCategoryType().ordinal() + 1);
        product.setCategory(category);
        productService.addProduct(product);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editProduct(Model model, @PathVariable("id") Long id) {
        model.addAttribute(productService.getProduct(id));
        return "product/edit";
    }

    @PatchMapping("/{id}")
    public String editProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult, @PathVariable("id") Long id) {
        if (bindingResult.hasErrors()) return "product/edit";
        Category category = categoryService.getCategory((long) product.getCategoryType().ordinal() + 1);
        product.setCategory(category);
        productService.update(product, id);
        return "redirect:/product";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.delete(id);
        return "redirect:/product";
    }

}
