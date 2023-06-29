package com.example.ProyectoFinal.security;

import com.example.ProyectoFinal.model.AppUserRole;
import com.example.ProyectoFinal.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private AppUserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/turnos/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/pacientes/**", "/odontologos/**").hasRole("ADMIN")
                .antMatchers("/api/**").permitAll()
                .anyRequest()
                .authenticated().and()
                .httpBasic().and()
                .formLogin();


        /*http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/Turnos/**").hasAnyRole("USER", "ADMIN")
                .antMatchers("/Pacientes/**", "/Odontologos/**").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .formLogin()
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/index");
                /*.csrf().disable()
                .authorizeRequests()
//                .antMatchers("/user/**")
//                .permitAll()
                .anyRequest()
                .authenticated().and()
                .formLogin();*/
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider =
                new DaoAuthenticationProvider();
        provider.setPasswordEncoder(bCryptPasswordEncoder);
        provider.setUserDetailsService(userService);
        return provider;
    }

}
