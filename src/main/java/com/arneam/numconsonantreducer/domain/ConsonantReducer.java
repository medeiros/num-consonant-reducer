package com.arneam.numconsonantreducer.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ConsonantReducer {

  private static ConsonantReducer instance;

  public static ConsonantReducer instance() {
    if (instance == null) {
      instance = new ConsonantReducer();
    }
    return instance;
  }

  public String reduceToConsonants(String name) {
    return name.replaceAll("[^bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ]", "");
  }

  public int reduceToNumber(final String name) {
    int num = reduceToConsonants(name).toUpperCase().chars().map(c -> convertToValue((char) c))
        .reduce(0, Integer::sum);
    return num % 9 == 0 ? 9 : num % 9;
  }

  int convertToValue(final char character) {
    return "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(character) % 9 + 1;
  }

}
