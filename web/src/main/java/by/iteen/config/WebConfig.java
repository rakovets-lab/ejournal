package by.iteen.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "by.iteen.controller")
@EnableWebMvc
@Import(value = {
        InternationalizationConfig.class,
        ThymeleafConfig.class,
        MvcConfig.class,
        SecurityConfig.class
})
public class WebConfig {

}
