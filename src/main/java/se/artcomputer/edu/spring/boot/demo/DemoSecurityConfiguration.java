package se.artcomputer.edu.spring.boot.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/index.html");
    }


    @Bean
    UserDetailsService users() {
        return new InMemoryUserDetailsManager(Arrays.asList(
                User.withUsername("admin")
                        .roles("ADMIN", "ACTUATOR")
                        .password("admin")
                        .build(),
                User.withUsername("user")
                        .roles("USER")
                        .password("user")
                        .build()
        ));
    }

}
