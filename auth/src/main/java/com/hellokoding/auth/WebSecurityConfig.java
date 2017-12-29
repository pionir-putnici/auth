package com.hellokoding.auth;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.hellokoding.auth.repository.UserRepository;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
// @EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Autowired
    private UserDetailsService userDetailsService;

    
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
     
//    @Bean
//    public EmbeddedServletContainerCustomizer containerCustomizer() {
//
//        return new EmbeddedServletContainerCustomizer() {
//            @Override
//            public void customize(ConfigurableEmbeddedServletContainer container) {
//
//                ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED,
//                        "/401.html");
//                ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND,
//                        "/404.html");
//                ErrorPage error500Page = new ErrorPage(
//                        HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");
//                ErrorPage error505Page = new ErrorPage(
//                        HttpStatus.HTTP_VERSION_NOT_SUPPORTED, "/505.html");
//                ErrorPage error506Page = new ErrorPage(
//                        HttpStatus.METHOD_NOT_ALLOWED, "/405.html");
//                container.addErrorPages(error401Page, error404Page,
//                        error500Page, error505Page, error506Page);
//            }
//        };
//    }    
    
//    @ControllerAdvice
//    public class MyExceptionController {
//        @ExceptionHandler(NoHandlerFoundException.class)
//        public ModelAndView handleError404(HttpServletRequest request, Exception e)   {
//                ModelAndView mav = new ModelAndView("/404");
//                mav.addObject("exception", e);  
//                //mav.addObject("errorcode", "404");
//                return mav;
//        }
//    }    

    @Override
    protected void configure(HttpSecurity http) throws Exception { 
//        http //.csrf().disable()
        http.csrf().disable()
        .authorizeRequests()
            .antMatchers("/resources/**",  "/static/**",  "/getAll*").permitAll()
            .antMatchers("/registration").hasRole("ADMIN") //"/registration",
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
        .logout()
            .permitAll();   
        http.exceptionHandling().accessDeniedPage("/403");

    }
    


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
    
}