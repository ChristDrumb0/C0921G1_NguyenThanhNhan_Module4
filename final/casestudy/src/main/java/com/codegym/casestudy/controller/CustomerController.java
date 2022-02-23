package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.dto.CustomerDto;
import com.codegym.casestudy.model.entity.customer.Customer;
import com.codegym.casestudy.service.customer.ICustomerService;
import com.codegym.casestudy.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    //list
    @GetMapping
    public ModelAndView showList(@RequestParam(name = "name",required = false) String name,
                                 @RequestParam(name = "cusTypeId",required = false) Integer cusTypeId,
                                 @PageableDefault(value = 2,sort = {"name","day_of_birth"}, direction = Sort.Direction.ASC) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("name", name);  //hien thi lai keyword
        modelAndView.addObject("cusTypeId", cusTypeId); //hien thi lai keyword
        modelAndView.addObject("cusTypeList", iCustomerTypeService.findAll()); //select-option - tìm kiếm
        modelAndView.addObject("customerList", iCustomerService.findByKeyword(name,cusTypeId,pageable));  //gọi hàm

        return modelAndView;
    }
    //view
    @GetMapping("/view/{id}")
    public String view(@PathVariable Long id, Model model) {
        Optional<Customer> customerOpt = iCustomerService.findById(id);
        if (!customerOpt.isPresent()) {
            return "error";
        }

        Customer customer = customerOpt.get();
        model.addAttribute("customer",customer);
        return "customer/view";
    }

    //edit
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Customer customer = iCustomerService.findById(id).get();
        //copy Customer --> CustomerDto
        CustomerDto cusDtoObj = new CustomerDto();
        BeanUtils.copyProperties(customer, cusDtoObj);
        //gender-->view
        addData(cusDtoObj, model);
        return "customer/edit";
    }

    @PostMapping("/edit")
    public String editCustomer(@Validated @ModelAttribute("cusDtoObj") CustomerDto cusDtoObj,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               Model model) {
        //Note: không cần check optional (vì không dùng @PathVariable)
        new CustomerDto().validate(cusDtoObj, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            addData(cusDtoObj, model);
            return "customer/edit";
        }
        saveFunction(cusDtoObj, redirectAttributes);
        return "redirect:/customer";
    }

    //create customer:
    @GetMapping("/create")
    public ModelAndView createForm(ModelAndView modelAndView) {
        modelAndView.setViewName("customer/create");
        modelAndView.addObject("cusTypeList", iCustomerTypeService.findAll()); //select-option
        modelAndView.addObject("cusDtoObj", new CustomerDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createCustomer(@Validated @ModelAttribute("cusDtoObj") CustomerDto cusDtoObj,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {

        new CustomerDto().validate(cusDtoObj, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            addData(cusDtoObj, model);
            return "customer/create";
        }
        saveFunction(cusDtoObj, redirectAttributes);
        return "redirect:/customer";
    }

    //delete
    @GetMapping("/delete")
    public String delete(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        iCustomerService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Delete customer successfully!");
        return "redirect:/customer";
    }

    //Ham common: save
    public void saveFunction(CustomerDto cusDtoObj, RedirectAttributes redirectAttributes) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(cusDtoObj, customer);
        iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("message", "Action has been completed Successfully!");
    }

    //select-option
    public void addData(CustomerDto cusDtoObj,
                        Model model) {
        model.addAttribute("cusTypeList", iCustomerTypeService.findAll());
        model.addAttribute("cusDtoObj", cusDtoObj);
    }
}
