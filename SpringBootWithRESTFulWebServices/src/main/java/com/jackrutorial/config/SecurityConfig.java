package com.jackrutorial.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebMvcConfigurerAdapter{
	
@Bean
public UserDetailsService userDetailsService() {
	UserDetails user= User.withDefultPasswordEncoder()
			.username("admin")
			.password("123")
			.roles("ADMIN")
			.build();
	return new InMemoryUserDetailsManager(user);

}
protected void configure(HttpSecurity http)throws Exception{
	
	http.httpBasic().and().authorizeRequests()
	.antMatchers("/user/**").hasRole("ADMIN")
	.and().csrf().disable().headers().frameOptions().disable();
}

}
