package com.davidtcdeveloper.thingsilikekotlin

fun sum(a: Int, b: Int) = OperationResult(a + b)

fun pow(a: Int, b: Int) = Math.pow(a.toDouble(), b.toDouble())

fun stringRepresentation(value: Any?): Any =
        when (value) {
            in 1..5 -> "A few"
            in 6..10 -> "Some"
            in 11..50 -> "A lot"
            in 51..100 -> "Too much"
            "A few" -> {
                println(value.toString())
                1
            }
            "Some" -> 6
            "A lot" -> 11
            "Too much" -> 51
            else -> "I don't know"
        }

fun Int.getStringRepresentation(): String {
    return stringRepresentation(this).toString()
}

data class OperationResult(val value: Int) {
    val description: String by lazy { stringRepresentation(value).toString() }
}