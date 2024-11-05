// package com.saransh.spring_boot_library.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.web.accept.ContentNegotiationStrategy;
// import org.springframework.web.accept.HeaderContentNegotiationStrategy;

// import com.okta.spring.boot.oauth.Okta;

// @Configuration
// public class SecurityConfiguration {
//     @SuppressWarnings({ "deprecation", "removal" })
//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//         //Disable  Cross Site Request Forgery
//         http.csrf(csrf -> csrf.disable());
//         //Protect endpoint at /api/<type>/secure
//         http
//         .authorizeRequests(configurer -> configurer
//             .requestMatchers("/api/books/secure/**").authenticated()
//         )
//         .oauth2ResourceServer(server -> server.jwt());

//         //add cors filter
//         http.cors();

//         //Add content negotiation strategy
//         http.setSharedObject(ContentNegotiationStrategy.class, new HeaderContentNegotiationStrategy());

//         //Force a non - response empty body for 401's to make the response friendly
//         Okta.configureResourceServer401ResponseBody(http);
//         return http.build();
        
//     }
    
// }
