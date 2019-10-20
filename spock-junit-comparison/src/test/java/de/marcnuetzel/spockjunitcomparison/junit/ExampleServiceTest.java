package de.marcnuetzel.spockjunitcomparison.junit;

import static org.junit.jupiter.api.Assertions.assertTrue;

import de.marcnuetzel.spockjunitcomparison.service.ExampleService;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Created by Marc Nützel on 20.10.19.
 */
class ExampleServiceTest {

  public static final String EXAMPLE_NAME = "world";
  private ExampleService exampleService;

  @BeforeEach
  void initService() {
    this.exampleService = new ExampleService();
  }

  @Test
  void helloWorldReturnsHello() {
    assertTrue(exampleService.helloWorld(EXAMPLE_NAME).contains("Hello"));
  }

  @Test
  void helloWorldReturnsHelloFailing() {
    assertTrue(exampleService.helloWorld(EXAMPLE_NAME).contains("buggy"));
  }

  @DisplayName("Should return Hello + name")
  @ParameterizedTest(name = "{index} => name={0}, returnValue={1}")
  @MethodSource("argProvider")
  void helloWorldReturnsHelloName(String name, String returnValue) {
    assertTrue(exampleService.helloWorld(name).equals(returnValue));
  }

  private static Stream<Arguments> argProvider() {
    return Stream.of(
        Arguments.of("foo", "Hello foo"),
        Arguments.of("bar", "Hello bar")
    );
  }

}
