package com.cecil.groovy

import org.junit.Test

class GroovyTest extends GroovyTestCase {

    @Test
    def method1(int a, int b) {
        println a + b
    }

    @Test
    void testContain() {
        def greeting = { "Hello, $it!" }
        println greeting('Patrick')

        def aClosure = {
        String param1, int param2 ->
            println"this is code $param1 , $param2"
        }

        aClosure "1",2
    }

}