package com.imooc.ioc.demo4;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDemo4 {

    @Test
    public void demo1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User)applicationContext.getBean("user");
        System.out.println(user);
    }
    @Test

    public void demo2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = (Person)applicationContext.getBean("person");
        System.out.println(person.toString());
    }
    @Test
    public void demo3() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Product product = (Product) applicationContext.getBean("product");
        System.out.println(product.toString());
    }

    @Test
    public void demo4() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CollectionBean collectionBean = (CollectionBean) applicationContext.getBean("collectionBean");
        System.out.println(collectionBean.toString());
    }
}
