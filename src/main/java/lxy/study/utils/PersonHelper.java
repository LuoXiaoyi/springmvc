package lxy.study.utils;

import lxy.study.core.model.Person;

public class PersonHelper {

    public static Person buildPerson(String pId){

        Person p = new Person();

        p.setId(Integer.parseInt(pId));
        p.setName("Tom");
        p.setSex("male");

        return p;
    }
}
