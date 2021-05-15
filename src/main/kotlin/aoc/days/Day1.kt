package aoc.days

import aoc.AbstractSolution

class Day1: AbstractSolution() {
    override val day = 1
    override fun part1() = lines.map(String::toLong).sumOf { it/3 - 2 }
    override fun part2() = lines.map(String::toLong).sumOf(::getFuelNeededFor2)

    fun getFuelNeededFor1(mass: Long) = mass/3 - 2

    fun getFuelNeededFor2(mass: Long): Long {
        val fuel = mass / 3 - 2
        return if (fuel > 0) {
            fuel + getFuelNeededFor2(fuel)
        }
        else {
            0
        }
    }
}