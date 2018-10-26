package x3.benjamin.playground.apiserver.config;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Locale;

/**
 * Created by benjamin on 2017. 2. 14..
 */
@Configuration
@ComponentScan(basePackages = {
        "x3.benjamin.playground.apiserver.repository",
        "x3.benjamin.playground.apiserver.service"
})
public class RootApplicationContextConfig {

    @Bean(name = "system")
    public PropertiesFactoryBean propertiesFactoryBean() throws IOException {
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        bean.setLocation(new ClassPathResource("/properties/system.properties"));
        bean.afterPropertiesSet();
        return bean;
    }

    // TODO 1.
    @Bean
    public MessageSourceAccessor messageSourceAccessor() {

        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setDefaultEncoding("utf-8");
        // TODO 2. check property files.
        source.setBasename("messages/message_bundle");

        // TODO 3. constructor!
        MessageSourceAccessor accessor = new MessageSourceAccessor(source, Locale.US);
        return accessor;
    }
}
