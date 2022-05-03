package net.javaguides.springboot.config;

import net.javaguides.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private AccessDeniedHandler accessDeniedHandler;

	@Autowired
	private UserService userService;
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable()
				.authorizeRequests()
				.antMatchers("/registration", "/index", "/js/**",
	                "/css/**", "/", "/about", "/contact", "/gallery",
						"/room", "/lib/**", "/scss/**", "/js",
	                "/img/**").permitAll()
                .antMatchers("/admin/**").hasAnyRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("USER")
                .antMatchers("/employee/**").hasAnyRole("EMPLOYEE")
				.anyRequest().authenticated()
				.and()
				.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/default")
				.permitAll()
				.and()
				.logout()
				.invalidateHttpSession(true)
                .clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?logout")
				.permitAll()
				.and()
				.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
	}

//	@Autowired
//	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
////		auth.inMemoryAuthentication()
////				.withUser("user").password("password").roles("USER")
////				.and()
////				.withUser("admin").password("password").roles("ADMIN");
//
//	}
}