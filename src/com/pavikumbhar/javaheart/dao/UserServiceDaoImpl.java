/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pavikumbhar.javaheart.dao;

import com.pavikumbhar.javaheart.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pravinkumbhar
 */
@Repository
public class UserServiceDaoImpl implements UserServiceDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {
    	sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public User findByUsername(String username) {
        System.err.println(">>>>>>>>>>>>>>>>>>"+username);
        
     return (User)sessionFactory.getCurrentSession().createQuery("FROM  User  where username  =:username")
                                          .setString("username", username)
                                           .uniqueResult();

    }

	@Override
	public void update(User user) {
	  sessionFactory.getCurrentSession().update(user);
	}

}
