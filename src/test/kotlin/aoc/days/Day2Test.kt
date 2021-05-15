package aoc.days

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

class Day2Test {

    @Test
    fun `part one simple example`() =
        assertThat(
            Day2().process(listOf(2,4,4,5,99,0)),
            equalTo(
                listOf(2,4,4,5,99,9801)
            )
        )

    @Test
    fun `part one harder example`() =
        assertThat(
            Day2().process(listOf(1,1,1,4,99,5,6,0,99)),
            equalTo(
                listOf(30,1,1,4,2,5,6,0,99)
            )
        )
}