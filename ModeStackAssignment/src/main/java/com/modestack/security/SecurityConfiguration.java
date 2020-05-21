package com.modestack.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter  {

 @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
        authorizeRequests().anyRequest().permitAll();
        http.csrf().disable();
    }

 /*
  * @Override  
	    public void configure(HttpSecurity http) throws Exception {  
	        http  
	            .authorizeRequests()  
	            .anyRequest().authenticated()  
	            .and()  
	            .httpBasic();  
	    }  
	    @Override  
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {  
	        auth.inMemoryAuthentication()  
	            .withUser("user")  
	            .password("{noop}pass") // Spring Security 5 requires specifying the password storage format  
	            .roles("USER");  
	    }  
	
	   protected void registerAuthentication(AuthenticationManagerBuilder authManagerBuilder) throws Exception {
	        authManagerBuilder
	            .inMemoryAuthentication()
	                .withUser("user").password("password").roles("USER");
	    }
	
	
@Override  
public void configure(HttpSecurity http) throws Exception {  
    http .antMatcher("/**") 
        .authorizeRequests()  
        .antMatchers( "/","/register").permitAll()  
        .anyRequest().authenticated()  
            .and();  
       
           
}*/
}
