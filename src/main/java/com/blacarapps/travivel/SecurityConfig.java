package com.blacarapps.travivel;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import com.auth0.spring.security.api.Auth0SecurityConfig;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@Configuration
public class SecurityConfig extends Auth0SecurityConfig {

	@Override
	protected void authorizeRequests(final HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/health").permitAll()
			.antMatchers("/info").permitAll()
			.antMatchers("/**").authenticated();
	}
}