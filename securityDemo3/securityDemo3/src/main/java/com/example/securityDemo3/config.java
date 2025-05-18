package com.example.securityDemo3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import com.example.securityDemo3.AuthenticationSuccessHandler;
import com.example.securityDemo3.model.MyUserDetailService;
import com.example.securityDemo3.model.MyUserRepository;

@Configuration
@EnableWebSecurity
public class config {

    @Autowired 
    private MyUserDetailService userDetailService; 

  


   @Bean
   public SecurityFilterChain securityFilterhChain(HttpSecurity http) throws Exception{
    // disable csrf if you want to register, enable when logging in ?? idk why 
    return http
    .csrf(AbstractHttpConfigurer::disable)
    .authorizeHttpRequests(registry->{
        registry.requestMatchers("/home","/register/**","/subscribe","/login").permitAll();
        registry.requestMatchers("/admin/**").hasRole("ADMIN"); 
        registry.requestMatchers("/user/**").hasRole("USER"); 
        registry.anyRequest().authenticated(); //any request that is not mentioned above is not allowed !!!
        })

        .formLogin(httpSecurityFormLoginConfigurer -> {
            httpSecurityFormLoginConfigurer
                    .loginPage("/login")
                    .loginProcessingUrl("/perform_login") 
                  // .defaultSuccessUrl("/user/home", true)
                 .successHandler(new AuthenticationSuccessHandler())
                    .permitAll();
        })
        .build();

   }

//    @Bean 
//    public UserDetailsService userDetailsService(){
//     UserDetails normaluser = User.builder()
//     .username("fatima")
//     .password("$2a$12$AvvLLardOCMcug6NYBnU3Op5rc006suj2AVPi.w/hwZWKzzE4Eomq")// 1234
//     .roles("USER")
//     .build();

//     UserDetails admin = User.builder()
//     .username("admin")
//     .password("$2a$12$N4X9ca0j3XKf.oN/o1NAMOrvGosj46Eqw.U3zhsx9h9KAUpgCni72")//5678
//     .roles("USER","ADMIN")
//     .build();

//     return new InMemoryUserDetailsManager(normaluser,admin); 



//    }



@Bean
public UserDetailsService userDetailsService() {
    return userDetailService;
}

    @Bean
     public AuthenticationProvider authenticationProvider() {
         DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
     provider.setUserDetailsService(userDetailService);
         provider.setPasswordEncoder(passwordEncoder());
     return provider;
    }

    

   @Bean
   public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder(); 

   }

}
