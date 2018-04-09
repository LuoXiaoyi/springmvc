package lxy.study.controller;

import lxy.study.core.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.io.Writer;

@Controller
public class AnotherTestController {

    /**
     * http://127.0.0.1:8080/springmvc/test2?personId=1234
     * @param personId 必须要传入，默认情况下，RequestParam这个参数是必须的，如果非必须，可以使用
     *                 将RequestParam的参数required设置为false
     * @param model
     * @return
     */
    @GetMapping("/test2")
    public String setupForm(@RequestParam("personId") int personId, ModelMap model) {
        System.out.println("personId: " + personId);
        Person p = new Person();
        p.setId(personId);
        model.addAttribute("person", p);
        return "index";
    }

    @PutMapping("/something")
    public void handle(@RequestBody String body, Writer writer) throws IOException {
        writer.write(body);
    }
}
