package pe.marcolopez.security.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Value("${auth-server}/exit")
	private String logoutUrl;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.logout()
				.logoutSuccessUrl(logoutUrl)
			.and()
				.authorizeRequests()
				.anyRequest().authenticated();
	}
	
}
