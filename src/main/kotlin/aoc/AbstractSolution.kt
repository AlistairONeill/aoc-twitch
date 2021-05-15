package aoc

import java.io.File

abstract class AbstractSolution {
    abstract val day: Int
    abstract fun part1(): Any
    abstract fun part2(): Any

    private val file get() = File("input/day$day.txt")
    val text get() = file.readText()
    protected val lines get() = file.readLines().filter(String::isNotBlank)
    protected val csv get() = text.split(",")
}