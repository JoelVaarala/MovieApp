package practiceWork.movieApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import practiceWork.movieApp.Web.UserDetailsServiceImpl;;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
    private UserDetailsServiceImpl userDetailsService;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests().antMatchers("/css/**").permitAll() // Enable css when logged out ++ haettavat tyylit yms kaikille avoinna
        .and()
        .authorizeRequests().antMatchers("/signup", "/saveuser").permitAll()
        .and()
        .authorizeRequests()
        .antMatchers("/h2-console/**").permitAll()
        .and().csrf().ignoringAntMatchers("/h2-console/**")
        .and().headers().frameOptions().sameOrigin()
          .and()
      .formLogin()
          .loginPage("/login") // (ei tarvita login endpointtia) -- kirjasto tarjoaa valmiin login ratkaisun!
          .defaultSuccessUrl("/movielist") // kun sisäänkirjautuminen onnistuu --> ohjaa tähän endpointtiin
          .permitAll()
          .and()
      .logout()
          .permitAll()
        	.and();
    }
    
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

}


