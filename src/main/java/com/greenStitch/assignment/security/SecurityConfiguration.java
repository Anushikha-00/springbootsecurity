package com.greenStitch.assignment.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.greenStitch.assignment.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfiguration {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.headers(configurer -> configurer.frameOptions(Customizer.withDefaults()).disable());
		http.authorizeHttpRequests(configurer -> 
				configurer.requestMatchers("/api/signup").permitAll()
				.requestMatchers("/api/login").permitAll()
				.requestMatchers("/h2-ui/**").permitAll()
				.anyRequest().authenticated()
				)
		.formLogin(Customizer.withDefaults())
		.cors(Customizer.withDefaults());
		http.csrf((csrf) -> csrf.disable());
		return http.build();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userDetailsService);
		auth.setPasswordEncoder(passwordEncoder);
		return auth;
	}
}