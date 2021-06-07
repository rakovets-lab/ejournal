package by.iteen.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login", "/resources/**", "/error")
                    .permitAll()

//                .antMatchers("/show/**")
//                    .hasAuthority("TEACHER")

                .antMatchers("/add/**", "/update/**")
                    .hasAuthority("METHODIST")

                .anyRequest()
                    .authenticated()

                .and().formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/login")
                    .defaultSuccessUrl("/profile")

                .and().logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/login")
                    .clearAuthentication(true)

                .and().csrf()
                    .disable();

                http.userDetailsService(userDetailsService);
    }
}
