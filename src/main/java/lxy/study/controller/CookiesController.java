package lxy.study.controller;

import java.io.IOException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Luo.xiaoyi
 * @date 2018.04.03
 */
@RestController
public class CookiesController {

  /**
   * 这里采用PostMan发送测试数据时，必须要在header中手动添加Cookie和JSESSIONID=121204918320948123084021
   * 才能在服务端接收到Cookies数据
   *
   * @param jsessionId 获取到的cookie值
   * @param request 请求对象
   * @param response 回复对象
   * @throws IOException IO异常
   */
  @GetMapping("/testCookies")
  public void testCookies(@CookieValue(name = "JSESSIONID", required = false) String jsessionId,
      HttpServletRequest request, HttpServletResponse response) throws IOException {

    Cookie cks[] = request.getCookies();
    if (cks != null) {
      for (Cookie c : cks) {
        System.out.println(c.getName() + ":" + c.getValue());
      }
    } else {
      System.out.println("cookies is null");
      response.getOutputStream().write("cookies is null".getBytes());
    }
    String target = "JSESSIONID: " + jsessionId;
    System.out.println(target);
    response.getOutputStream().write(target.getBytes());
  }

}
