package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.MedicalDeclaration;
import vn.codegym.service.IService;

@Controller
public class MedicalDeclarationController {
    @Autowired
    private IService iService;

    @GetMapping({"" , "/show_form"})
    public ModelAndView showForm(){
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("info",iService.showDeclaredInfor());
        return mav;
    }
    @GetMapping({"/medical_declaration"})
    public ModelAndView showDeclaration(){
        ModelAndView mav = new ModelAndView("form_update");

        MedicalDeclaration medicalDeclaration =  new MedicalDeclaration();
        mav.addObject("medicalDeclaration",medicalDeclaration);

        String[] gender = {"Male","Female","Other"};
        mav.addObject("gender",gender);

        String[] nationality = {"Viet Nam", "Chines", "Russia", "Cuba", "America","England"};
        mav.addObject("nationality",nationality);

        String[] transportation = {"Air Plane","Trail","Boat","Personal Vehicle","Bus"};
        mav.addObject("transportation",transportation);

        String[] provinces = {"Da nang","Ha Noi","Ho Chi Minh","Kon Tom","Gia Lai","Quang Nam"};
        mav.addObject("provinces",provinces);

        String[] districts = {"Hai Chau","Ngu Hanh Son","Hai Ba Trung","Hoan Kiem","District 1","Thu Duc","Buon Me Thuot"};
        mav.addObject("districts",districts);

        String[] ward = {"Hoa Cuong","Khue Trung","Hoa Hai","Cong Vi","Kim Ma", "Giang Vo","Ben Nghe","Ben Thanh","Co Giang"};
        mav.addObject("ward",ward);

        String[] symptoms = {"Fever","Cough","Stuffy","Sore throat","Vomiting", "Diarrhea", "Bleeding from the skin","Skin rash"};
        mav.addObject("symptoms",symptoms);

        String[] historyExposure = {"Go to the farm/live animal market/slaughterhouse","contact (within 2m) with person infected with nCoV"};
        mav.addObject("historyExposure",historyExposure);
        return mav;
    }
    @PostMapping(value = "/save_infor")
    public String saveMedicalDeclaration(@ModelAttribute MedicalDeclaration medicalDeclaration,
                                         RedirectAttributes redirectAttributes) {

        iService.saveInfor(medicalDeclaration);
        //Hien thong bao:
        redirectAttributes.addFlashAttribute("message","Gửi tờ khai thành công!");
        //chuye huong ve trang list:
        return "redirect:/show_form";
    }
}
