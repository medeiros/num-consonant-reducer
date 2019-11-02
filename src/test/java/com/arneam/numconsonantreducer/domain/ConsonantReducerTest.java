package com.arneam.numconsonantreducer.domain;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

class ConsonantReducerTest {

  @Test
  void shouldReduceToConsonants() {
    assertThat(ConsonantReducer.instance().reduceToConsonants("Daniel"), is(equalTo("Dnl")));
  }

}
