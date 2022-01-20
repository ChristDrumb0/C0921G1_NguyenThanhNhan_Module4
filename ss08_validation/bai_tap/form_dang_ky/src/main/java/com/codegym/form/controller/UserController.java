package com.codegym.form.controller;

import com.codegym.form.dto.UserDto;
import com.codegym.form.model.User;
import com.codegym.form.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/form_validate")
public class UserController {
    @Autowired
    IUserService userService;

    @GetMapping
    public String showResult() {
        return "result";
    }

    @GetMapping("/create_user")
    public String showCreateForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto",userDto);
        return "create";
    }

        @PostMapping("/create_user")
    public String createUser(@Valid @ModelAttribute UserDto userDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

        new UserDto().validate(userDto,bindingResult);

        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("userDto",userDto);
            return ("create");
        }
        else{
            User users = new User();
            BeanUtils.copyProperties(userDto, users);
            userService.save(users);
            redirectAttributes.addFlashAttribute("messageCreate", "Successfully create user" + users.getFirstName() + " " + users.getLastName() + " !");
            redirectAttributes.addFlashAttribute("userDto",userDto);
            return "redirect:/form_validate";
        }

    }

}
