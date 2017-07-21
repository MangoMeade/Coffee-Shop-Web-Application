package com.test.controller;

import com.test.POJOs.Person;
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
        return new ModelAndView("registration", "command", new Person());
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public ModelAndView registerUser(Person person, Model model) {
        model.addAttribute("name", person.getName());
        model.addAttribute("age", person.getAge());
        model.addAttribute("email", person.getEmail());
        model.addAttribute("phone", person.getPhone());
        model.addAttribute("sex", person.getSex());
        model.addAttribute("coffeePrefs", person.getCoffeePrefs());
        System.out.println(person);

        return new ModelAndView("profile", "name", person.getName());
    }

}
