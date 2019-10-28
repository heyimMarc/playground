package de.marcnuetzel.spockjunitcomparison.spock

import de.marcnuetzel.spockjunitcomparison.service.ExampleService
import spock.lang.Specification
import spock.lang.Title
import spock.lang.Unroll

/**
 * Created by Marc Nützel on 20.10.19.
 */
@Title("Testing the ExampleService")
class ExampleServiceSpec extends Specification {

    public static final String EXAMPLE_NAME = "world"
    ExampleService exampleService

    def setup() {
        this.exampleService = new ExampleService()
    }

    def "When exampleService.helloWorld is triggered then result should contain Hello."() {
        expect:
        exampleService.helloWorld(EXAMPLE_NAME).contains("Hello")
    }

    def "When exampleService.helloWorld is triggered then result should contain hello, but fails."() {
        expect: "String that contains buggy in result."
        exampleService.helloWorld(EXAMPLE_NAME).contains("buggy")
    }

    //@Unroll
    def "When exampleService.helloWorld is triggered then result should return Hello + provided name"() {
        expect:
        exampleService.helloWorld(name).contains(returnValue)

        where:
        name       | returnValue
        "foo"      | "Hello foo"
        "bar"      | "Hello bar"
    }

    def "given when then example"() {
        given: "a name"
        def name = "foo"

        and: "a returnValue"
        def returnValue = "Hello foo"

        when: "service is called with name"
        def result = exampleService.helloWorld(name)

        then: "result should be equal to returnValue"
        result.equals(returnValue)
    }

    def "given when then extended example"() {
        given: "a name"
        def name = "foo"

        and: "a returnValue"
        def returnValue = "Hello foo"

        and: "a second name"
        def secondName = "bar"

        when: "service is called with name"
        def result = exampleService.helloWorld(name)

        then: "result should be equal to returnValue"
        result.equals(returnValue)

        when: "service is called with second name"
        result = exampleService.helloWorld(secondName)

        then: "result shouldn't equal to returnValue"
        !result.equals(returnValue)
    }

}
