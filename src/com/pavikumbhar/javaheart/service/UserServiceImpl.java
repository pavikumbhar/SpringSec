/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pavikumbhar.javaheart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pavikumbhar.javaheart.dao.UserServiceDao;
import com.pavikumbhar.javaheart.entity.User;

/**
 *
 * @author pravinkumbhar
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserServiceDao userServiceDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

    }

    @Override
    public User findByUsername(String username) {
        return userServiceDao.findByUsername(username);
    }

	@Override
	public void update(User user) {
		userServiceDao.update(user);
		
	}
}
