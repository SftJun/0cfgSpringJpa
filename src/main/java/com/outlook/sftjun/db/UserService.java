package com.outlook.sftjun.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {

	private static final Logger log = LoggerFactory
			.getLogger(UserService.class);

	@Autowired
	private UserRep userRep;

	public User save(User user) {
		log.debug("saved user");
		return userRep.save(user);
	}
}
