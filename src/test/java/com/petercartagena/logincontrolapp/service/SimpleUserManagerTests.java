package com.petercartagena.logincontrolapp.service;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.petercartagena.logincontrolapp.domain.User;


/*Solo prueba la interacion entre el SimpleUserManager y quien lo utiliza. No prueba la conexion con la base de datos.*/


public class SimpleUserManagerTests {

	private UserManager	simpleUserManager;

	private List<User>			users;

	@Before
	public void setUp() {
		
		simpleUserManager = new UserManager();
		users = new ArrayList<User>();

		User user = new User();
		user.setUserName("peter");
		user.setPassword("1234");
		user.setEnable(true);
		users.add(user);

		user = new User();
		user.setUserName("raul");
		user.setPassword("1234");
		user.setEnable(true);
		users.add(user);

		simpleUserManager.setUsers(users);
	}

	@Test
	public void testGetUserWithNoUsers() {
		// simpleUserManager = new SimpleUserManager();
		// Assert.assertNull(simpleUserManager.getUsers());
	}

	@Test
	public void testGetUser() {

		simpleUserManager.setUsers(users);
		System.out.println("TEST: " + simpleUserManager.getUsers().size());
		User user = new User();
		user.setUserName("peter");
		user.setPassword("1234");
		user.setEnable(true);
		Assert.assertEquals(simpleUserManager.getUsers().get(0).getUserName(), user.getUserName());

		user.setUserName("raul");
		user.setPassword("1234");
		user.setEnable(true);
		Assert.assertEquals(simpleUserManager.getUsers().get(1).getUserName(), user.getUserName());
	}

	@Test
	public void testChangeUser() {
		User user = new User();
		user.setUserName("otro");
		user.setPassword("1234");
		user.setEnable(true);

		simpleUserManager.changeUser(simpleUserManager.getUsers().get(0), user);
		Assert.assertNotSame(simpleUserManager.getUsers().get(0).getUserName(), "peter");

	}

	@Test
	public void testSetUsers() {

		simpleUserManager.setUsers(users);
		Assert.assertEquals(users.size(), 2);

	}
}
