/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pavikumbhar.javaheart.service;

import com.pavikumbhar.javaheart.entity.User;

/**
 *
 * @author pravinkumbhar
 */
public interface UserService {
	void save(User user);

	void update(User user);

	User findByUsername(String username);
}
