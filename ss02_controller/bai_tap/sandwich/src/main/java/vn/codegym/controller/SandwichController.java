package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.service.IService;

@Controller
public class SandwichController {
    @Autowired
    private IService iService;

    @RequestMapping(value = "/")
    public String convert() {
        return "index";
    }

    @RequestMapping(value = "/sandwich",method = RequestMethod.POST)
    public ModelAndView sandwichMeNu(@RequestParam(value = "condiment",required = false) String[] sandwich, ModelAndView modelAndView) {

        modelAndView.addObject("results", sandwich);
        modelAndView.setViewName("result");

        return modelAndView;

    }
}
