package com.marqusm.pollservice.controller;

import com.marqusm.pollservice.BaseIntegrationTest;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class PollControllerTest extends BaseIntegrationTest {

  @Test
  void getPolls_byEmail_01() throws Exception {
    mockMvc
        .perform(get("/polls?initiator_email=mh+sample@doodle.com"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(36)));
  }

  @Test
  void getPolls_byEmail_02() throws Exception {
    mockMvc
        .perform(get("/polls?initiator_email=random@doodle.com"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(0)));
  }

  @Test
  void getPolls_byTitle_01() throws Exception {
    mockMvc
        .perform(get("/polls?title=SuPeR"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)));
  }

  @Test
  void getPolls_byTitle_02() throws Exception {
    mockMvc
        .perform(get("/polls?title=oir"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(1)));
  }

  @Test
  void getPolls_createdAfter_01() throws Exception {
    mockMvc
        .perform(get("/polls?created_after=1485210475083"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(8)));
  }
}
