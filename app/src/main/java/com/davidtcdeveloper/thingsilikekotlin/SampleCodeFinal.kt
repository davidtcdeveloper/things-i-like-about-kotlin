package com.davidtcdeveloper.thingsilikekotlin

fun sum(a: Int, b: Int): DescriptibleNumber {
    val sum = a + b
    return sum.toDescriptibleNumber()
}

fun describeNumber(value: Any?): Any =
        when (value) {
            in 1..5 -> "A few"
            in 6..10 -> "Some"
            in 11..50 -> "Some more"
            in 51..100 -> "A lot more"
            "A few" -> {
                println("String is $value")
                1
            }
            "Some" -> 6
            "Some more" -> 11
            "A lot more" -> 51
            else -> "I don't know"
        }

fun Int.describeValue() = describeNumber(this)

fun Int.toDescriptibleNumber() = DescriptibleNumber(this)

data class DescriptibleNumber(val value: Int) {
    val description: String by lazy { value.describeValue().toString() }
}

interface SumInterface {
    fun sum(a: Int, b: Int): OperationResult
}

interface SubtractInterface {
    fun subtract(a: Int, b: Int): OperationResult
}

interface MultiplyInterface {
    fun multiply(a: Int, b: Int): OperationResult
}

interface DivideInterface {
    fun divide(a: Int, b: Int): OperationResult
}

class Sum : SumInterface {
    override fun sum(a: Int, b: Int): OperationResult = Success(DescriptibleNumber(a + b))
}

class Subtract : SubtractInterface {
    override fun subtract(a: Int, b: Int): OperationResult = Success(DescriptibleNumber(a - b))
}

class Multiply : MultiplyInterface {
    override fun multiply(a: Int, b: Int): OperationResult = Success(DescriptibleNumber(a * b))
}

class Divide : DivideInterface {
    override fun divide(a: Int, b: Int): OperationResult {
        if (b == 0) {
            return Error("Divide by zero")
        }
        return Success(DescriptibleNumber(a / b))
    }
}

class Calculator :
        SumInterface by Sum(),
        SubtractInterface by Subtract(),
        MultiplyInterface by Multiply(),
        DivideInterface by Divide()

sealed class OperationResult
data class Success(val result: DescriptibleNumber) : OperationResult()
data class Error(val message: String) : OperationResult()

/**
 *
interface SumInterface {
fun sum(a: Int, b: Int): DescriptibleNumber
}

interface SubtractInterface {
fun subtract(a: Int, b: Int): DescriptibleNumber
}

interface MultiplyInterface {
fun multiply(a: Int, b: Int): DescriptibleNumber
}

interface DivideInterface {
fun divide(a: Int, b: Int): DescriptibleNumber
}

class Sum : SumInterface {
override fun sum(a: Int, b: Int): DescriptibleNumber = DescriptibleNumber(a + b)
}

class Subtract : SubtractInterface {
override fun subtract(a: Int, b: Int): DescriptibleNumber = DescriptibleNumber(a - b)
}

class Multiply : MultiplyInterface {
override fun multiply(a: Int, b: Int): DescriptibleNumber = DescriptibleNumber(a * b)
}

class Divide : DivideInterface {
override fun divide(a: Int, b: Int): DescriptibleNumber = DescriptibleNumber(a / b)
}
 *
 *
 *
 * */