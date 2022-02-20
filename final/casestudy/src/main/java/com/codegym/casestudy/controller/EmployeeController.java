package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.dto.EmployeeDto;
import com.codegym.casestudy.model.entity.employee.Employee;
import com.codegym.casestudy.service.employee.IDivisionService;
import com.codegym.casestudy.service.employee.IEducationService;
import com.codegym.casestudy.service.employee.IEmlpoyeeService;
import com.codegym.casestudy.service.employee.IPositionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private IEmlpoyeeService iEmlpoyeeService;
    @Autowired
    private IDivisionService iDivisionService;
    @Autowired
    private IEducationService iEducationService;
    @Autowired
    private IPositionService iPositionService;

    @GetMapping
    public ModelAndView showList(@PageableDefault(value = 4) Pageable pageable) {
        ModelAndView mav = new ModelAndView("employee/list");
        String keyword = null;
        mav.addObject("employeeList", iEmlpoyeeService.findAllPage(keyword,pageable));
        return mav;
    }

    //search
    @GetMapping ("/find")
    public ModelAndView showList(@PageableDefault(value = 4) Pageable pageable, @RequestParam("keyword") String keyword) {
        ModelAndView mav = new ModelAndView("employee/list");
        mav.addObject("keyword", keyword);
        mav.addObject("employeeList", iEmlpoyeeService.findAllPage(keyword,pageable));
        return mav;
    }

    //edit
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        Employee employee = iEmlpoyeeService.findById(id).get();
        //copy
        EmployeeDto empDtoObj  = new EmployeeDto();
        BeanUtils.copyProperties(employee, empDtoObj);
        //gender-->view
        addData(empDtoObj, model);
        return "employee/edit";
    }
    @PostMapping("/edit")
    public String editEmployee(@Validated @ModelAttribute("empDtoObj") EmployeeDto empDtoObj,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               Model model) {
        //Note: không cần check optional (vì không dùng @PathVariable)
        new EmployeeDto().validate(empDtoObj, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            addData(empDtoObj, model);
            return "employee/edit";
        }
        saveFuntion(empDtoObj, redirectAttributes);
        return "redirect:/employee";
    }

    //create
    @GetMapping("/create")
    public ModelAndView createForm(ModelAndView modelAndView) {
        modelAndView.setViewName("employee/create");
        modelAndView.addObject("divisionList", iDivisionService.findAll()); //select-option
        modelAndView.addObject("positionList", iPositionService.findAll()); //select-option
        modelAndView.addObject("eduDegreeList", iEducationService.findAll()); //select-option

        modelAndView.addObject("empDtoObj", new EmployeeDto());
        return modelAndView;
    }
    @PostMapping("/create")
    public String createEmployee(@Validated @ModelAttribute("empDtoObj") EmployeeDto empDtoObj,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {

        new EmployeeDto().validate(empDtoObj, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            addData(empDtoObj, model);
            return "employee/create";
        }
        saveFuntion(empDtoObj, redirectAttributes);
        return "redirect:/employee";
    }

    //delete
    @GetMapping("/delete")
    public String delete(@RequestParam Long id, RedirectAttributes redirectAttributes) {
        iEmlpoyeeService.delete(id);
        redirectAttributes.addFlashAttribute("message", "Delete employee successfully!");
        return "redirect:/employee";
    }

    //Ham common: save
    public void saveFuntion(EmployeeDto empDtoObj, RedirectAttributes redirectAttributes) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(empDtoObj, employee);
        iEmlpoyeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Action has been completed Successfully!");
    }

    //reload data for validate
    public void addData(EmployeeDto empDtoObj,
                        Model model) {
        model.addAttribute("divisionList", iDivisionService.findAll());
        model.addAttribute("positionList", iPositionService.findAll());
        model.addAttribute("eduDegreeList", iEducationService.findAll());

        model.addAttribute("empDtoObj", empDtoObj);
    }
}
