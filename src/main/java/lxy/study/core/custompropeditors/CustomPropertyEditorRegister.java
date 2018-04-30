package lxy.study.core.custompropeditors;

import lxy.study.core.enums.Continent;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.stereotype.Component;

/**
 * Project: springmvc
 *
 * @author Luo.xiaoyi
 * @date 2018/04/26
 */
@Component
public class CustomPropertyEditorRegister implements PropertyEditorRegistrar {

  @Autowired
  private CustomEditorConfigurer customEditorConfigurer;

  private static Logger logger = LogManager.getLogger(CustomPropertyEditorRegister.class);

  public void registerCustomEditors(PropertyEditorRegistry registry){
    logger.info("begin to register custom editors...");
    registry.registerCustomEditor(Continent.class,new ContinentEnumEditor());
  }

}
