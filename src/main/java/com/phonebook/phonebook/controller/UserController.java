package com.phonebook.phonebook.controller;

import com.phonebook.phonebook.entity.User;
import com.phonebook.phonebook.service.UserService;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller()
@RequestMapping("/phonebook")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String showUsers(Model m){
        List<User> users = userService.getUser();
        m.addAttribute("puser" ,users);
        return "main/user_list";
    }

    @PostMapping("/newuser")
    public ModelAndView newUser(
            @RequestParam("name") String name,
            @RequestParam("family") String family,
            Model m
    ){
        System.out.println(name);
        userService.newUser(name,family);
        return new ModelAndView("redirect:/phonebook");
    }

    @GetMapping("/deleteuser")
    public ModelAndView deleteUser(@RequestParam("id")int user_id,Model m){
        userService.deleteUser(user_id);
        return new ModelAndView("redirect:/phonebook");
    }

    @PostMapping("/update_user")
    public ModelAndView updateuser(@RequestParam("id") int user_id ,
                             @RequestParam("name") String name,
                             @RequestParam("family") String family,
                             Model m){
        userService.updateUser(user_id,name,family);
        return new ModelAndView("redirect:/phonebook");
    }


}
