package com.davidtcdeveloper.thingsilikekotlin

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class UnitTestFinal {
    @Test
    fun sum_isCorrect() {
        val expected = 2.toDescriptibleNumber()
        val result = sum(1, 1)
        println("The result was ${result.value} and ${result.description}")
        assertEquals(expected.value, result.value)
        assertEquals(expected.description, result.description)
    }

    @Test
    fun describe_isCorrect() {
        assertEquals("A few", describeNumber(1))
        assertEquals("Some", describeNumber(6))
        assertEquals(6, describeNumber("Some"))
        assertEquals(1, describeNumber("A few"))
        assertEquals("I don't know", describeNumber(null))
    }

    @Test
    fun calculatorSum_isCorrect() {
        val expected = Success(2.toDescriptibleNumber())
        val result = Calculator().sum(1, 1)
        assertEquals(expected, result)
    }

    @Test
    fun calculatorDivide_divideByZero() {
        val expected = Error("Divide by zero")
        val result = Calculator().divide(1, 0)
        assertEquals(expected, result)
    }

}
