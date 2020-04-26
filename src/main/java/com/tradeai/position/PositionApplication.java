package com.tradeai.position;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PositionApplication {

	public static void main(String[] args) {
		SpringApplication.run(PositionApplication.class, args);
	}
	
	@Bean
	public SimpleDateFormat getSDF() {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		 sdf.setTimeZone(TimeZone.getTimeZone("America/New_York"));
		 return sdf;
		 
	}

}
