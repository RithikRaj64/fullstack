package com.educonnect.rithikraj.config;

import static com.educonnect.rithikraj.utils.MyConstant.HEADERS;
import static com.educonnect.rithikraj.utils.MyConstant.METHODS;
import static com.educonnect.rithikraj.utils.MyConstant.ORIGINS;
import static com.educonnect.rithikraj.utils.MyConstant.WHITELIST;
import static org.springframework.security.config.http.SessionCreationPolicy.STATELESS;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
                            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                            .authorizeHttpRequests(authorize -> authorize.requestMatchers(WHITELIST)
                                                                            .permitAll()
                                                                            .anyRequest().authenticated())   
                            .sessionManagement(session -> session.sessionCreationPolicy(STATELESS))
                            .authenticationProvider(authenticationProvider)
                            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                            .logout(logout -> logout.logoutUrl("/api/v1/auth/logout")
                                                        .addLogoutHandler(logoutHandler)
                                                        .logoutSuccessHandler(
                                                            (request, response, authentication) -> SecurityContextHolder.clearContext()))
                            .build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        corsConfiguration.setAllowedOrigins(ORIGINS);
        corsConfiguration.setAllowedHeaders(HEADERS);
        corsConfiguration.setAllowedMethods(METHODS);
        corsConfiguration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);

        return source;
    }

}
