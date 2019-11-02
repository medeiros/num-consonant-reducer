package com.arneam.numconsonantreducer.application;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class ConsonantConsonantControllerIT {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ConsonantReducerController consonantReducerController;

  @Test
  void shouldInjectController() {
    assertThat(consonantReducerController, is (notNullValue()));
  }

  @ParameterizedTest
  @CsvSource({"Daniel, 3", "Maria, 4"})
  void shouldReduceNameToNumber(String name, String number) throws Exception {
    mockMvc.perform(get("/reduce/" + name)).andExpect(status().isOk())
        .andExpect(content().string(containsString(number)));
  }

}
