package com.bojue.restful.test;

import com.bojue.restful.controller.UserController;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockServletContext.class)
@WebAppConfiguration
public class ApplicationTests {

    private static MockMvc mockMvc;

    @BeforeClass
    public static void initMock(){
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void testMvc() throws Exception {
        RequestBuilder request = null;
        request = get("/users/");
        mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().string("[]"));
        request = post("/users/")
                    .param("id","1")
                    .param("name","zhangsan")
                    .param("age","30");
        mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().string("success"));
        request = get("/users/");
        mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().string("[{\"id\":1,\"name\":\"zhangsan\",\"age\":30}]"));
        request = patch("/users/1")
                    .param("name","lisi")
                    .param("age","40");
        mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().string("success"));
        request = get("/users/1");
        mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().string("{\"id\":1,\"name\":\"lisi\",\"age\":40}"));
        request = delete("/users/1");
        mockMvc.perform(request).andExpect(status().isOk()).andExpect(content().string("success"));
    }
}
