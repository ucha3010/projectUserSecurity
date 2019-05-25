package com.udemy.converter;

import com.udemy.entity.User;
import com.udemy.model.UserModel;

public class UserConverter {
	
	public UserModel userTouserModel(User user) {
		UserModel userModel = new UserModel();
		return userModel;
	}
	
	public User userModelTouser(UserModel userModel) {
		User user = new User();
		return user;
	}

}
