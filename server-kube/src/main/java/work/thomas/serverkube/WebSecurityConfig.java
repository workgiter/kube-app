package work.thomas.serverkube;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    /**
     * choses what to protect with secuirty.
     * @param http
     * @return http secuirty
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http)
    throws Exception {
        //NOTE: disabling csrf makes the app vurable to Cross-site
        //request forgery, a web security vulnerability that allows
        //an attacker to induce users to perform actions that they
        //do not intend to perform
        http
            .cors().and()
            .authorizeHttpRequests()
            .requestMatchers(
                "/people/", "/people/edit", "/error", "/login"
            ).permitAll()
            .requestMatchers("/people/*")
            .hasRole("USER")
            .and().httpBasic()
            .and()
            .csrf().disable();
		return http.build();
    }

    /**
     * user details.
     * @return idk
     */
    @Bean
    public UserDetailsService users() {
        UserDetails user = User.withUsername("user")
        .password("{bcrypt}$2a$10$dXJ3SW6G7P50lGmMkkmwe.20cQQubK3.HZWzG3YB1tlRy.fqvM/BG")
        .roles("USER")
        .build();

        return new InMemoryUserDetailsManager(user);
    }

}
