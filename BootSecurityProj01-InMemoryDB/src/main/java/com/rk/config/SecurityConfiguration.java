package com.rk.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.AntPathMatcher;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//Add username,password and roles
		auth.inMemoryAuthentication().withUser("Raja").password("{noop}raja123").roles("CUSTOMER");
		auth.inMemoryAuthentication().withUser("Ramesh").password("{noop}ramesh456").roles("MANAGER");
		auth.inMemoryAuthentication().withUser("Suresh").password("{noop}suresh789").roles("VISITOR");
		auth.inMemoryAuthentication().withUser("Harish").password("{noop}harish963").roles("CUSTOMER","MANAGER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll() //
		.antMatchers("/offers").hasAnyRole("CUSTOMER","MANAGER","VISITOR")
		.antMatchers("/balance").hasAnyRole("CUSTOMER","MANAGER")
		.antMatchers("/loan").hasRole("MANAGER")
		.anyRequest().authenticated()
	//	.and().httpBasic()
		.and().formLogin()
		.and().rememberMe()
	//	.and().logout()
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/signout"))

		.and().exceptionHandling().accessDeniedPage("/denied");
	}

}