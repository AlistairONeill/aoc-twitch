package aoc.days

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.Test

class Day3Test {

    @Test
    fun `example 1`() =
        assertThat(
            Day3().closestIntersection("R75,D30,R83,U83,L12,D49,R71,U7,L72\r\nU62,R66,U55,R34,D71,R55,D58,R83"),
            equalTo(
                159
            )
        )

    @Test
    fun `part 2`() =
        assertThat(
            Day3().fewestSteps("R75,D30,R83,U83,L12,D49,R71,U7,L72\r\nU62,R66,U55,R34,D71,R55,D58,R83"),
            equalTo(
                610
            )
        )
}