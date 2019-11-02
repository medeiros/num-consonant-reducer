package com.arneam.numconsonantreducer.application;

import com.arneam.numconsonantreducer.domain.ConsonantReducer;
import com.arneam.numconsonantreducer.infrastructure.TextReducerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("reduce")
public class ConsonantReducerController {

  @Autowired
  private TextReducerClient textReducerClient;

  @GetMapping("/{name}")
  @ResponseStatus(HttpStatus.OK)
  public int reduceToNumber(@PathVariable String name) {
    return textReducerClient.reduceToNumber(ConsonantReducer.instance().reduceToConsonants(name));
  }

}
