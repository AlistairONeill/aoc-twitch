package aoc.days

import aoc.AbstractSolution
import aoc.computer.IntCodeComputer

class Day2: AbstractSolution() {
    override val day = 2

    override fun part1() =
        csv
            .map(String::toInt)
            .let(::IntCodeComputer)
            .run(12, 2)

    override fun part2(): Int {
        val computer = IntCodeComputer(csv.map(String::toInt))
        for (noun in (0 .. 99)) {
            for (verb in (0 .. 99)) {
                if (computer.run(noun, verb) == 19690720) {
                    return 100 * noun + verb
                }
            }
        }
        throw Exception("We didn't find a solution. Sad face")
    }
}