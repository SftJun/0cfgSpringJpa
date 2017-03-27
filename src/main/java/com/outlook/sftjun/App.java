package com.outlook.sftjun;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.outlook.sftjun.cfg.AppConfig;
import com.outlook.sftjun.cfg.PersistenceJPAConfig;
import com.outlook.sftjun.db.User;
import com.outlook.sftjun.db.UserRep;

@ComponentScan(basePackageClasses = {AppConfig.class,PersistenceJPAConfig.class})
public class App {
	
	private static final Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		log.debug("Start spring ....");
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(
				App.class);
		UserRep userRep = context.getBean(UserRep.class);
		User user = new User();
		user.setUserName("UserName");
		user.setPassword("password");
		System.out.println(userRep.save(user).getId());
	}
}
