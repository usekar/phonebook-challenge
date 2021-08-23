package com.livevox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 

@SpringBootApplication
public class LiveVoxPhonebookApplication {
//to deploy in a web container,
//public class LiveVoxPhonebookApplication extends SpringBootServletInitializer {

	/*
	 * @Override protected SpringApplicationBuilder
	 * configure(SpringApplicationBuilder builder) { return
	 * builder.sources(SpringApplication.class); }
	 */
	Logger logger = LoggerFactory.getLogger(LiveVoxPhonebookApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LiveVoxPhonebookApplication.class, args);
		System.out.println("Welcome to LiveVox project");
	}
	
 /* To do
  * Put it back in github
  * 			add clean message to "Added " and not always
  * 			Search on phone number
  * 			finish the css issue
  * 			Write teh interface first
  *  			* Add logger
  *  			* Error pages
  *    			* Add @Transactional to all Service layer methods
  * add exception handling  
  * scalabality feautures 
  * Add test cases for repository
  * add test cases for mockito
  * apply Stringutils to error handle session elements
  * Pagination
  * Why have SpringBootServletInitializer

  */
}
