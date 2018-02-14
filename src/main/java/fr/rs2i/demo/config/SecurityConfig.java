package fr.rs2i.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
		protected void configure(HttpSecurity httpSecurity) throws Exception {
		    httpSecurity
		            .authorizeRequests().antMatchers("/person/**").permitAll()
		            .anyRequest().authenticated()
		            .and()
		            .formLogin().permitAll();
		
		   httpSecurity.csrf().disable();
		   httpSecurity.headers().frameOptions().disable();
		}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser("admin").password("admin").roles("ADMIN")
                .and().withUser("user").password("user").roles("USER");;
    }

}
