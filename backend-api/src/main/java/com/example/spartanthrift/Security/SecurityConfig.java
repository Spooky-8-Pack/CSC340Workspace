package com.example.spartanthrift.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private CustomUserDetailsService userDetailsService;

   @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers("/index").permitAll()
            .requestMatchers("/assets/**", "/css/**", "/js/**", 
                            "/products/**", "/seller-images/**", "/shop-images/**").permitAll() // allow static resources
            .requestMatchers("/log-in", "/api/sellers/createForm", "/api/sellers/create").permitAll()
            .requestMatchers("/storefront/**").permitAll()
            .anyRequest().authenticated()
        )
        .formLogin(form -> form
            .loginPage("/log-in")
            .loginProcessingUrl("/authenticate")
            .defaultSuccessUrl("/index", true)
            .permitAll()
        )
        .exceptionHandling(ex -> ex.accessDeniedPage("/403"))
        .logout(withDefaults());

    return http.build();
    }


    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

