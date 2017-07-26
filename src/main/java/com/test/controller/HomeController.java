package com.test.controller;

import com.test.POJOs.User;
import com.test.dao.userDao;
import com.test.factory.DaoFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    userDao dao = DaoFactory.getInstance(userDao.HIBERNATE_DAO);



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
        dao.addUser(user);

        return new ModelAndView("profile", "name", user.getUserName());
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("login", "command", new User());
    }



    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public ModelAndView loginUser(User user) {

        System.out.println(user);
        User loggedInUser = dao.getUser(user.getUserName(), user.getPassword());
        if (loggedInUser == null){
            return new ModelAndView("login", "alert", "Your username or password is incorrect!");
        }else {
            return new ModelAndView("profile", "name", loggedInUser.getUserName());
        }
    }


    @RequestMapping(value = "/checkOut")
    public ModelAndView checkOutReceipt(){
        return new ModelAndView("checkOut", "receipt", "this is your receipt");
    }


}
