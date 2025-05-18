package com.example.Basic_auth_demo1;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig {
    
        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .authorizeHttpRequests(auth -> auth
                    .requestMatchers("/", "/index", "/css/*", "/js/*").permitAll()
                    .requestMatchers("/user/**").hasRole("STUDENT")
    
                    .anyRequest()
                    .authenticated()
                    )
    
                    .formLogin(); // Enable form login
        
                return http.build();
        }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails fatima = User.withUsername("fatima")
                .password(passwordEncoder().encode("pass123"))
                .roles("STUDENT")
                .build();
        return new InMemoryUserDetailsManager(fatima);
    }
    


}
