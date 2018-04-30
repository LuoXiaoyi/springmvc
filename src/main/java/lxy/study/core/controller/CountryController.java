package lxy.study.core.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lxy.study.core.mappers.CountryMapper;
import lxy.study.core.model.Country;
import lxy.study.core.plugins.PageInfo;
import lxy.study.core.service.CountryService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Project: springmvc
 *
 * @author Luo.xiaoyi
 * @date 2018/04/23
 */
@RestController
public class CountryController {

  private static Logger logger = LogManager.getLogger(CountryController.class);

  @Autowired
  private CountryService countryService;

  @Autowired
  private ApplicationContext context;

  @RequestMapping("/country/queryAll")
  public List<Country> queryAllCountries(){
    CountryMapper cm = (CountryMapper)context.getBean("countryMapper");

    Map<String,Object> param = new HashMap<>();
    param.put(PageInfo.PAGE_INFO_KEY,PageInfo.DEFAULT_PAGE_INFO);
    return countryService.queryAllCountries(param);
  }

  @RequestMapping("/country/save")
  public int saveCountry(@RequestBody Country country){
    logger.debug("receive country info: " + country);
    return countryService.saveCountry(country);
  }
}
