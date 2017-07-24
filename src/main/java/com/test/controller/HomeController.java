package com.test.controller;

import com.test.POJOs.User;
import com.test.dao.userDao;
import com.test.factory.DaoFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    userDao dao = DaoFactory.getInstance(userDao.JDBC_DAO);


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
    public ModelAndView registerUser(User user) {

        System.out.println(user);

        return new ModelAndView("profile", "name", user.getUserName());
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("login", "command", new User());
    }



    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public ModelAndView loginUser(User user) {

        System.out.println(user);

        return new ModelAndView("profile", "name", user.getUserName());
    }


    @RequestMapping(value = "/checkOut")
    public ModelAndView checkOutReciept(){
        return new ModelAndView("checkOut", "reciept", "this is your reciept");
    }


}
