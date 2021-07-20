package io.micronaut.inject.factory

import io.micronaut.ast.transform.test.AbstractBeanDefinitionSpec
import io.micronaut.inject.BeanDefinitionReference

class FactoryBeanDefinitionSpec extends AbstractBeanDefinitionSpec {

    void "test is context"() {
        given:
        BeanDefinitionReference definition = buildBeanDefinitionReference('io.micronaut.inject.factory.Test$MyFunc0','''\
package io.micronaut.inject.factory;

import io.micronaut.inject.annotation.*;
import io.micronaut.context.annotation.*;

@Factory
class Test {

    @Bean
    @Context
    java.util.function.Function<String, Integer> myFunc() {
        return (str) -> 10;
    }
}

''')
        expect:
        definition != null
        definition.isContextScope()
    }
}