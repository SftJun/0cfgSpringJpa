package com.outlook.sftjun.db;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRep extends JpaRepository<User, Long>{
	
	public User findByUserName(String userName);
}
