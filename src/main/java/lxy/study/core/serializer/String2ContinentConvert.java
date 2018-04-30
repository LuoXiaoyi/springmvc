package lxy.study.core.serializer;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import lxy.study.core.enums.Continent;
import lxy.study.utils.StringUtils;

/**
 * Project: springmvc
 *
 * @author Luo.xiaoyi
 * @date 2018/04/26
 */
public class String2ContinentConvert implements Converter<String,Continent> {
  @Override
  public Continent convert(String source) {
    return StringUtils.hasContent(source) ? Continent.fromName(source):null;
  }

  @Override
  public JavaType getInputType(TypeFactory typeFactory) {
    return null;
  }

  @Override
  public JavaType getOutputType(TypeFactory typeFactory) {
    return null;
  }
}
