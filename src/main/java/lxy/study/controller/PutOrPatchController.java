package lxy.study.controller;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 *  @author Luo.xiaoyi
 *  @date 2018.04.03
 */
@RestController
public class PutOrPatchController {

    /**
     * 当客户端采用x-www-form-urlencoded这种content-type以PUT方式发送数据时，如果不配置
     * org.springframework.web.filter.HttpPutFormContentFilter 过滤器，那么在服务端将无法得到数据内容
     *
     * 当然，如果采用json、xml等数据格式，以raw数据类型从客户端发送请求时，在服务端则可以通过@RequestBody
     * 注解获取到数据。当然，required属性要设置成false，毕竟，客户可能不一定从raw发送数据
     * @param request  从这个request中以getparameter的方式获取x-www-form-urlencoded的k-v键值对
     * @param body  从这里获取raw数据
     */
    @PutMapping("/testput")
    public void testPut(HttpServletRequest request, @RequestBody(required = false) String body){
        System.out.println("put: " + request.getParameter("abc") + ",body: " + body);
    }

    /**
     * 用法完全和PUT一致
     * @param request
     * @param body
     */
    @PatchMapping("/testpach")
    public void testPact(HttpServletRequest request, @RequestBody(required = false) String body){
        System.out.println("put: " + request.getParameter("abc") + ",body: " + body);
    }

}
