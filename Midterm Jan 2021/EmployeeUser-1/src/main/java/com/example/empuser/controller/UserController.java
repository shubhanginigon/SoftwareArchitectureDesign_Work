package com.example.empuser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.empuser.model.Role;
import com.example.empuser.model.User;
import com.example.empuser.service.UserService;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

	/*
	 * @Autowired private UserValidator userValidator;
	 */
    
   

    @RequestMapping(path = "/home")
    public ModelAndView userDashboard(Principal principal) {
        ModelAndView mv = new ModelAndView("home.jsp");
        User u = userService.findByUsername(principal.getName());
        mv.addObject("user", u);

        for (Role role: u.getRoles()) {
            if (role.getName().equalsIgnoreCase("ROLE_ADMIN")) {
                //do something
                System.out.println("Showing Dashboard for ADMIN.");
            }
            if (role.getName().equalsIgnoreCase("ROLE_USER")) {
                
                System.out.println("Showing Dashboard for USER.");
            }
        }
        return mv;
    }

    @RequestMapping(path = "/login")
    public String login() {
        return "login.jsp";
    }

    @RequestMapping(path = "/logout-success")
    public String logout() {
        return "logout.jsp";
    }
}