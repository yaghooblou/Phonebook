package com.phonebook.phonebook.dao;

import com.phonebook.phonebook.entity.User;
import com.phonebook.phonebook.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("UserDao")
public class UserDao {

    private Session session;


    public UserDao(){
        this.session = HibernateUtil.getSessionFactory().openSession();
    }

    public List<User> showUser(){
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from User ");
        List<User> users = (List<User>) q.list();
        tx.commit();
        return  users;
    }

    public User getUserById(int i){
        Transaction tx = session.beginTransaction();
        User tmpuser = session.get(User.class,i);
        tx.commit();
        return tmpuser;
    }

    public void newUser(User user){
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
    }

    public void deleteUser(User user){
        Transaction tx = session.beginTransaction();
        session.delete(user);
        tx.commit();
    }

    public void updateUser(User tmpUser){
        Transaction tx = session.beginTransaction();
        session.update(tmpUser);
        tx.commit();
    }


}
