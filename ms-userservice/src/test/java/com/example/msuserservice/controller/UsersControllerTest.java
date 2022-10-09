package com.example.msuserservice.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = UsersController.class)
public class UsersControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private Environment env;


    @Test
    public void status() throws Exception {

        String result = "It's Working in User Service";

        mvc.perform(get("/health_check"))
                .andExpect(status().isOk())
                .andExpect(content().string(result));


    }

    public void welcome() {

        String result = env.getProperty("greeting.message");
    }

    public void createUser() {



    }

}
