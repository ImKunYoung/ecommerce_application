package com.example.msuserservice.controller;

import com.example.msuserservice.outer.controller.UsersController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(UsersController.class)
public class UsersControllerTests {

    @Autowired
    private MockMvc mvc;

    @Test
    public void status() throws Exception {

        String result = "It's Working in User Service";
        System.out.println("result = " + result);
        System.out.println("result = " + result);
        System.out.println("result = " + result);
        System.out.println("result = " + result);
        System.out.println("result = " + result);
        System.out.println("result = " + result);
        System.out.println("result = " + result);
        System.out.println("result = " + result);
        System.out.println("result = " + result);
        System.out.println("result = " + result);
        System.out.println("result = " + result);
        System.out.println("result = " + result);
        System.out.println("result = " + result);
        System.out.println("result = " + result);
        System.out.println("result = " + result);
        System.out.println("result = " + result);
        System.out.println("result = " + result);
        System.out.println("result = " + result);
        System.out.println("result = " + result);
        System.out.println("result = " + result);
        System.out.println("result = " + result);
        System.out.println("result = " + result);
        System.out.println("result = " + result);
        System.out.println("result = " + result);
        System.out.println("result = " + result);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


        System.out.println(mvc.perform(get("/health_check"))
                .andReturn()
                .getResponse()
                .getContentAsString());

    }


}
