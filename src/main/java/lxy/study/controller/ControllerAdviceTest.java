package lxy.study.controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.NativeWebRequest;

/**
 * 全局Controller增强器（拦截器） 配合@ModelAttributes、@InitBinder、@ExceptionHandler使用
 * 分别对应Model初始化，WebDataBinder初始化、全局异常处理
 */
@ControllerAdvice
public class ControllerAdviceTest {

  /**
   * 用于对model进行前置初始化
   * @param model model对象
   */
  @ModelAttribute
  public void changeModel(Model model) {
    System.out.println("============应用到所有@RequestMapping注解方法，在其执行之前把返回值放入Model");
    model.addAttribute("author", "Jim");
  }

  /**
   * 用于对WebDataBinder进行绑定，通常意义上绑定各种Convert接口的实现类、PropertiesEditor实现
   * 即实现，从String到各种数据类型的转换
   * @param binder 绑定对象
   */
  @InitBinder
  public void initBinder(WebDataBinder binder) {
    System.out.println("============应用到所有的@RequestMapping注解方法，在其执行之前初始化数据绑定器");
  }


  /**
   * 设置要捕获的异常，并作出处理 注意：这里可以返回试图，也可以放回JSON，这里就当做一个Controller使用
   *
   * @param request {@link NativeWebRequest}
   * @param e {@link Exception}
   * @return {@link Map}
   */
  @ExceptionHandler(value = Exception.class)
  @ResponseBody
  public Map processUnauthenticatedException(NativeWebRequest request, Exception e) {
    System.out.println("===========应用到所有@RequestMapping注解的方法，在其抛出Exception异常时执行");
    Map map = new HashMap(5);
    map.put("code", 404);
    map.put("msg", e.getMessage());
    return map;
  }

}
