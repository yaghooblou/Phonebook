package com.phonebook.phonebook.service;

import com.phonebook.phonebook.dao.UserDao;
import com.phonebook.phonebook.entity.User;
import org.springframework.stereotype.Service;

import javax.management.StandardEmitterMBean;
import java.util.List;

@Service("UserService")
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getUser(){
        return userDao.showUser();
    }

    public void newUser(String name, String family){
        User user = new User();
        user.setName(name);
        user.setFamily(family);
        userDao.newUser(user);
    }

    public void deleteUser(int user_id){
        userDao.deleteUser(userDao.getUserById(user_id));
    }

    public User getUserById(int i){
        return userDao.getUserById(i);
    }

    public void updateUser(int id,String name,String family){
        User tmpuser = new User();
        tmpuser = userDao.getUserById(id);
        tmpuser.setName(name);
        tmpuser.setFamily(family);
        userDao.updateUser(tmpuser);
    }

}

