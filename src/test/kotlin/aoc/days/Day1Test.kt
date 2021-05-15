package aoc.days

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

class Day1Test {

    private val day1 = Day1()

    @Test
    fun `using example input`() {
        assertThat(
            day1.getFuelNeededFor1(100756),
            equalTo(
                33583
            )
        )
    }

    @Test
    fun `part 2 example`() {
        assertThat(
            day1.getFuelNeededFor2(100756),
            equalTo(
                50346
            )
        )
    }
}