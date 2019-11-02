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

}
