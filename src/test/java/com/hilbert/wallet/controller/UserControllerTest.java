package com.hilbert.wallet.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hilbert.wallet.dto.UserDTO;
import com.hilbert.wallet.entity.User;
import com.hilbert.wallet.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @MockBean
    UserService service;

    @Autowired
    MockMvc mvc;

    private static final String EMAIL = "email@teste.com";
    private static final String NAME = "User Test";
    private static final String PASSWORD = "1233412";
    private static final String URL = "/user";

    //Basically, a POST requisition written in JAVA
    @Test
    public void testSave() throws Exception {

        BDDMockito.given(service.save(Mockito.any(User.class))).willReturn(getMockUser());

        mvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayload())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpectAll(status().isCreated(),content().contentType(MediaType.APPLICATION_JSON));
    }

    public User getMockUser(){
        User user = new User();
        user.setEmail(EMAIL);
        user.setName(NAME);
        user.setPassword(PASSWORD);

        return user;
    }

    public String getJsonPayload() throws JsonProcessingException {
        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(EMAIL);
        userDTO.setName(NAME);
        userDTO.setPassword(PASSWORD);

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(userDTO);
    }

}
