package com.babyjoeyBackend.config;



import org.hibernate.sql.Delete;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

      @Override
        public void configure(HttpSecurity http) throws Exception {
            http.csrf().disable().authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers(HttpMethod.GET,"/api/home").permitAll()
                    .antMatchers(HttpMethod.GET, "/api/users").permitAll()
                    .antMatchers(HttpMethod.POST,"/api/newuser").permitAll()
                    .antMatchers(HttpMethod.PUT,"/api/user/*").permitAll()
                    .antMatchers(HttpMethod.DELETE,"/api/user/*").permitAll()
                    .antMatchers(HttpMethod.GET, "/api/user/**").permitAll()

                    .antMatchers(HttpMethod.GET,"/api/homeact").permitAll()
                    .antMatchers(HttpMethod.GET, "/api/activities").permitAll()
                    .antMatchers(HttpMethod.POST,"/api/newactivity").permitAll()
                    .antMatchers(HttpMethod.PUT,"/api/activity/*").permitAll()
                    .antMatchers(HttpMethod.DELETE,"/api/activity/*").permitAll()
                    .antMatchers(HttpMethod.GET, "/api/activity/**").permitAll()
                    .anyRequest().authenticated();
        }
        /*
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
        http.authorizeRequests()
                .antMatchers("/home").permitAll()
                .antMatchers("/MANGER/**").hasRole("MANGER")
                // .antMatchers("/MANGER/**").hasAnyRole("MANGER")
                .antMatchers("/USER/**").hasAnyRole("USER")
                .antMatchers("/ADMIN/**").hasRole("ADMIN")
                .anyRequest()
                .permitAll();
        http.csrf().disable();
    }*/
    @Bean

    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }





   /* @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration configuration = new CorsConfiguration();
        // www - obligatory//        configuration.setAllowedOrigins(ImmutableList.of("*"));  //set access from all domains
        configuration.setAllowedOrigins(ImmutableList.of("*"));

        configuration.setAllowedMethods(ImmutableList.of("GET", "POST", "PUT", "DELETE"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(ImmutableList.of("Authorization", "Cache-Control", "Content-Type"));

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }*/
}
