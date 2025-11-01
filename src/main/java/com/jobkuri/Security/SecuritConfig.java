package com.jobkuri.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration @EnableWebSecurity
public class SecuritConfig { 
	@Bean 
	public SecurityFilterChain filterChain(HttpSecurity http) 
		throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers( 
				"/api/auth/**"
				, "/api/jobSeekers/**"
				, "/api/recruiters/**"
				, "/api/jobPost/**"
				, "/api/applications/**"
				, "/api/admins/**"
				, "/api/notifications/**"
				, "/api/upload/**"
				, "/api/payment/**"
				, "/api/dashBoards/**"
				,"/api/courses/**").permitAll().anyRequest().authenticated();
		return http.build();
		}
	@Bean
	public BCryptPasswordEncoder passwordEncode() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	@Bean
	public AuthenticationManager authenticatonManager(AuthenticationConfiguration config) throws Exception{
		return config.getAuthenticationManager();
	}
}