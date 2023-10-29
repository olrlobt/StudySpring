package com.ssafy.example.product.controller;


import com.ssafy.example.product.model.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public void getList(Model model) {
        productService.getList();
    }

    @GetMapping("/regist")
    public void getRegist() {

    }

}
