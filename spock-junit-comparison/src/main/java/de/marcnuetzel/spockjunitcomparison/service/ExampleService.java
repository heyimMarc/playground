package de.marcnuetzel.spockjunitcomparison.service;

import org.springframework.stereotype.Service;

/**
 * Created by Marc Nützel on 20.10.19.
 */
@Service
public class ExampleService {

  public String helloWorld(String name) {
    return "Hello " + name;
  }
}
