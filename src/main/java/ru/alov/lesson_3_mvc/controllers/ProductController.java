package ru.alov.lesson_3_mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.alov.lesson_3_mvc.models.Product;
import ru.alov.lesson_3_mvc.repositories.ProductRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("product", productRepository.getAllProducts());
        return "product/index";
    }

    @GetMapping("/{id}")
    public String showProduct(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", productRepository.getProduct(id));
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
        productRepository.addProduct(product);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editProduct(Model model, @PathVariable("id") int id) {
        model.addAttribute(productRepository.getProduct(id));
        return "product/edit";
    }

    @PatchMapping("/{id}")
    public String editProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) return "product/edit";
        productRepository.update(product, id);
        return "redirect:/product";
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        productRepository.delete(id);
        return "redirect:/product";
    }

}
