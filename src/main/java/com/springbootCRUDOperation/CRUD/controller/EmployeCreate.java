package com.springbootCRUDOperation.CRUD.controller;

import com.springbootCRUDOperation.CRUD.model.Register;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeCreate {

    @GetMapping("/r")
    public String register(Model model) {
        Register register = new Register();
        model.addAttribute("register", register);
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerCreate(@ModelAttribute("register") Register register) {

        System.out.println(register);
        return "register";
    }
}
