/*
 * package teacherweb.com.configuration;
 * 
 * import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter;
 * 
 * 
 * //@Configuration public class SercurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception {
 * 
 * http.authorizeRequests().antMatchers("/").permitAll()
 * .antMatchers("/login").permitAll() .antMatchers("/check/login").permitAll()
 * .antMatchers("/register").permitAll() .anyRequest()
 * .authenticated().and().csrf().disable();
 * 
 * 
 * }
 * 
 * }
 */