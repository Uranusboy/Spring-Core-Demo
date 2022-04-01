package com.y2an0.Controller;


import com.y2an0.model.Hello;
import org.springframework.jndi.JndiAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.beans.*;
import java.net.URL;

@Controller
public class TestController {
    @RequestMapping("/index")
    @ResponseBody
    public String Index(Hello hello) throws IntrospectionException {
        hello.setAge(1);
        hello.setName("y2an0");
//        URL context = getClass().getModule().getClassLoader().getResource("context");
//        BeanInfo beanInfo = Introspector.getBeanInfo(JndiAccessor.class);
//
//        BeanDescriptor beanDescriptor = beanInfo.getBeanDescriptor();
//        MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();
//        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
//
//        // 打印
//        System.out.println(beanDescriptor);
//        System.out.println("------------------------------");
//        Arrays.stream(methodDescriptors).forEach(x -> System.out.println(x));
//        System.out.println("------------------------------");
//        Arrays.stream(propertyDescriptors).forEach(x -> System.out.println(x));
//        System.out.println("------------------------------");
        return hello.toString();
    }

    @GetMapping("/Test")
    @ResponseBody
    public String Test(Hello hello){
        return "hello world";
    }

}
