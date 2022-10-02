package com.dowjones;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.*;
import org.springframework.context.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;

import com.dowjones.accessdata.*;



@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan("com.dowjones")
public class DowJonesApplicationSpringApplication {
	
		@Component
	    public static class ApplicationLifecycle implements Lifecycle {
	
		    @Autowired
		    private AccessStockData repository;
		
		    Logger logger=LoggerFactory.getLogger(ApplicationLifecycle.class);
		
		    @Override
		    public void start() {
		        logger.info("Application start");
		    }
		
		    @Override
		    public void stop() {
		        logger.info("Application stop");
		        repository.deleteAll();
		
		    }
		    
		    @Override
			public boolean isRunning() {
				return true;
			}
		}

	public static void main(String[] args) {
		SpringApplication.run(DowJonesApplicationSpringApplication.class, args);
	}

	
}
