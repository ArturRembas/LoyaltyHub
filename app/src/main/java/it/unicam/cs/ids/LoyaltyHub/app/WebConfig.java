package it.unicam.cs.ids.LoyaltyHub.app;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * WebConfig class provides configuration settings for the web application.
 * It includes a CORS (Cross-Origin Resource Sharing) configuration to allow
 * the front-end Vue.js application running on a specific origin to make requests
 * to the back-end API.
 *
 * @author YourName
 */
@Configuration
public class WebConfig {

	@Bean
	  public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurer() {
	      @Override
	      public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**")
	            .allowedOrigins("http://localhost:8090") // Indirizzo del frontend Vue.js
	            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
	            .allowedHeaders("*")
	            .allowCredentials(true);
	      }
	    };
	  }
	
}
