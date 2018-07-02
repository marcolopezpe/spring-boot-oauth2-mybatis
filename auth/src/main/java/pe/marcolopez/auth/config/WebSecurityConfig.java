package pe.marcolopez.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import pe.marcolopez.auth.security.AuthenticationSuccessHandlerImpl;

@Configuration
@EnableResourceServer
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService customUserDetailService;
	
	@Autowired
	private AuthenticationSuccessHandlerImpl authenticationSuccessHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// @formatter:off
		http.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/")
				.successHandler(authenticationSuccessHandler)
				.permitAll()
			.and()
				.logout()
					.logoutSuccessUrl("/")
					.deleteCookies("UISESSIONID")
			.and()
				.requestMatchers()
					.antMatchers("/", "/login", "/oauth/authorize", "/oauth/confirm_access", "/exit")
			.and()
				.authorizeRequests()
					.antMatchers("/webjars/**").permitAll()
					.anyRequest().authenticated();
		// @formatter:on
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.parentAuthenticationManager(authenticationManager)
			.userDetailsService(customUserDetailService);
	}
	
}
