package lxy.study.utils;

import java.util.Collection;
import java.util.Map;

/**
 * Project: springmvc
 *
 * @author Luo.xiaoyi
 * @date 2018/04/23
 */
public class AssertUtil {
  public static void assertObjectIsNotNull(Object object, String msg){
    if(object == null){
      throw new IllegalArgumentException(msg);
    }
  }

  public static void assertObjectIsNotEmpty(Object object, String msg){
    assertObjectIsNotNull(object,msg);

    if(object instanceof String){
      if(((String)object).length() == 0 || ((String)object).trim().length() == 0){
        throw new IllegalArgumentException(msg);
      }
    }else if(object instanceof Map){
      if(((Map)object).isEmpty()){
        throw new IllegalArgumentException(msg);
      }
    }else if(object instanceof Collection){
      if(((Collection)object).isEmpty()){
        throw new IllegalArgumentException(msg);
      }
    }
  }
}
