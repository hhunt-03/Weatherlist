package com.hunt.weatherlist.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.hunt.weatherlist.security.AccessDeniedHandlerImpl;
import com.hunt.weatherlist.security.LoginFailureHandler;
import com.hunt.weatherlist.security.LoginSuccessHandler;
import com.hunt.weatherlist.security.LogoutSuccessHandlerImpl;
import com.hunt.weatherlist.services.UserService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserService userDetailsService;

	@Autowired
	LoginSuccessHandler loginSuccessHandler;
	
	@Autowired
	LoginFailureHandler loginFailureHandler;

	@Autowired
	private LogoutSuccessHandlerImpl logoutSuccessHandler;

	@Autowired
	private AccessDeniedHandlerImpl accessDeniedHandler;
	
	@Bean
	public UserDetailsService userDetailsService() {
		return this.userDetailsService;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configAuthBuilder(AuthenticationManagerBuilder authBuilder) throws Exception {
		authBuilder.userDetailsService( userDetailsService );
	}
	
	private CsrfTokenRepository csrfTokenRepository() {
		CookieCsrfTokenRepository repository = new CookieCsrfTokenRepository();
		repository.setCookieHttpOnly(false);
		return repository;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors()
				.and()
			.csrf()
				.disable()
				//.csrfTokenRepository(csrfTokenRepository())				
				//.requireCsrfProtectionMatcher(new AntPathRequestMatcher("/api/**"))
				//.and()
			.formLogin()
				.successHandler( loginSuccessHandler )
				.failureHandler( loginFailureHandler )
				.loginProcessingUrl("/login")
				.and()
			.logout()
				.invalidateHttpSession(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessHandler(logoutSuccessHandler)
				.and()
			.authorizeRequests()
				.antMatchers("/api/v1/users/**")
				.authenticated()
				.and()
			.exceptionHandling()
				.accessDeniedHandler(accessDeniedHandler);
	}
}