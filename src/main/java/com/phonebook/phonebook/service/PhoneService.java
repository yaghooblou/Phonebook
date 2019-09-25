package com.phonebook.phonebook.service;

import com.phonebook.phonebook.dao.PhoneDao;
import com.phonebook.phonebook.entity.Phone;
import com.phonebook.phonebook.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PhoneService")
public class PhoneService {

    private final PhoneDao phoneDao;

    public PhoneService(PhoneDao phoneDao) {
        this.phoneDao = phoneDao;
    }

    public List<Phone> phones(int userid){
        return phoneDao.phoneList(userid);
    }

    public void newPhone(String title, String phone,User currentUser){
        Phone tmpphone  = new Phone();
        tmpphone.setTitle(title);
        tmpphone.setPhone(phone);
        tmpphone.setUser(currentUser);
        phoneDao.newPhone(tmpphone);
    }

    public void deletePhone(int phoneId ,int userid){
     phoneDao.deletePhone(phoneDao.getPhoneById(phoneId),userid);
    }

    public void  updatePhone(int pid, String title, String phone){
        Phone tmp = phoneDao.getPhoneById(pid);
        tmp.setTitle(title);
        tmp.setPhone(phone);
        phoneDao.updatePhone(tmp);
    }
}

