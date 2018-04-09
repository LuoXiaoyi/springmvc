package lxy.study.controller;

import lxy.study.core.model.Person;
import lxy.study.utils.PersonHelper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @RestController == @Controller + @ResponseBody
 * 默认是把响应body返回给调用端，大多数情况下都使用该种方式。
 *
 * */
@RestController
public class RestControllerTest {

    //Usage：http://127.0.0.1:8080/springmvc/queryPerson?personId=1234
    @RequestMapping("queryPerson")
    public Person queryPerson(@RequestParam("personId") String pId){
        return PersonHelper.buildPerson(pId);
    }

    @RequestMapping("createPerson/{pId}")
    public ResponseEntity<Person> savePerson(@PathVariable("pId") String pId, HttpEntity<byte[]> requestEntity){
        String requestHeader = requestEntity.getHeaders().getFirst("MyRequestHeader");
        byte[] requestBody = requestEntity.getBody();
        // do something with request header and body
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("MyResponseHeader", "MyValue");

        Person p = PersonHelper.buildPerson(pId);
        if(pId.endsWith("0"))
            return new ResponseEntity(p,responseHeaders,HttpStatus.CREATED);
        else
            return new ResponseEntity(responseHeaders,HttpStatus.UNAUTHORIZED);
    }

    @ModelAttribute
    public void test(){
        System.out.println(" test 123 ");
    }

    @RequestMapping("modelAttrTest")
    public void modleAttrTest(@ModelAttribute("pojo") String pojo){
        System.out.println("pojo: " + pojo);
    }
}
