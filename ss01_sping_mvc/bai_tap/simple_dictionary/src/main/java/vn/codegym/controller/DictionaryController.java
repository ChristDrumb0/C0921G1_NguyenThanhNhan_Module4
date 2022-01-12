package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.service.IService;

@Controller
public class DictionaryController {
    @Autowired
    private IService iService;

    @RequestMapping(value = "/")
    public String convert() {
        return "index";
    }

    @RequestMapping(value = "/dictionary",method = RequestMethod.POST)
    public ModelAndView translate(@RequestParam("word") String word,
                                  ModelAndView modelAndView) {

        String doTrans=iService.dictionary(word);

        modelAndView.addObject("word",word);
        modelAndView.addObject("doTrans",doTrans);

        modelAndView.setViewName("index");

        return modelAndView;

    }
}
