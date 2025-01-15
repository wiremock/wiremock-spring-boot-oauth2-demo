package org.wiremock.demo.springbootoauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
public class SpringBootOauth2Application {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.authorizeHttpRequests(a ->
						a.requestMatchers("/login", "/oauth2/**", "/openid-connect", "/error", "/css/**", "/js/**", "/images/**", "/assets/**").permitAll()
								.anyRequest().authenticated()
				)
				.exceptionHandling(e -> e
						.authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"))
				)
				.logout(l -> l
						.logoutSuccessUrl("/login").permitAll()
				)
				.oauth2Login(customizer -> customizer.successHandler(successHandler()))
				.build();
	}

	public AuthenticationSuccessHandler successHandler() {
		SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler();
		handler.setDefaultTargetUrl("/");
		return handler;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOauth2Application.class, args);
	}
}
