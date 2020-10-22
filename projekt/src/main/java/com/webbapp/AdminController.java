package com.webbapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
public class AdminController {
@Autowired
    private ProductService productService;

    @GetMapping(path = "/adminview")
    public String getAllProducts(Model model){
        model.addAttribute("products" , productService.getAllProducts());
                return "adminView";
    }

@GetMapping("/productInfo/{ProductId}")
    public String getProductById(Model model, @PathVariable Integer ProductId) {
        model.addAttribute("product", productService.getProductById(ProductId));
        return "productInfo";
    }


@GetMapping (path="/adminView/edit/{ProductId}")
    public String editProduct(Model model, @PathVariable Integer ProductId){
        model.addAttribute("product", productService.getProductById(ProductId));
    return "EditFormView";
 }

@RequestMapping (path="/admin/update", method={RequestMethod.POST, RequestMethod.PUT})
    public String updateProduct(@ModelAttribute("product") Product product, @RequestParam Map<String, String> allRequestParams){
        productService.updateProduct(product);
    return "adminView";
 }
    @RequestMapping (path="/adminView/add", method=RequestMethod.GET)
    public String addProduct(Model model,@PathVariable ("productAdd") Product productAdd) {
        model.addAttribute("addProduct", productService.addProduct(productAdd));
        return "";
    }


}
