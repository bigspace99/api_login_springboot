package com.example.demo.controllers;

import com.example.demo.models.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/login")
    public String login(HttpSession session) {
        if (session.getAttribute("loggedUser") != null) {
            return "redirect:/home";
        }
        return "login";
    }

    @GetMapping("/register")
    public String register(HttpSession session) {
        if (session.getAttribute("loggedUser") != null) {
            return "redirect:/home";
        }
        return "register";
    }

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        User loggedUser = (User) session.getAttribute("loggedUser");
        if (loggedUser != null) {
            model.addAttribute("username", loggedUser.getUsername());
        } else {
            model.addAttribute("username", null);
        }
        return "home";
    }
}
