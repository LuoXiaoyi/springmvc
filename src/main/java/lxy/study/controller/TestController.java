/**
 * [Product]
 * springmvc
 * [Copyright]
 * Copyright © 2018 ZTESoft All Rights Reserved.
 * [FileName]
 * TestController.java
 * [History]
 * Version  Date      Author     Content
 * -------- --------- ---------- ------------------------
 * 1.0.0    Mar 27, 2018   Luo Xiaoyi    最初版本
 */
package lxy.study.controller;

import lxy.study.core.model.Person;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Locale;
import java.util.Map;

@Controller
        /* 意思是将指定类型的数据放到HttpSession中，以实现跨域携带。
        * 　1、names：这是一个字符串数组。里面应写需要存储到session中数据的名称。
　　        2、types：根据指定参数的类型，将模型中对应类型的参数存储到session中
 　         3、value：其实和names是一样的。

            如下：names为lxy、wr以及类型为Integer的属性都会被放到session
         * */
@SessionAttributes(names = {"lxy", "wr"}, types = {Integer.class})
public class TestController {

    /**
     * 如果不在@PathVariable写参数名， 则spring mvc会根据参数名称来获取同名的路径变量，不过如果选择了参数优化进行编译
     * 这种就会存在问题。
     * ${env} 为系统环境变量或者JVM的-D参数
     *
     * @param id
     * @param uuid
     * @param model
     * @return
     */
    @RequestMapping("/get/env/${env}/uuid/{uuid}")
    @ResponseBody
    public String get(@PathVariable("uuid") String id, @PathVariable String uuid, Model model) {
        System.out.println("get...");
        System.out.println("uuid: " + id);
        System.out.println("uuid2: " + uuid);
        System.out.println("model: " + model);
        return "Hello world.";
    }

    // /get/1000;color=1,2,3
    @RequestMapping(path = "/get/{matrixVariable}", method = RequestMethod.GET)
    @ResponseBody
    public String get2(@PathVariable String matrixVariable,
                       @MatrixVariable(name = "color") String color, Model model) {
        StringBuffer sb = new StringBuffer();
        sb.append("matrixVariable: " + matrixVariable);
        sb.append(", color:" + color); // 1,2,3
        sb.append(", model: " + model);
        return sb.toString();
    }

    @PostMapping(path = "/save", consumes = "application/json")
    @ResponseBody
    public String save(@RequestBody Person p, Model m) {
        if (p == null) return "nothing....";
        else
            return p.toString();
    }

    // 只有当请求参数中myParam这个值是lxy的时候，改请求才会执行 /test?myParam=lxy
    @GetMapping(path = "/test", params = "myParam=lxy")
    public @ResponseBody
    String test(@RequestParam String myParam) {
        return "myParam..." + myParam;
    }

    // Fetch all the request parameters
    @GetMapping(path = "/test4")
    public @ResponseBody
    String test4(@RequestParam Map<String, String> myParams) {
        return "Request params ..." + myParams;
    }

    // 只有当请求头中myParam这个值是lxy的时候，改请求才会执行
    @GetMapping(path = "/test2", headers = "myParam=lxy")
    public @ResponseBody
    String test2(@RequestHeader String myParam) {
        return "myHead..." + myParam;
    }

    // Fetch all the request headers parameters
    @GetMapping(path = "/test3")
    public @ResponseBody
    String test3(@RequestHeader Map<String, String> myHeadParams) {
        return "Request headers..." + myHeadParams;
    }

    @GetMapping(path = "/test5")
    public @ResponseBody
    String test5(HttpServletRequest httpServletRequest,
                 HttpSession httpSession,
                 ServletRequest servletRequest,
                 Locale locale,
                 HttpMethod httpMethod) {
        System.out.println("httpServletRequest: " + httpServletRequest);
        System.out.println("httpSession: " + httpSession);
        System.out.println("servletRequest: " + servletRequest);
        System.out.println("locale: " + locale);
        System.out.println("httpMethod: " + httpMethod);

        return "Request headers...";
    }

    @RequestMapping("/demo/show")
    public String index() {
        System.out.println("index....");
        return "/demo/hello";
    }

}
