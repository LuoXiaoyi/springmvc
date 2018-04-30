/**
 * [Product] mybatis.study [Copyright] Copyright © 2018 ZTESoft All Rights Reserved. [FileName]
 * CityDao.java [History] Version  Date      Author     Content -------- --------- ----------
 * ------------------------ 1.0.0    Apr 15, 2018   Luo Xiaoyi    最初版本
 */
package lxy.study.core.mappers;

import java.util.List;
import java.util.Map;
import lxy.study.core.model.Country;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p> Class: CountryMapper </p>
 * Description: 
 *
 * @author Luo.xiaoyi
 *
 */
public interface CountryMapper {

  /**
   * 支持分页查询，通过<pageInfo,PageInfo>传入map
   * @param param
   * @return
   */
  List<Country> queryAllCountriesByPage(Map<String,Object> params);

  /**
   * 添加一个country
   * @param country 需要被添加的Country
   * @return 成功的数量
   */
  int saveCountry(Country country);
}
