package app.labs.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import app.labs.dept.auth.CustomUserDetailsService;

@Configuration
@EnableWebSecurity(debug = false)
public class BasicSecurityConfig {

	// 3. Provide 등록
	@Autowired
	CustomUserDetailsService customUserDetailsService;

	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	AuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

		authenticationProvider.setUserDetailsService(customUserDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		authenticationProvider.setHideUserNotFoundExceptions(false);

		return authenticationProvider;
	}

	// 4. custom login, logout
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// 4-1
		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests((authz) -> authz.requestMatchers("/sub").hasRole("ADMIN") // .hasAnyRole("USER",
																									// "ADMIN") //
						.requestMatchers("/", "/main", "/css/", "/js/", "/images/").permitAll());

		// 4-2
		// 로그인폼
		http.formLogin((form) -> form.loginPage("/login").permitAll().defaultSuccessUrl("/").failureUrl("/login")
				.usernameParameter("userid").passwordParameter("password")
				.failureHandler(customAuthenticationFailureHandler));
		// 로그아웃
		http.logout((logout) -> logout.logoutUrl("/logout").logoutSuccessUrl("/").deleteCookies("JSESSIONID")
				.invalidateHttpSession(true).clearAuthentication(true));
		return http.build();
	}

	// 5. 사용자화 메시지
	@Autowired
	AuthenticationFailureHandler customAuthenticationFailureHandler;
}
