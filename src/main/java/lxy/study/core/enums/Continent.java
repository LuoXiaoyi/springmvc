package lxy.study.core.enums;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lxy.study.core.serializer.Continent2StringConvert;
import lxy.study.core.serializer.String2ContinentConvert;

/**
 * Project: mybatis.study
 *
 * @author Luo.xiaoyi
 * @date 2018/04/21
 */
@JsonSerialize(converter = Continent2StringConvert.class, contentConverter = String2ContinentConvert.class)
public enum Continent {

  Asia, Europe, NorthAmerica, Africa, Oceania, Antarctica, SouthAmerica;

  public String toString() {
    if (this.equals(NorthAmerica)) {
      return "North America";
    } else if (this.equals(SouthAmerica)) {
      return "South America";
    } else {
      return name();
    }
  }

  public static Continent fromName(String continentName) {
    if ("North America".equals(continentName)) {
      return NorthAmerica;
    } else if ("South America".equals(continentName)) {
      return SouthAmerica;
    } else {
      return Continent.valueOf(continentName);
    }
  }
}
