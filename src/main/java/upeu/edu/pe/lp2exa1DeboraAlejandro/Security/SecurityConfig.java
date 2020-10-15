package upeu.edu.pe.lp2exa1DeboraAlejandro.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity

public class SecurityConfig extends WebSecurityConfigurerAdapter{
@Autowired
private CustomDetailService userDeailsService;
@Autowired
private JwFilter jwFilter;

@SuppressWarnings("deprecation")
@Bean
 public PasswordEncoder passwordEncoder(){
     return NoOpPasswordEncoder.getInstance();
 }


@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	// TODO Auto-generated method stub
	auth.userDetailsService(userDeailsService);
}
@Bean(name=BeanIds.AUTHENTICATION_MANAGER)
@Override
protected AuthenticationManager authenticationManager() throws Exception {
	// TODO Auto-generated method stub
	return super.authenticationManager();
}
@Override
protected void configure(HttpSecurity http) throws Exception {
	// TODO Auto-generated method stub
	http.csrf().disable().authorizeRequests().antMatchers("/authenticate")
	.permitAll().anyRequest().authenticated()
	.and().exceptionHandling().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	http.addFilterBefore(jwFilter,UsernamePasswordAuthenticationFilter.class);
		
}


}
