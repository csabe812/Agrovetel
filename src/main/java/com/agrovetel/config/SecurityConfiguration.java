package com.agrovetel.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableGlobalMethodSecurity(securedEnabled=true)
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


	@Autowired
	public void configureAuth(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("admin").password("{noop}admin").roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/**", "/js/**", "/images/**", "/fonts/**", "/plugins/**").permitAll();
		/*http
		.authorizeRequests().anyRequest().authenticated();
			.antMatchers("/tesztoldal").permitAll()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/shop/**").hasRole("USER")
			.antMatchers("/shopowner/**").hasRole("SHOP_OWNER")
			.antMatchers("/regist").permitAll()
			.antMatchers("/reg").permitAll()
			.antMatchers("/console/**").permitAll()
			.antMatchers("/activation/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
			.permitAll()
			.and()
			.logout()
			.logoutSuccessUrl("/login?logout")
			.permitAll();*/
		
		//This is for only H2 embedded database
		//TODO: comment this if you connect to the postresql
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}
}