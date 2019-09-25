package com.phonebook.phonebook.dao;

import com.phonebook.phonebook.entity.Phone;
import com.phonebook.phonebook.entity.User;
import com.phonebook.phonebook.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("PhoneDao")
public class PhoneDao {

    private Session session;

    public PhoneDao(){
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    public Phone getPhoneById(int id){
        Transaction tx = session.beginTransaction();
        Phone tmp = session.get(Phone.class,id);
        tx.commit();
        return (tmp);
    }

    public List<Phone> phoneList(int userid){
        Transaction tx = session.beginTransaction();
        User tmpuser = session.get(User.class,userid);
        List<Phone> phones =tmpuser.getPhoneList();
        tx.commit();
        return phones;
    }

    public void newPhone(Phone tmpphone){
        Transaction tx = session.beginTransaction();
        session.save(tmpphone);
        tx.commit();
        session.close();
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void deletePhone(Phone tmpphone, int userId){
        Transaction tx = session.beginTransaction();
        User tmp = session.get(User.class,userId);
        tmp.getPhoneList().remove(tmpphone);
        session.delete(tmpphone);
        tx.commit();
        session.close();
        session = HibernateUtil.getSessionFactory().openSession();
    }

    public void updatePhone(Phone tmp){
        Transaction tx = session.beginTransaction();
        session.update(tmp);
        tx.commit();
        session.close();
        session = HibernateUtil.getSessionFactory().openSession();
    }
}
