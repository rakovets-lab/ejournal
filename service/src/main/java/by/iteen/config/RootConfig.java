package by.iteen.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "by.iteen.service")
@EnableTransactionManagement
@Import(value = {DaoConfig.class, AspectConfig.class})
public class RootConfig {

}
