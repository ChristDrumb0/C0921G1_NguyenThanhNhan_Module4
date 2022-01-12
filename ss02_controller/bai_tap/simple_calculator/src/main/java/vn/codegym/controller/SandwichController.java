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

    @RequestMapping(value = "/calculate",method = RequestMethod.POST)
    public ModelAndView calculate(@RequestParam("first") double first,@RequestParam("second") double second,
                                  @RequestParam("operator") String operator, ModelAndView modelAndView) {
        modelAndView.addObject("first",first);
        modelAndView.addObject("second",second);
        modelAndView.addObject("result",iService.calculate(first,second,operator));

        modelAndView.setViewName("index");
        return modelAndView;
    }
}
