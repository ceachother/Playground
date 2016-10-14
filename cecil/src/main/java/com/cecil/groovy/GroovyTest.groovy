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

    @Test
    void File() {
        def File targetFile = new File("build.gradle")
        targetFile.eachLine {
            String line ->
                println line
        }
    }

    @Test
    void inp() {
        def File targetFile = new File("build.gradle")
        def ism =  targetFile.newInputStream()
        //操作ism，最后记得关掉
        ism.close
    }

    @Test
    void outp() {
        def srcFile = new File("")
        def targetFile = new File("")
        targetFile.withOutputStream{
            os-> srcFile.withInputStream {
                ins->
                    os << ins //利用OutputStream的<<操作符重载，完成从inputstream到OutputStream  //的输出
            }
        }
    }

}