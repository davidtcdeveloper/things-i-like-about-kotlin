package com.davidtcdeveloper.thingsilikekotlin

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val expected = OperationResult(2)
        val result = sum(1, 1)
        print("Result of sum was: ${result.value}, ${result.description}")
        assertEquals(expected.value, result.value)
        assertEquals(expected.description, result.description)
    }

    @Test
    fun pow_isCorrect() {
        assertEquals(4.0, pow(2, 2), 0.0)
    }

    @Test
    fun stringRepresentation_isCorrect() {
        assertEquals("A few", stringRepresentation(2))
        assertEquals("A few", 2.getStringRepresentation())
        assertEquals("A lot", 12.getStringRepresentation())
        assertEquals(1, stringRepresentation("A few"))
        assertEquals("I don't know", stringRepresentation(null))
    }
}
