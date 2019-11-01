package com.arneam.numconsonantreducer.application;

import com.arneam.numconsonantreducer.domain.ConsonantReducer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consonant-reducer")
public class ConsonantReducerController {

  @GetMapping("/{name}")
  @ResponseStatus(HttpStatus.OK)
  public int reduceToNumber(@PathVariable String name) {
    return ConsonantReducer.instance().reduceToNumber(name);
  }

}
