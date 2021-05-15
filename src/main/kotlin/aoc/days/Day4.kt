package aoc.days

import aoc.AbstractSolution

class Day4: AbstractSolution() {
    override val day = 4

    override fun part1() = (130254 .. 678275).count(::passesRule)

    override fun part2() = (130254 .. 678275).count(::passesRule2)

    private fun passesRule(number: Int) : Boolean {
        val str = number.toString()
        if ((0..4).none { str[it] == str[it+1] }) return false
        if ((0..4).any { str[it+1] < str[it] }) return false
        return true
    }

    private fun passesRule2(number: Int): Boolean {
        val str = number.toString()
        if ((0..4).any { str[it+1] < str[it] }) return false

        var count = 1
        var char = str[0]
        for (i in 1..5) {
            val newChar = str[i]
            if (char == newChar) {
                count += 1
            } else if (count == 2) {
                return true
            } else {
                count = 1
                char = newChar
            }
        }

        return count == 2
    }
}