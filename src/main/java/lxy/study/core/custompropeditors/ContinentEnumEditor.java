package lxy.study.core.custompropeditors;

import java.beans.PropertyEditorSupport;
import lxy.study.core.enums.Continent;
import lxy.study.utils.StringUtils;

/**
 * Project: springmvc
 *
 * @author Luo.xiaoyi
 * @date 2018/04/25
 */
public class ContinentEnumEditor extends PropertyEditorSupport {

  @Override
  public void setAsText(String text){
    if(StringUtils.hasContent(text)){
      Continent c = Continent.fromName(text);
      super.setValue(c);
    }
  }

  @Override
  public void setValue(Object obj){
    if(obj != null && obj instanceof Continent){
      super.setValue(obj);
    }
  }

  @Override
  public String getAsText(){
    return super.getAsText();
  }

}
