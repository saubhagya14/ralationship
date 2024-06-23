package com.example.demo;
import com.example.demo.controller.MyController.Controller;
import com.example.demo.entity.Students;
import com.example.demo.service.BookPublisherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@WebMvcTest(value = Controller.class)
public class TestClass {

    @MockBean
    BookPublisherService service;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testApi() throws Exception {
        //define the behaviour
        when(service.getStudent()).thenReturn(List.of(new Students()));
        //prepare http request
        MockHttpServletRequestBuilder requestBuilders =   MockMvcRequestBuilders.get("/students");
        //send request and hold response
        MvcResult mvcResult = mockMvc.perform(requestBuilders).andReturn();
        //validate response
        MockHttpServletResponse response = mvcResult.getResponse();
        int status = response.getStatus();
        assertEquals(200, status);
    }
}
