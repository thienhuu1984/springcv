package funix.huutt.springcv.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SpringCVSecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager (DataSource dataSource) {

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        // define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select username as user_id, password, status from user where user.username=?  "
        );

        // define query to retrieve the authorities / roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select u.username as user_id, r.name as role  " +
                        "from user u join role r on r.id = u.role_id " +
                        "where u.username=? "
        );



        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/").permitAll()
                                .requestMatchers("/login/**").permitAll()
                                .requestMatchers("/perform/**").permitAll()
                                .requestMatchers("/register/**").permitAll()
                                .requestMatchers("/assets/**").permitAll()
                                .requestMatchers("/fragments/**").permitAll()
                                .requestMatchers("/candidate/**").hasAnyRole("Candidate", "Admin")
                                .requestMatchers("/company/**").hasAnyRole("Company", "Admin")
                )
                .formLogin(form ->
                        form
                                .loginPage("/login")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )
                .logout(logout ->
                        logout.permitAll()
                )
                .exceptionHandling(configurer ->
                        configurer
                                .accessDeniedPage("/access-denied")
                )
        ;

        return http.build();
    }



}
