package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.dto.ServicesDto;
import com.codegym.casestudy.model.entity.service.Services;
import com.codegym.casestudy.service.service.IRenttypeService;
import com.codegym.casestudy.service.service.IServiceService;
import com.codegym.casestudy.service.service.IServiceTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private IServiceService iService;

    @Autowired
    private IRenttypeService iRentType;

    @Autowired
    private IServiceTypeService iServiceType;

    @GetMapping
    public ModelAndView showList(@PageableDefault(value = 4) Pageable pageable) {
        return new ModelAndView("service/list", "serviceList", iService.findAllPage(pageable));
    }

    //    //EDIT
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Services service = iService.findById(id).get();
        ServicesDto serDtoObj = new ServicesDto();
        BeanUtils.copyProperties(service, serDtoObj);
        addData(serDtoObj, model);
        return "service/edit";
    }

    @PostMapping("/edit")
    public String editService(@ModelAttribute("serDtoObj") ServicesDto serDtoObj,
                              RedirectAttributes redirectAttributes,
                              Model model) {
        //Note: không cần check optional (vì không dùng @PathVariable)
        saveFunction(serDtoObj, redirectAttributes);
        return "redirect:/service";
    }

    //create customer:
    @GetMapping("/create")
    public ModelAndView createForm(ModelAndView modelAndView) {
        modelAndView.setViewName("service/create");
        modelAndView.addObject("rentTyeList", iRentType.findAll()); //select-option
        modelAndView.addObject("serviceTypeList", iServiceType.findAll()); //select-option
        modelAndView.addObject("serDtoObj", new ServicesDto());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createService(@ModelAttribute("serDtoObj") ServicesDto serDtoObj,
                                RedirectAttributes redirectAttributes,
                                Model model) {
        saveFunction(serDtoObj, redirectAttributes);
        return "redirect:/service";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        iService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Delete service successfully!");
        return "redirect:/service";
    }

    //Ham common: save
    public void saveFunction(ServicesDto serviceDto, RedirectAttributes redirectAttributes) {
        Services service = new Services();
        BeanUtils.copyProperties(serviceDto, service);
        iService.save(service);
        redirectAttributes.addFlashAttribute("message", "Action has been completed Successfully!");
    }

    //select-option
    public void addData(ServicesDto serDtoObj,
                        Model model) {
        model.addAttribute("serDtoObj",serDtoObj);
        model.addAttribute("rentTyeList", iRentType.findAll());
        model.addAttribute("serviceTypeList", iServiceType.findAll());
    }
}
