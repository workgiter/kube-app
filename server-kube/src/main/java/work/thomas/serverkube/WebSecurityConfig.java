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
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.Arrays;
import java.util.List;


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
            .formLogin(withDefaults())
            .authorizeHttpRequests()
            .requestMatchers(
                 "/people/", "/people/edit", "/error", "/login"
            ).permitAll()
            .requestMatchers("/people/*")
            .hasRole("USER")
            .and().csrf().disable();
		return http.build();
    }

    /**
     * user details.
     * @return idk
     */
    @Bean
    public UserDetailsService users() {
    //     UserDetails user = User.builder()
    //         .username("user")
    //         .password(
    // "{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW"
    //         )
    //         .roles("USER")
    //         .build();
    //     UserDetails admin = User.builder()
    //         .username("admin")
    //         .password(
    // "{bcrypt}$2a$10$GRLdNijSQMUvl/au9ofL.eDwmoohzzS7.rmNSJZ.0FxO/BTk76klW"
    //         )
    //         .roles("USER", "ADMIN")
    //         .build();
    //     return new InMemoryUserDetailsManager(user, admin);
        UserDetails user =
        User.withDefaultPasswordEncoder()
        .username("user")
        .password("password")
        .roles("USER")
        .build();

        return new InMemoryUserDetailsManager(user);
    }

    /**
     * sd.
     * @return hj
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(List.of("*"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowedMethods(
            Arrays.asList("GET", "POST", "OPTIONS"));
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source
            = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }

}
