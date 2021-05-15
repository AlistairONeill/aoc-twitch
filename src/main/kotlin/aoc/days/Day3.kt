package aoc.days

import aoc.AbstractSolution
import kotlin.math.abs

class Day3: AbstractSolution() {
    override val day = 3

    override fun part1() = text.let(::closestIntersection)

    override fun part2() = text.let(::fewestSteps)

    fun closestIntersection(input: String) =
        input.split("\r\n")
            .let { closestIntersection(it.first(), it[1]) }


    fun closestIntersection(wire1: String, wire2: String): Int {
        val path1 = path(wire1.split(","))
        val path2 = path(wire2.split(","))
        return path1.intersect(path2)
            .minOf { abs(it.first) + abs(it.second) }
    }

    fun fewestSteps(input: String) =
        input.split("\r\n")
            .let { fewestSteps(it.first(), it[1]) }

    fun fewestSteps(wire1: String, wire2: String): Int {
        val path1 = path(wire1.split(","))
        val path2 = path(wire2.split(","))
        return path1.intersect(path2)
            .minOf { path1.indexOf(it) + path2.indexOf(it) } + 2
    }

    fun path(tokens: List<String>): List<Pair<Int, Int>> {
        val ret = ArrayList<Pair<Int, Int>>()
        var x = 0
        var y = 0
        tokens.forEach {
            val f: () -> Unit = when (it.first()) {
                'D' -> {{ y += 1}}
                'L' -> {{ x -= 1 }}
                'R' -> {{ x += 1 }}
                'U' -> {{ y -= 1 }}
                else -> throw Exception("FUBAR")
            }
            repeat(it.drop(1).toInt()) {
                f()
                ret.add(x to y)
            }
        }
        return ret
    }
}