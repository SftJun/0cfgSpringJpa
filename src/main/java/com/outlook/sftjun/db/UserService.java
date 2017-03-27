package com.outlook.sftjun.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

	public Page<User> findByPageAndSize(int page,int size){
		Pageable pageable = new PageRequest(page, size);
		return userRep.findAll(pageable);
	}
}
