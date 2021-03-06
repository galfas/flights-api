package com.mtt.airline.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages={"com.mtt"})
@PropertySource(value={"classpath:application.properties"})
@EnableGlobalMethodSecurity(securedEnabled = true)
public class Application extends SpringBootServletInitializer {
	
	private static final Logger logger = LoggerFactory.getLogger(Application.class);
	 
    public static void main(String[] args) {
    	
    	logger.info("The application is being launched.");
        SpringApplication.run(Application.class, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }
}

@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration 
class AuthenticationSecurity extends GlobalAuthenticationConfigurerAdapter {
	
	@Value("${security.auth.password}")
	private String password;
	
	@Value("${security.auth.user}")
	private String user;
	
	@Value("${security.auth.role}")
	private String defaultRole;
	
    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .withUser(user).password(password).roles(defaultRole);
    }
}
