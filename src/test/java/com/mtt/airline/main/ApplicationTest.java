package com.mtt.airline.main;


import static org.hamcrest.Matchers.is;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

import com.mtt.airline.main.Application;


@SuppressWarnings("deprecation")
public class ApplicationTest {
	

	@InjectMocks
	Application app = new Application();

	
	@Test
	public void shouldHaveSpringBoot() {
		SpringBootApplication annotation = this.app.getClass().getAnnotation(SpringBootApplication.class);

		Assert.assertThat(annotation, is(SpringBootApplication.class));
	}

	
	@Test
	public void shouldHaveARootPath() {
		EnableGlobalMethodSecurity annotation = this.app.getClass().getAnnotation(EnableGlobalMethodSecurity.class);
		Assert.assertThat(annotation, is(EnableGlobalMethodSecurity.class));
		Assert.assertTrue(annotation.securedEnabled());
	}
	
	@Test
	public void shouldHavePropertySource() {
		PropertySource annotation = this.app.getClass().getAnnotation(PropertySource.class);
		Assert.assertThat(annotation, is(PropertySource.class));
	}
	
}
