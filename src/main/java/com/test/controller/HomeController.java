package com.test.controller;

import com.test.POJOs.ItemsEntity;
import com.test.POJOs.User;
import com.test.dao.userDao;
import com.test.factory.DaoFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class HomeController {

    private userDao dao = DaoFactory.getInstance(userDao.HIBERNATE_DAO);
    private User loggedInUser;
    private int itemId;


    @RequestMapping("/")

    public ModelAndView helloWorld() {
        return new
                ModelAndView("index", "message", "Welcome to GC COFFEE");

    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registration() {
        return new ModelAndView("registration", "command", new User());
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public ModelAndView registerUser(User user) {

        System.out.println(user);
        for(User user1: dao.readUsers()){
            if (user.getUserName().equals(user1.getUserName())){
                return new ModelAndView("registration", "msg", "User name has been taken!");
            }
        }
        dao.addUser(user);
        return new ModelAndView("profile", "name", user.getUserName());
    }



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        return new ModelAndView("login", "command", new User());
    }


    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public ModelAndView loginUser(User user, Model model) {

        System.out.println(user);
        loggedInUser = dao.getUser(user.getUserName(), user.getPassword());
        return maybeLogIn(model);
    }

    @RequestMapping(value = "/profile")
    public ModelAndView profile(Model model) {
        return maybeLogIn(model);
    }

    private ModelAndView maybeLogIn(Model model) {
        if (loggedInUser == null) {

            return new ModelAndView("login", "alert", dao.getMsg());
        } else {
            ArrayList<ItemsEntity> itemsList = (ArrayList<ItemsEntity>) dao.readItems();
            System.out.println(itemsList);
            model.addAttribute("name", loggedInUser.getUserName());
            model.addAttribute("isMod", true);
            return new ModelAndView("profile", "cList", itemsList);
        }
    }

    @RequestMapping(value = "/addItems", method = RequestMethod.GET)
    public ModelAndView addItems() {
        return new ModelAndView("addItems", "command", new ItemsEntity());
    }

    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    public ModelAndView addItem(ItemsEntity item) {

        System.out.println(item);
        dao.addItem(item);

        return new ModelAndView("addItems", "msg", "Successfully added "+item.getName() + "!");
    }

    @RequestMapping(value = "delete")
    public ModelAndView deleteItem(@RequestParam("id") int itemID, Model model){

        dao.deleteItem(itemID);
        return  maybeLogIn(model);
    }


    @RequestMapping(value = "/editItem", method = RequestMethod.GET)
    public ModelAndView editItems(@RequestParam("id") int itemId) {
        this.itemId = itemId;
        return new ModelAndView("editItems", "command", new ItemsEntity());
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ModelAndView editItem(ItemsEntity tempItem, Model model){

        ItemsEntity itemsInDB = dao.getItemsEntity(itemId);

        itemsInDB.setName(tempItem.getName());
        itemsInDB.setDescription(tempItem.getDescription());
        itemsInDB.setPrice(tempItem.getPrice());
        itemsInDB.setInitialQuantity(tempItem.getInitialQuantity());

        dao.editItem(itemsInDB);
        return maybeLogIn(model);
    }


    @RequestMapping(value = "/checkOut")
    public ModelAndView checkOutReceipt() {
        return new ModelAndView("checkOut", "receipt", "this is your receipt");
    }


}
