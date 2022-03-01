package com.mvc.controller;

import com.mvc.model.Product;
import com.mvc.service.ProductService;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Controller
@RequestMapping("/product")
public class ProductController {
    private ProductService productService = new ProductService();


    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("products", productService.getList());

        return "index";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {

        productService.delete(id - 1);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showedit(Model model, @PathVariable("id") int id, Product p) {

        model.addAttribute("p", productService.getList().get(id - 1));
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable("id") int id, @ModelAttribute("product") Product p) {
        productService.getList().set(id - 1, p);
        return "redirect:/";
    }

    @GetMapping("/upload")
    public String upload() {
        return "upload";
    }

    @PostMapping("/upload")
    public String handleUpload(@RequestParam("file") MultipartFile file) {
        try {
            file.transferTo(new File("C:\\Users\\ASUS\\eclipse-workspace\\codegym\\src\\main\\webapp\\resources\\" + UUID.randomUUID() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."))));
            return "redirect:/";
        } catch (IOException e) {

            e.printStackTrace();
        }

        return "upload";
    }
}
