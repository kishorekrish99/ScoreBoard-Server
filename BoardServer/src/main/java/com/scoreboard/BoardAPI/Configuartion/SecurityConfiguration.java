package com.scoreboard.BoardAPI.Configuartion;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
			.antMatcher("/**").authorizeRequests()
			.antMatchers("/matchs","/team","/user/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.oauth2Login();
	}
}
