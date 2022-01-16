package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Product;
import vn.codegym.service.IService;

import java.util.List;

@Controller
@RequestMapping({"/product"})
public class ProductController {

    @Autowired
    IService service;

    @GetMapping("")
    public String viewProduct(Model model) {

        List<Product> productList = service.findAll();
        model.addAttribute("productList", productList);
        return "index";
    }

    @GetMapping("/create_product")
    public ModelAndView createProduct(){
        ModelAndView mav = new ModelAndView("create");
        mav.addObject("product",new Product());
        return mav;
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes ) {
        int max = 0;
        for (Product products:service.findAll()) {
            if (products.getId()>max){
                max =products.getId();
            }
        }
        product.setId(max+1);
        service.save(product);
        redirectAttributes.addFlashAttribute("messages1","Create product successfully!");
        return "redirect:/product/";
    }

    @GetMapping("/{id}/edit_product")
    public ModelAndView editProduct(@PathVariable int id){
        ModelAndView mav = new ModelAndView("edit");
        mav.addObject("product",service.findById(id));
        return mav;
    }
    @PostMapping("/update")
    public String updateProduct(Product product, RedirectAttributes redirectAttributes){
        service.update(product.getId(),product);
        redirectAttributes.addFlashAttribute("messages3","Edit "+product.getName()+ " successfully!");
        return "redirect:/product/";
    }

    @GetMapping("/{id}/view")
    public String viewDetail(@PathVariable int id,Model model){
        model.addAttribute("product",service.findById(id));
        return "/view";
    }

    @GetMapping("/{id}/delete")
    public String deleteProduct(@PathVariable int id,RedirectAttributes redirect){

        redirect.addFlashAttribute("messages2", "Removed product successfully!");
        service.remove(id);
        return "redirect:/product/";
    }
}
