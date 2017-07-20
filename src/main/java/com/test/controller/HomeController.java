package com.test.controller;

import com.test.POJOs.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class HomeController {
    Person person = new Person();

    @RequestMapping("/")

    public ModelAndView helloWorld()
    {
        return new
                ModelAndView("index","message","Welcome to GC COFFEE");

    }

    @RequestMapping("/registration")
    public ModelAndView registration()
        {

        return new
                ModelAndView("registration","message","Hello World");

    }

    @RequestMapping(value="/survey", method= RequestMethod.POST)
    public ModelAndView login(@RequestParam("fullName") String fullName, @RequestParam("email") String email,@RequestParam("phone") Long phone,@RequestParam("age") int age)
    {
        return new
                ModelAndView("registration","message","Hello World");

    }
    @RequestMapping("/profile")
    public ModelAndView profile(@RequestParam("fullName") String fullName, @RequestParam("email") String email,@RequestParam("phone") Long phone,@RequestParam("age") int age)
    {
        person.setAge(age);
        person.setEmail(email);
        person.setName(fullName);
        person.setphone(phone);
        return new
                ModelAndView("profile","message","Hello " + person.getName());

    }


}
