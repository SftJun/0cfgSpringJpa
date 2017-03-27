package com.outlook.sftjun;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.outlook.sftjun.cfg.AppConfig;
import com.outlook.sftjun.cfg.PersistenceJPAConfig;
import com.outlook.sftjun.db.User;
import com.outlook.sftjun.db.UserRep;
import com.outlook.sftjun.db.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class,PersistenceJPAConfig.class})
public class AppTest {
	
	@Autowired
	private UserRep userRep;
	
	@Autowired
	private UserService userService;
	
	private String userName = "UserName";
	private String password = "password";
	
	@Test
	public void tstSave(){
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		User savedUser = userRep.save(user);
		Assert.assertEquals(userName, savedUser.getUserName());
		Assert.assertEquals(password, savedUser.getPassword());
	}
	
	@Test
	public void tstFind(){
		Assert.assertEquals(password,userRep.findByUserName(userName).getPassword());
	}
	
	@Test
	public void tstPage(){
		Page<User> users = userService.findByPageAndSize(1, 1);
		users.getContent().forEach(user -> System.out.println(user.getUserName()));
	}
}
