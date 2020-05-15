package com.rikovicisah.app.ws;

import com.rikovicisah.app.ws.security.AppPropertiesRead;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MobileAppWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobileAppWsApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SpringAppContext springAppContext(){
		return new SpringAppContext();
	}

	@Bean(name = "AppPropertiesRead")
	public AppPropertiesRead getPropertiesRead(){
		return new AppPropertiesRead();
	}
}
