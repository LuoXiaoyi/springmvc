package lxy.study.core.service;

import java.util.List;
import java.util.Map;
import lxy.study.core.model.Country;

/**
 * Project: springmvc
 *
 * @author Luo.xiaoyi
 * @date 2018/04/23
 */
public interface CountryService {

  public List<Country> queryAllCountries(Map<String,Object> param);
}
