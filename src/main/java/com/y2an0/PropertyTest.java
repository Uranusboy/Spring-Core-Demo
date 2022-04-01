package com.y2an0;

import org.springframework.beans.*;
import org.springframework.core.SpringProperties;
import org.springframework.core.io.support.SpringFactoriesLoader;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.util.List;

import static org.springframework.beans.CachedIntrospectionResults.IGNORE_BEANINFO_PROPERTY_NAME;

public class PropertyTest {
    static  List<BeanInfoFactory> beanInfoFactories;
    private static final boolean shouldIntrospectorIgnoreBeaninfoClasses = SpringProperties.getFlag(IGNORE_BEANINFO_PROPERTY_NAME);


    public PropertyTest() throws ClassNotFoundException {
    }

    public static void main(String[] args){
        TesstPropertyDescriptor();

    }
    public static void TesstPropertyDescriptor(){
        Class aClass= null;
        Class<?> aClass1=null;
        try {
            aClass = Class.forName("com.y2an0.model.Hello");
            aClass1 = Class.forName("java.lang.Class");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        beanInfoFactories = SpringFactoriesLoader.loadFactories(BeanInfoFactory.class, CachedIntrospectionResults.class.getClassLoader());
        try {
            BeanInfo beanInfo = getBeanInfo(aClass1);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            System.out.println(propertyDescriptors.length);
            for (PropertyDescriptor pd:propertyDescriptors) {
                System.out.println("======================================================================");
//                System.out.println(Class.class == aClass);
//                System.out.println((!"name".equals(pd.getName()) && !pd.getName().endsWith("Name")));
//                System.out.println(Class.class == aClass1 && (!"name".equals(pd.getName()) && !pd.getName().endsWith("Name")));
                if (Class.class == aClass1 && (!"name".equals(pd.getName()) && !pd.getName().endsWith("Name"))) {
                    // Only allow all name variants of Class properties
//                    System.out.print(pd.getName()+"==>"+pd+"\n");
                    continue;
                }
                System.out.print(pd.getName()+"==>"+pd+"\n");

            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }
    private static BeanInfo getBeanInfo(Class<?> beanClass) throws IntrospectionException {
        for (BeanInfoFactory beanInfoFactory : beanInfoFactories) {
            BeanInfo beanInfo = beanInfoFactory.getBeanInfo(beanClass);
            if (beanInfo != null) {
                return beanInfo;
            }
        }
        return (shouldIntrospectorIgnoreBeaninfoClasses ?
                Introspector.getBeanInfo(beanClass, Introspector.IGNORE_ALL_BEANINFO) :
                Introspector.getBeanInfo(beanClass));
    }

}
