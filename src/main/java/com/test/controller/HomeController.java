package com.test.controller;

import com.test.POJOs.Person;
import com.test.POJOs.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {


    @RequestMapping("/")

    public ModelAndView helloWorld()
    {
        return new
                ModelAndView("index","message","Welcome to GC COFFEE");

    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        return new ModelAndView("registration", "command", new User());
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public ModelAndView registerUser(User user, Model model) {
        model.addAttribute("name", user.getName());
        model.addAttribute("age", user.getAge());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("phone", user.getPhone());
        model.addAttribute("sex", user.getSex());
        model.addAttribute("coffeePrefs", user.getCoffeePrefs());
        model.addAttribute("pw", user.getPw());
        model.addAttribute("userName", user.getUserName());

        System.out.println(user);


        return new ModelAndView("profile", "name", user.getUserName());
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("login", "command", new User());
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public ModelAndView loginUser(User user, Model model) {
        model.addAttribute("pw", user.getPw());
        model.addAttribute("userName", user.getUserName());

        System.out.println(user);

        return new ModelAndView("profile", "name", user.getUserName());
    }

}
