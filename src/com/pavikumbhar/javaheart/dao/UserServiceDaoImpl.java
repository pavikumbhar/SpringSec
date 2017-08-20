/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pavikumbhar.javaheart.dao;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pavikumbhar.javaheart.entity.User;

/**
 *
 * @author pravinkumbhar
 */
@Repository
public class UserServiceDaoImpl implements UserServiceDao {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceDaoImpl.class);
	
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(User user) {
    	sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public User findByUsername(String username) {
    	logger.debug("findByUsername"+username);
        
     return (User)sessionFactory.getCurrentSession().createQuery("FROM  User  where username  =:username")
                                          .setString("username", username)
                                           .uniqueResult();

    }

	@Override
	public void update(User user) {
	  sessionFactory.getCurrentSession().update(user);
	}

}
