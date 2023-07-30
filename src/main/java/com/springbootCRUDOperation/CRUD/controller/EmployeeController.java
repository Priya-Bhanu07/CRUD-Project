package com.springbootCRUDOperation.CRUD.controller;

import com.springbootCRUDOperation.CRUD.model.Employee;
import com.springbootCRUDOperation.CRUD.model.LoginForm;
import com.springbootCRUDOperation.CRUD.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeservice;


    @GetMapping(value = "/login")
    public String login(@ModelAttribute(name = "loginForm") LoginForm loginForm, Model model) {
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        if ("jalaAcademy".equals(username) && "12345".equals(password)) {
            return "index";
        }
        model.addAttribute("invalidCredentials", true);
        return "login";
    }

    @PostMapping("/search")
    public String searchEmployee(@RequestParam("employeeId") long employeeId, Model model) {
        Employee employee = employeeservice.get(employeeId);
        if (employee != null) {
            model.addAttribute("employee", employee);
            return "employee-details"; // Return a template to display employee details
        } else {
            model.addAttribute("error", "Employee not found");
            return "index"; // Return the same form with an error message
        }
    }


    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listEmployees", employeeservice.getAllEmployee());
        return "index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "new_employee";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeservice.saveEmployee(employee);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {
        Employee employee = employeeservice.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "update_employee";

    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id, Model model) {
        this.employeeservice.deleteEmployeeById(id);
        return "redirect:/";
    }
}
