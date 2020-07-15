package br.com.linx.cardValidator.configuration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpSessionListener;

@Configuration
@EnableWebMvc
@EnableCaching
@ComponentScan(basePackages = SpringConfiguration.BASE_PACKAGE)

@PropertySource("classpath:application.yaml")
public class SpringConfiguration implements WebMvcConfigurer, HttpSessionListener {

    public static final String BASE_PACKAGE = "br.com.linx.cardValidator";

    /** Encoding Padrão. */
    static final String APPLICATION_CHARSET = "UTF-8";

    /**
     * Define que a aplicação utilizar arquivos externos de configuração.
     *
     * @return Instância do configurador de arquivos.
     */


    @Bean
    static PropertySourcesPlaceholderConfigurer propertyConfig() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer
                .favorPathExtension(false); // to  avoid HttpMediaTypeNotAcceptableException on standalone tomcat
    }

    /**
     * Configuração da Documentação Swagger
     *
     */
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {



        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");



        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }


}