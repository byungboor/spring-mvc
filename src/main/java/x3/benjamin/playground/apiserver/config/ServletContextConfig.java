package x3.benjamin.playground.apiserver.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import x3.benjamin.playground.apiserver.intercepter.LoggingHandlerIntercepter;
import x3.benjamin.playground.apiserver.viewresolver.JsonViewResolver;
import x3.benjamin.playground.apiserver.viewresolver.XmlViewResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by benjamin on 2017. 2. 14..
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"x3.benjamin.playground.apiserver.controller"})

public class ServletContextConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(jackson2HttpMessageConverter());
        super.configureMessageConverters(converters);
    }

    @Bean
    public MappingJackson2HttpMessageConverter jackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new Jdk8Module());
        jsonConverter.setObjectMapper(objectMapper);

        jsonConverter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
        return jsonConverter;
    }

    //TODO 2
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loggingHandlerIntercepter());
        registry.addInterceptor(localeChangeInterceptor());
        super.addInterceptors(registry);
    }

    @Bean
    public LoggingHandlerIntercepter loggingHandlerIntercepter() {
        LoggingHandlerIntercepter intercepter = new LoggingHandlerIntercepter();
        return intercepter;
    }

    //TODO 1
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("lang");
        return interceptor;
    }

    //TODO 3
    @Bean
    public AcceptHeaderLocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver() {
            @Override
            public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
                LocaleContextHolder.setLocale(locale);
            }
        };

        localeResolver.setDefaultLocale(Locale.US);
        return localeResolver;
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
        configurer.favorParameter(false);
        configurer.ignoreAcceptHeader(false);
        configurer.defaultContentType(MediaType.APPLICATION_XML);
        super.configureContentNegotiation(configurer);
    }

    @Bean
    public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);

        List<ViewResolver> viewResolvers = new ArrayList<>();
        viewResolvers.add(jsonViewResolver());
        viewResolvers.add(xmlViewResolver());
        resolver.setViewResolvers(viewResolvers);
        return resolver;
    }

    @Bean
    public Map<String, MediaType> supportedMediaType() {
        Map<String, MediaType> mediaTypeMap = new HashMap<>();
        mediaTypeMap.put("json", MediaType.APPLICATION_JSON);
        mediaTypeMap.put("xml", MediaType.APPLICATION_XML);
        return mediaTypeMap;
    }

    @Bean
    public JsonViewResolver jsonViewResolver() {
        return new JsonViewResolver();
    }

    @Bean
    public XmlViewResolver xmlViewResolver() {
        return new XmlViewResolver();
    }

}
