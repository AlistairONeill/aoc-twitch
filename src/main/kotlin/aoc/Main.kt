package aoc

import aoc.days.*

fun main() {
    val dayCreator: () -> AbstractSolution = ::Day2

    val day = dayCreator()
    println(day.part1())
    println(day.part2())
}