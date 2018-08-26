package x3.benjamin.playground.apiserver.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by benjamin on 2017. 2. 14..
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {""})
//TODO - 6 - Bean 클래스를 작성했으니 적절하게 ComponentScan 의 값을 바꾸면 됩니다.
public class ServletContextConfig {
}
