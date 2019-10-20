package de.marcnuetzel.spockjunitcomparison.controller;

import de.marcnuetzel.spockjunitcomparison.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Marc Nützel on 20.10.19.
 */
@RestController
public class ExampleController {

  private final ExampleService exampleService;

  @Autowired
  public ExampleController(ExampleService exampleService) {
    this.exampleService = exampleService;
  }

  @GetMapping("/hello/{name}")
  public String helloWorld(@PathVariable String name) {
    return exampleService.helloWorld(name);
  }
}
