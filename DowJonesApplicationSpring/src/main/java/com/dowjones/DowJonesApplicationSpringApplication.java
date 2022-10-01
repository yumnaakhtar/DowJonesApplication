package com.dowjones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.*;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class DowJonesApplicationSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DowJonesApplicationSpringApplication.class, args);
	}

}
