package com.codegym.cart.controller;

import com.codegym.cart.dto.CartDto;
import com.codegym.cart.model.Product;
import com.codegym.cart.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
@RequestMapping("/shop")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    //show list:
    @GetMapping
    public ModelAndView showList() {
        return new ModelAndView("list", "productList", iProductService.findAll());
    }

    // xem chi tiet
    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable Long id) {
        return new ModelAndView("detail", "productObj", iProductService.finById(id).get());
    }

    //them gio hang:
    @GetMapping("/add_cart/{id}")
    public String addToCart(@PathVariable Long id,
                            @SessionAttribute CartDto cart,
                            RedirectAttributes redirectAttributes) {
        Optional<Product> productOptional = iProductService.finById(id);

        if (productOptional.isPresent()) {
            Product product = new Product();
            BeanUtils.copyProperties(productOptional.get(), product);
            cart.addCart(product);
            redirectAttributes.addFlashAttribute("message", "Đã thêm " + product.getName() + "vào giỏ hàng");
        }

        return "redirect:/shop";

    }
}
