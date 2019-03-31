package kevat2019.Harjoitustyo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import kevat2019.Harjoitustyo.web.UserDetailServiceImpl;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailServiceImpl userDetailsService;
    
	@Autowired
	private DataSource datasource;
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
    	.antMatchers("/css/**").permitAll()
    	.and()
    	.authorizeRequests()
    	.anyRequest().authenticated()
    	.and()
	.formLogin()
		.loginPage("/kirjaudu")
		.defaultSuccessUrl("/kirjat")
		.permitAll()
		.and()
	.logout()
		.permitAll();
	}
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
        .passwordEncoder(new BCryptPasswordEncoder()).and().jdbcAuthentication().dataSource(datasource);
    }
}
