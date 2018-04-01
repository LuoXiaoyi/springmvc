package lxy.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
// import org.springframework.web.servlet.view.JstlView;

@Configuration
public class AppConfig {

    @Bean
    public InternalResourceViewResolver getInternalResourceViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/demo/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(InternalResourceView.class);
        return resolver;
    }
}
