package com.codegym.casestudy.controller;

import com.codegym.casestudy.model.dto.ContractDto;
import com.codegym.casestudy.model.entity.contract.Contract;
import com.codegym.casestudy.service.contract.IContractService;
import com.codegym.casestudy.service.customer.ICustomerService;
import com.codegym.casestudy.service.employee.IEmlpoyeeService;
import com.codegym.casestudy.service.service.IServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;
    @Autowired
    private IEmlpoyeeService iEmployeeService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IServiceService iService;


    @GetMapping("/find")
    public ModelAndView viewList(@PageableDefault(value = 3) Pageable pageable, ModelAndView modelAndView) {

        modelAndView.setViewName("contract/view");
        modelAndView.addObject("nowCusList",iContractService.findCurrentCustomerPage(pageable));
        return modelAndView;
    }

    //create contract:
    @GetMapping("/contract/create")
    public ModelAndView createForm(ModelAndView modelAndView) {
        modelAndView.setViewName("contract/create");
        modelAndView.addObject("employeeList", iEmployeeService.findAll());
        modelAndView.addObject("customerList", iCustomerService.findAll());
        modelAndView.addObject("serviceList", iService.findAll());

        modelAndView.addObject("contrDtoObj", new ContractDto());
        return modelAndView;
    }

    @PostMapping("/contract/create")
    public String createContract(@Validated @ModelAttribute("contrDtoObj") ContractDto contrDtoObj,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes,
                                 Model model) {

        new ContractDto().validate(contrDtoObj, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            addData(contrDtoObj, model);
            return "contract/create";
        }

        //tinh phi:
        double totalFee = contrDtoObj.getService().getCost() + contrDtoObj.getDeposit();
        contrDtoObj.setTotalFee(totalFee);
        //lưu:
        callSaveFunction(contrDtoObj);
        model.addAttribute("contrDtoObj", contrDtoObj);
        model.addAttribute("message","Create new contract successful");
        return "contract/detail";
    }
    //Ham common: save
    public void callSaveFunction(ContractDto contrDtoObj) {
        Contract contract = new Contract();
        BeanUtils.copyProperties(contrDtoObj, contract);
        iContractService.save(contract);
    }

    //select-option
    public void addData(ContractDto contrDtoObj,
                        Model model) {
        model.addAttribute("employeeList", iEmployeeService.findAll());
        model.addAttribute("customerList", iCustomerService.findAll());
        model.addAttribute("serviceList", iService.findAll());
        model.addAttribute("contrDtoObj", contrDtoObj);
    }
}
