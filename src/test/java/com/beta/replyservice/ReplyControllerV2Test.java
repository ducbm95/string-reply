package com.beta.replyservice;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class ReplyControllerV2Test {

  @Autowired
  private MockMvc mvc;

  @Test
  public void testReplyingSuccess() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/v2/reply/11-kbzw9ru").contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.jsonPath("$.message", CoreMatchers.is("kbzw9ru")));
  }

  @Test
  public void testReplyingInvalidInput() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/v2/reply/11kbzw9ru").contentType(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(MockMvcResultMatchers.jsonPath("$.message", CoreMatchers.is("Invalid input")));
  }
}
