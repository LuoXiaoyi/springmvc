package lxy.study.core.service.impl;

import java.util.List;
import java.util.Map;
import lxy.study.core.mappers.CountryMapper;
import lxy.study.core.model.Country;
import lxy.study.core.service.CountryService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Project: springmvc
 *
 * @author Luo.xiaoyi
 * @date 2018/04/23
 */
@Service
public class CountryServiceImpl implements CountryService {

  private Logger logger = LogManager.getLogger(this.getClass());

  @Autowired
  private CountryMapper countryMapper;

  @Override
  public List<Country> queryAllCountries(Map<String,Object> param) {
    logger.info("queryAllCountries...");
    return countryMapper.queryAllCountriesByPage(param);
  }
}
