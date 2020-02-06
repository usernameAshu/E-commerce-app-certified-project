package com.edureka.eurekaserver;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServerApplication.class, args);
		
		
		/*
		 * Map<String,String> gfg = new HashMap<String,String>();
		 * 
		 * // enter name/url pair gfg.put("GFG", "geeksforgeeks.org");
		 * gfg.put("Practice", "practice.geeksforgeeks.org"); gfg.put("Code",
		 * "code.geeksforgeeks.org"); gfg.put("Quiz", "quiz.geeksforgeeks.org");
		 * 
		 * // forEach(action) method to iterate map gfg.forEach((k, v) ->
		 * System.out.println("Key = " + k + ", Value = " + v));
		 */
	}

}
