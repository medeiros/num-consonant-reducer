package com.arneam.numconsonantreducer.infrastructure;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "num-text-reducer", fallback = TextReducerFallback.class)
public interface TextReducerClient {

  @GetMapping(value = "/reduce/{name}")
  int reduceToNumber(@PathVariable String name);

}
