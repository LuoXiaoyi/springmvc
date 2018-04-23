/**
 * [Product] mybatis.study [Copyright] Copyright © 2018 ZTESoft All Rights Reserved. [FileName]
 * CityDao.java [History] Version  Date      Author     Content -------- --------- ----------
 * ------------------------ 1.0.0    Apr 15, 2018   Luo Xiaoyi    最初版本
 */
package lxy.study.core.mappers;

import java.util.List;
import lxy.study.core.model.Country;

/**
 * <p> Class: CountryMapper </p>
 * Description: 
 *
 * @author Luo.xiaoyi
 *
 */
public interface CountryMapper {

  List<Country> queryAllCountries();

}
