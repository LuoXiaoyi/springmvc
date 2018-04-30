package lxy.study.config;

import lxy.study.core.custompropeditors.CustomPropertyEditorRegister;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
// import org.springframework.web.servlet.view.JstlView;

@Configuration
/**
 * @EnableWebMvc 这个注解一方面会添加相关的映射处理，另外还会注册几乎所有常用的Converts，
 * 如： JSON、XML、日期、表单等
 */
@EnableWebMvc
public class AppConfig {

  /**
   * Jsp视图解析器
   */
  @Bean
  public InternalResourceViewResolver getInternalResourceViewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/");
    resolver.setSuffix(".jsp");
    resolver.setViewClass(JstlView.class);
    return resolver;
  }

  /**
   * 注册属性自定义属性编辑器
   * @return
   */
  @Bean
  public CustomEditorConfigurer getCustomEditorConfigurer(){
    CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();
    customEditorConfigurer.setPropertyEditorRegistrars(
        new PropertyEditorRegistrar[]{new CustomPropertyEditorRegister()});
    return customEditorConfigurer;
  }
}
