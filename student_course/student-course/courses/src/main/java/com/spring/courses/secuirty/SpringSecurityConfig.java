
package com.spring.courses.secuirty;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SuppressWarnings("deprecation")
@EnableWebSecurity
@EnableWebMvc
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		/*
		 * http.authorizeRequests().antMatchers("/swagger-ui/**",
		 * "/student/**").permitAll().anyRequest().authenticated() .and().httpBasic();
		 */
		

		http
				// HTTP Basic authentication
				.httpBasic().and().authorizeRequests().antMatchers(HttpMethod.GET, "/student/**").hasRole("USER")
				.antMatchers(HttpMethod.POST, "/student").hasRole("ADMIN").and().csrf().disable().formLogin().disable();
	}
	
	/*
	 * @Override public void configure(WebSecurity web) throws Exception {
	 * web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui",
	 * "/swagger-resources/**", "/configuration/security", "/swagger-ui.html",
	 * "/webjars/**"); }
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		
		  auth.inMemoryAuthentication()
          .withUser("user").password(passwordEncoder().encode("12345")).roles("USER")
          .and()
          .withUser("admin").password(passwordEncoder().encode("12345")).roles("USER", "ADMIN");
		
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
