/**
 * [Product]
 * springmvc
 * [Copyright]
 * Copyright © 2018 ZTESoft All Rights Reserved.
 * [FileName]
 * Person.java
 * [History]
 * Version  Date      Author     Content
 * -------- --------- ---------- ------------------------
 * 1.0.0    Mar 29, 2018   Luo Xiaoyi    最初版本
 */
package lxy.study.core.model;

/**
 * <p> Class: Person </p>
 * Description: 
 *
 * @author Luo.xiaoyi
 *
 */
public class Person {

    private int id;
    private String name;
    private String sex;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", sex=" + sex + "]";
    }
}
