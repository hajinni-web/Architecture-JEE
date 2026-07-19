package com.example.spring_mvc.web;

import jakarta.validation.Valid;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.example.spring_mvc.entities.Product;
import com.example.spring_mvc.repositories.ProductRepository;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // ---- Liste avec pagination et recherche ----
    @GetMapping({"/", "/products"})
    public String listProducts(
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "4") int size,
            Model model) {

        Page<Product> productPage = productRepository.findByNameContainsIgnoreCase(keyword,
                PageRequest.of(page, size));

        model.addAttribute("products", productPage.getContent());
        model.addAttribute("pages", new int[productPage.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "products";
    }

    // ---- Supprimer un produit ----
    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable Long id,
                                @RequestParam(defaultValue = "") String keyword,
                                @RequestParam(defaultValue = "0") int page) {
        productRepository.deleteById(id);
        return "redirect:/products?page=" + page + "&keyword=" + keyword;
    }

    // ---- Formulaire d'ajout ----
    @GetMapping("/products/new")
    public String newProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "new-product";
    }

    // ---- Formulaire d'édition ----
    @GetMapping("/products/edit/{id}")
    public String editProductForm(@PathVariable Long id, Model model) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit introuvable : " + id));
        model.addAttribute("product", product);
        return "new-product";
    }

    // ---- Enregistrer (ajout + mise à jour) ----
    @PostMapping("/products/save")
    public String saveProduct(@Valid @ModelAttribute Product product,
                              BindingResult bindingResult,
                              Model model) {
        if (bindingResult.hasErrors()) {
            return "new-product";
        }
        productRepository.save(product);
        return "redirect:/products";
    }

    //-----authentification Controller-----
     @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "notAuthorized";
    }
}
