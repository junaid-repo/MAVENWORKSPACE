package com.jdbcdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jdbcdemo.security.JwtRequestFilter;
import com.jdbcdemo.security.MyUserDetailsService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	MyUserDetailsService myUserDetailsService;

	@Autowired
	JwtRequestFilter jwtRequestFilter;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("inside securingConfig.java");
		auth.userDetailsService(myUserDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// --------------------enable jwt code starts---------------------------------
		
		  http.csrf().disable().authorizeRequests().antMatchers("/authenticate", "/createUser", "/webService", "/company","/loginAndCreateToken").
		  permitAll().anyRequest()
		  .authenticated().and().sessionManagement().sessionCreationPolicy(
		  SessionCreationPolicy.ALWAYS); http.addFilterBefore(jwtRequestFilter,
		  UsernamePasswordAuthenticationFilter.class);
		 
		// --------------------enable jwt code ends---------------------------------

		// --------------------disable jwt code starts---------------------------------

		//http.authorizeRequests().antMatchers("/").permitAll();

		// --------------------disable jwt code ends---------------------------------

	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception { //
	 * TODO Auto-generated method stub
	 * System.out.println("inside securingConfig.java");
	 * http.authorizeRequests().anyRequest().authenticated().and().httpBasic().and()
	 * .csrf().disable(); }
	 */
}
