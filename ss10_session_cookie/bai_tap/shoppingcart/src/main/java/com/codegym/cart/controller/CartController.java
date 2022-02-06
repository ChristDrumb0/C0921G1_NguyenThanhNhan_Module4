package com.codegym.cart.controller;

import com.codegym.cart.dto.CartDto;
import com.codegym.cart.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("cart")
public class CartController {
    //thanh toán (xóa giỏ hàng):
    @GetMapping({"/payment"})
    public ModelAndView payment(@SessionAttribute CartDto cart) {
        cart.getProductMap().clear();

        ModelAndView mav = new ModelAndView("cart/payment");
        mav.addObject("message","Bạn đã hoàn thành thanh toán");

        return mav;
    }


    //xem gio hang:
    @GetMapping({"", "/view_cart"})
    public ModelAndView showCart(@SessionAttribute CartDto cart) {

        ModelAndView mav = new ModelAndView("cart/cart_list");
        //tính tổng tiền
        mav.addObject("sumPrice", cart.sumPrice());
        //hiển thị list gio hang:
        mav.addObject("cartList", cart.getProductMap());
        return mav;
    }

    //chi tiet sp:
    @GetMapping("/view/{id}")
    public String showDetail(@PathVariable Long id,
                             @SessionAttribute CartDto cart,
                             Model model) {
        Optional<Product> productDtoOptional = cart.findById(id);
        if (productDtoOptional.isPresent()) {
            model.addAttribute("productObj", productDtoOptional.get());
            return "cart/detail";
        }
        return "/cart/error";
    }

    //delete
    @GetMapping("/delete/{id}")
    public String deleteForm(@PathVariable Long id,
                             @SessionAttribute CartDto cart, Model model) {
        model.addAttribute("productObj", cart.findById(id).get());
        return "cart/delete";
    }


    @PostMapping("/delete")
    public String delete(@ModelAttribute Product productObj,
                         @SessionAttribute CartDto cart) {
        Long id = productObj.getId();
        Optional<Product> productDtoOptional = cart.findById(id);
        if (!productDtoOptional.isPresent()) {
            return "/cart/error";
        } else {
            cart.deleteById(id);
            return "redirect:/cart/view_cart";
        }
    }

    //update giỏ hàng:
    @GetMapping("/update/{id}")
    public String addToCart(@PathVariable Long id,
                            @SessionAttribute CartDto cart,
                            @RequestParam("action") String action) {
        Optional<Product> productOptional = cart.findById(id);
        if (!productOptional.isPresent()) {
            return "/cart/error";
        } else {
            Product item = productOptional.get();
            if (action.equals("add")) {  //tang SL
                cart.addCart(item);
            } else if (action.equals("sub")) {  //giam SL
                cart.subCart(item);
            }
            //Trả về giỏ hàng
            return "redirect:/cart/view_cart";
        }
    }
}
