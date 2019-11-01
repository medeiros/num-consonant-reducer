package com.arneam.numconsonantreducer.domain;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class ConsonantReducerTest {

  @Test
  void shouldReduceToVowels() {
    assertThat(ConsonantReducer.instance().reduceToConsonants("Daniel"), is(equalTo("Dnl")));
  }

  @ParameterizedTest
  @CsvSource(value={"A, 1", "B, 2", "O, 6", "L, 3", "R, 9", "S, 1", "V, 4"})
  void shouldConvertCharToValue(char character, int value) {
    assertThat(ConsonantReducer.instance().convertToValue(character), is(equalTo(value)));
  }

  @ParameterizedTest
  @CsvSource(value={"Daniel, 3", "Maria, 4"})
  void shouldReduceToNumber(String name, int number) {
    assertThat(ConsonantReducer.instance().reduceToNumber(name), is(equalTo(number)));
  }
  
}
