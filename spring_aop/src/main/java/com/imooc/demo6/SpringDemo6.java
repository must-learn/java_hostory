package com.imooc.demo6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext4.xml")
public class SpringDemo6 {

    @Resource(name = "customerDao")
    private CustomerDao customerDao;
    @Resource(name = "studentDao")
    private StudentDao studentDao;

    @Test
    public void demo6(){
        customerDao.delete();
        customerDao.find();
        customerDao.save();
        customerDao.update();

        studentDao.delete();
        studentDao.find();
        studentDao.save();
        studentDao.update();
    }

}
