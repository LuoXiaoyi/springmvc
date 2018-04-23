package lxy.study.core.controller;

import java.util.List;
import lxy.study.core.model.Country;
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
    return countryService.queryAllCountries();
  }
}
