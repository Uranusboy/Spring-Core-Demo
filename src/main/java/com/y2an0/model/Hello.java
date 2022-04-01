package com.y2an0.model;

import org.springframework.remoting.caucho.HessianClientInterceptor;

public class Hello {
    public String name;

    public Object getObject() {
        return object;
    }
    private Hello hello;



    public void setHello(Hello hello) {
        this.hello = hello;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", object=" + object +
                '}';
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public Integer age;
    public Object object;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


}
