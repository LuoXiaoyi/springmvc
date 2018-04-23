package lxy.study.core.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lxy.study.core.model.Country;
import lxy.study.core.plugins.PageInfo;
import lxy.study.core.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
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
  @Autowired
  private CountryService countryService;

  @RequestMapping("/country/queryAll")
  public List<Country> queryAllCountries(){
    Map<String,Object> param = new HashMap<>();
    param.put(PageInfo.PAGE_INFO_KEY,PageInfo.DEFAULT_PAGE_INFO);
    return countryService.queryAllCountries(param);
  }
}
