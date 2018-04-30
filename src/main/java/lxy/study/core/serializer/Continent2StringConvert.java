package lxy.study.core.serializer;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import lxy.study.core.enums.Continent;
import com.fasterxml.jackson.databind.util.Converter;

/**
 * Project: springmvc
 *
 * @author Luo.xiaoyi
 * @date 2018/04/26
 */
public class Continent2StringConvert implements Converter<Continent,String> {
  @Override
  public String convert(Continent source) {
    return source != null ? source.toString():"";
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
