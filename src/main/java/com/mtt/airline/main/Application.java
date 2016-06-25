package com.mtt.airline.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
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
