package com.petercartagena.logincontrolapp.service;

import java.util.List;

import com.petercartagena.logincontrolapp.domain.User;


/*TODO ESTO PORQUE TENIA SERIALIZABLE*/
public interface IUserManager {

	/* Most changes, user and password */
	public void changeUser(User user, User newUser);

	public List<User> getUsers();

}