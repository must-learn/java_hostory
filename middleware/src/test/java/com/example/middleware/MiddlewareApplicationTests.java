package com.example.middleware;

import com.example.middleware.entity.Dl;
import com.example.middleware.service.DlService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MiddlewareApplicationTests {
    @Autowired
    DlService dlService;

    @Test
    public void contextLoads() {

    }

}
