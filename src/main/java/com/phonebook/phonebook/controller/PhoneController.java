package com.phonebook.phonebook.controller;

import com.phonebook.phonebook.entity.Phone;
import com.phonebook.phonebook.entity.User;
import com.phonebook.phonebook.service.PhoneService;
import com.phonebook.phonebook.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/phonebook/detail")
public class PhoneController {

    private final PhoneService phoneService;
    private final UserService userService;

    public PhoneController(PhoneService phoneService, UserService userService){
        this.phoneService = phoneService;
        this.userService = userService;

    }

    @PostMapping("")
    public String phoneList(@RequestParam("userId") int userId,
                                  Model m){
        List<Phone> phones = phoneService.phones(userId);
        User user = userService.getUserById(userId);
        m.addAttribute("userI",user);
        m.addAttribute("phones",phones);
        return "main/phone_list";
    }

    @PostMapping("/newphone")
    public String newPhone(@RequestParam("userId") int userId,
                                 @RequestParam("title") String title,
                                 @RequestParam("phone") String phone,
                                 Model m){
        User currentUser = userService.getUserById(userId);
        phoneService.newPhone(title,phone,currentUser);
        phoneList(userId,m);
        return "main/phone_list";
    }

    @GetMapping("/deletephone")
    public String deletePhone(@RequestParam("userId") int userId,
                              @RequestParam("id") int phoneId,
                              Model m){
        phoneService.deletePhone(phoneId,userId);
        phoneList(userId,m);
        return "main/phone_list";
    }

    @PostMapping("/updatephone")
    public String updatephone(@RequestParam("userId") int userId,
                              @RequestParam("id") int phoneId,
                              @RequestParam("title") String title,
                              @RequestParam("phone") String phone,
                              Model m){
        phoneService.updatePhone(phoneId,title,phone);
        phoneList(userId,m);
        return "main/phone_list";
    }
}
