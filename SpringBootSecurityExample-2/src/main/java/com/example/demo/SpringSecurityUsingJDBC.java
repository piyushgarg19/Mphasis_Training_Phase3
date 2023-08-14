package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.security.access.expression.SecurityExpressionHandler;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.WebInvocationPrivilegeEvaluator;

import jakarta.servlet.Filter;

@EnableWebSecurity
public class SpringSecurityUsingJDBC extends  WebSecurityConfiguration{

	@Autowired 
	DataSource ds;

	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(ds).withDefaultSchema();
		//.withUser(User.withUsername("Mahesh").password("Mahesh@123").roles("SALESPERSON"))
		//.withUser(User.withUsername("Kanika").password("Kanika@123").roles("Clerk"));
		//withUser(User.withUsername("Mahesh").password(getPasswordEncoder().encode("Mahesh@123")).roles("SALESPERSON"));
		
	}

	@Bean 
	PasswordEncoder getPasswordEncoder() { 
		  //return NoOpPasswordEncoder.getInstance(); 
		return new BCryptPasswordEncoder();
	}
	
	public void configure(WebSecurity web) throws Exception {
		 web.ignoring().requestMatchers("/h2-console/**"); 
		
	}

}