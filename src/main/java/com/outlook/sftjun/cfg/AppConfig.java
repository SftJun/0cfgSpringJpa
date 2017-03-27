package com.outlook.sftjun.cfg;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {"com.outlook.sftjun"})
@EnableJpaRepositories(basePackages = {"com.outlook.sftjun.db"})
public class AppConfig {
	
}
