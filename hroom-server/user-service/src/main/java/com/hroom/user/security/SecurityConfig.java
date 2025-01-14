// package com.hroom.user.security;

// import java.beans.Customizer;

// import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
// import org.keycloak.adapters.springsecurity.authentication.KeycloakAuthenticationProvider;
// import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Import;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
// import org.springframework.security.core.session.SessionRegistryImpl;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.factory.PasswordEncoderFactories;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.provisioning.InMemoryUserDetailsManager;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
// import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.CorsConfigurationSource;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

// @Configuration
// @EnableWebSecurity
// @Import(KeycloakSpringBootConfigResolver.class)
// public class SecurityConfig  extends KeycloakWebSecurityConfigurerAdapter {

//     @Bean
//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http
//                 .authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated())
//                 .httpBasic(Customizer.withDefaults())
//                 .formLogin(Customizer.withDefaults());

//         return http.build();
//     }

//     @Bean
//     public UserDetailsService userDetailsService() {
//         PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//         UserDetails user = User
//                             .withUsername("spring_user")
//                             .password(encoder.encode("password123"))
//                             .roles("USER_ROLE")
//                             .build();

//         return new InMemoryUserDetailsManager(user);
//     }


//     @Override
//     protected void configure(HttpSecurity http) throws Exception {

//         super.configure(http);
//         http.csrf().disable();
//         //http.authorizeRequests()
//                 //.antMatchers("/").permitAll()
//                 //.antMatchers("/user").hasRole("ROLE_USER") -> @RoleAllowed
//                 //.antMatchers("/admin").hasRole("ROLE_ADMIN") -> @RoleAllowed
//         //        .anyRequest().denyAll();

//         http.authorizeRequests().anyRequest().permitAll();
//     }

//     @Autowired
//     protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//         KeycloakAuthenticationProvider provider = keycloakAuthenticationProvider();
//         provider.setGrantedAuthoritiesMapper(new SimpleAuthorityMapper());
//         auth.authenticationProvider(provider);
//     }

//     @Bean
//     @Override
//     protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
//         return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
//     }

//     @Bean
//     CorsConfigurationSource corsConfigurationSource() {
//         UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//         source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
//         return source;
//     }

// }
