package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Email;
import vn.codegym.service.IService;

@Controller
public class EmailSettingController {
    @Autowired
    private IService iEmailService;

    //hien thi cấu hình email
    @GetMapping({"/setting"})
    public ModelAndView showSetting() {
        return new ModelAndView("index","emailSetting",iEmailService.showDetailEmail());
    }

    @GetMapping({"/update"})
    public ModelAndView updateForm() {
        ModelAndView mav = new ModelAndView("update");
        mav.addObject("updateEmail",iEmailService.showDetailEmail());                      //doi tuong rong
        mav.addObject("languageList",iEmailService.showLanguages());  //language
        mav.addObject("pageSizeList",iEmailService.showPageSizeList());  //pageSize

        return mav;
    }
    //    //update
    @PostMapping(value = "/update")
    public String convertCurrency(@ModelAttribute Email updateEmail,  //uu diem: KHONG cần get ra từng thuộc tính của input --> set cho thuộc tính của object
                                  RedirectAttributes redirectAttributes) {
        //goi ham
        iEmailService.update(updateEmail);
        //Hien thong bao:
        redirectAttributes.addFlashAttribute("message","Update Successfully!");
        //chuyen huong ve trang list:
        return "redirect:/setting";
    }
}
