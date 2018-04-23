package lxy.study.utils;

/**
 * Project: springmvc
 *
 * @author Luo.xiaoyi
 * @date 2018/04/23
 */
public class StringUtils {

  public static boolean isBlankOrEmpty(String str) {
    if(!isNull(str)){
      if(str.trim().length() == 0){
        return true;
      }
    }

    return false;
  }

  public static boolean isNull(String str) {
    return str == null ? true : false;
  }

  public static boolean hasContent(String str) {
    return str != null && str.trim().length() != 0;
  }

  public static boolean isNotNull(String str) {
    return str == null ? false : true;
  }

}
