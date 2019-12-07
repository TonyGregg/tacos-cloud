package sla.tacoscloud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Created by Antony Genil Gregory on 12/4/2019 7:33 PM
 * For project : tacos-cloud
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    DataSource dataSource;

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.inMemoryAuthentication()
////                .withUser("buzz")
////                .password("infinity")
////                .authorities("ROLE_USER")
////              .and()
////                  .withUser("woody")
////                    .password("bullseye")
////                    .authorities("ROLE_USER");
//
////        auth.jdbcAuthentication()
////                .dataSource(dataSource)
////                .usersByUsernameQuery("select user_id, password, enabled from Users" +
////                        "where user_id=?")
////                .authoritiesByUsernameQuery(
////                        "select user_id, authority from UserAuthorities " +
////                                "where user_id = ?");
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/design","/orders")
//                    .hasRole("USER")
//                .antMatchers("/","/**").permitAll();
//
//    }
}
