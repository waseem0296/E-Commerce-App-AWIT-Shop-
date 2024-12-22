package com.AWIT.shop.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable() // Disable CSRF for simplicity (not recommended for production)
//                .authorizeHttpRequests()
//                .requestMatchers("/user/saveUser").permitAll() // Allow public access to this endpoint
//                .anyRequest().authenticated() // Require authentication for other endpoints
//                .and()
//                .formLogin()
//                .loginPage("/login") // Custom login page (if needed)
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//        return http.build();
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
