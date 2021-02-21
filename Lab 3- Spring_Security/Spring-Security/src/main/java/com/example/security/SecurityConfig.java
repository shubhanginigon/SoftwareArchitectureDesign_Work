package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//This is for authentication, authorization
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private MyUserDetailsService uds;
	
	//Singleton
	@Bean //method level 
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//Override two func
	
	//1st authentication

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//what are the userdetailservice 
		//what are password encoder
		auth
		.userDetailsService(uds)
		.passwordEncoder(bCryptPasswordEncoder());
		
	}

	//2nd authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//h2-console, login and register
		//admin/**- ROLE_ADMIN
		
		http
		   .csrf().disable()  //disable so that h2 works
		   .authorizeRequests()
		   		.antMatchers("/h2-console/**","/login","/register").permitAll()
		   		.antMatchers("/admin/**").hasRole("ADMIN")
		   		.antMatchers("/**").hasAnyRole("ADMIN","USER")
		   	.and()
		   	.formLogin()
		   		.loginPage("/login").permitAll()
		   		.defaultSuccessUrl("/home",true)
		   	.and()
		   	.logout().invalidateHttpSession(true)
		   		.clearAuthentication(true)
		   		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		   		.logoutSuccessUrl("/logout-success").permitAll();
		   		
		http.headers().frameOptions().disable();
		
	}
}
