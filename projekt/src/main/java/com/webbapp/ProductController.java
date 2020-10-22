package com.webbapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping(path = "/mainview")
    public String getAllProducts(Model model){
        model.addAttribute("products" , productService.getAllProducts());
                return "mainView";
    }

    @RequestMapping("/productView")
    public String pro(Model model) {
        model.addAttribute("products" , productService.getAllProducts());
        return "productView";
    }

    @RequestMapping("/header")
    public String menu(Model model) {

        return "header";
    }

    @RequestMapping("/footer")
    public String fot(Model model) {

        return "footer";
    }
    @GetMapping(path = "/products")
    public String getP(ModelMap modelMap, Model model){
        model.addAttribute("totaltopay" , shoppingCart.totalToPay());
        modelMap.put("pro", productModel.finalAll());
        return "productView";
    }
}
