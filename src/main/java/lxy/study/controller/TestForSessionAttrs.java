package lxy.study.controller;

import lxy.study.core.model.Person;
import lxy.study.utils.PersonHelper;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@RestController
/**
 * 回把属性名为person和类型为Integer的对象放入到HttpSession中
 */
@SessionAttributes(names="person",types = Integer.class)
public class TestForSessionAttrs {

    @RequestMapping("/session-attrs/begin")
    public void testSessionAttr(Model model){
        Person p = PersonHelper.buildPerson("34567");
        // model中添加person属性
        model.addAttribute("person",p);
        // model中添加Integer属性
        model.addAttribute("salary",new Integer(1000));
    }

    @RequestMapping("/session-attrs/get")
    public void testSessionAttr2(@ModelAttribute("person") Person person,
                                 @SessionAttribute("person") Person person2,  ModelMap model,
                                 SessionStatus sessionStatus){
        System.out.println("session person: " + person);
        System.out.println("session person2: " + person2);
        System.out.println("salary: " + model.get("salary"));
        // 设置session失效
        sessionStatus.setComplete();
    }

    @RequestMapping("/session-attrs/complete")
    public void testSessionAttr3(ModelMap model){
        //已经被清除，无法获取person的值
        System.out.println("session person: " + model.get("person"));
        System.out.println("salary: " + model.get("salary"));
    }

}
