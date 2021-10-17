package com.donation.controller;

import com.donation.entity.User;
import com.donation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AuthController {

    public static final String LOGIN_TEMPLATE = "login";

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping("/signin")
    public ModelAndView showLoginForm(
            @RequestParam(name="error", required = false) String error,
            @RequestParam(name = "logout", required = false) String logout) {

        ModelAndView modelAndView = new ModelAndView(LOGIN_TEMPLATE);
        modelAndView.addObject("error", error);
        modelAndView.addObject("logout", logout);
        modelAndView.addObject("user", new User());

        return modelAndView;
    }

    @PostMapping("/signup")
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult results, RedirectAttributes redirAttrs) {

        //If there are errors
        if (results.hasErrors()) {
            redirAttrs.addFlashAttribute("errors", results.getAllErrors());
            return "redirect:/signin";
        }

        if (userService.existsByIdDocument(user.getIdDocument())) {
            redirAttrs.addFlashAttribute("message", "ID Document is already taken");
            return "redirect:/signin";
        }

        if (userService.existsByEmail(user.getEmail())) {
            redirAttrs.addFlashAttribute("message", "Email is already taken");
            return "redirect:/signin";
        }

        // Create new user's account
        user.setPassword(encoder.encode(user.getPassword()));
        userService.save(user);

        return "redirect:/signin";
    }

    @GetMapping("/loginsuccess")
    public String loginCheck() {
        return "redirect:/";
    }
}
