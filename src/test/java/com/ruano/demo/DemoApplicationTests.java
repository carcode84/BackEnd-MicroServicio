package com.ruano.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureMockMvc
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT )
class DemoApplicationTests {

    @LocalServerPort
    private int port;
    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();
  
    @Autowired
    private MockMvc mockMvc;
      
    @Autowired
    protected WebApplicationContext webApplicationContext;
    
    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(this.webApplicationContext)
                .build();
    }
    
    @Test
	void contextLoads() throws JsonProcessingException, Exception {
        String jsonExpected = "{ \"mensaje\":\"El usuario si esta registrado.\", \"users\":[{\"firstname\":\"Pepe\",\"secondname\":\"Anderson\",\"lastname\":\"Perez\",\"sendlastname\":\"Gutierrez\",\"telefono\":\"5550102\",\"dirección\":\"Av siempre vida 123\",\"ciudad\":\"Springfield\"}]}";
        
        mockMvc.perform(post("/consultar/usuario")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"documento\":\"10121314\",\"tipoDocument\":\"c\"}"))
                .andExpect(status().is(200))
                .andExpect(content().string(jsonExpected));
        
	}

}
