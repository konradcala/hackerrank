package com.konrad.hackerrank.journey_to_the_moon

import org.scalatest.matchers.should.Matchers

class SolutionTest extends org.scalatest.FlatSpec with Matchers {
  "example 1" should "return 3 pairs" in {
    Solution.journeyToMoon(4, Array(Array(1, 2), Array(2, 3))) should be(3)
  }

  "example 2" should "return 6 paris" in {
    Solution.journeyToMoon(5, Array(Array(0, 1), Array(2, 3), Array(0, 4))) should be(6)
  }

  "example 3" should "return 9 paris" in {
    Solution.journeyToMoon(6, Array(Array(1, 2), Array(3, 2), Array(4, 2))) should be(9)
  }

  "example 4" should "return 9 paris" in {
    Solution.journeyToMoon(6, Array(Array(2, 1), Array(2, 3), Array(2, 4))) should be(9)
  }

  "test case 11" should "return 4999949998 paris" in {
    Solution.journeyToMoon(100000, Array(Array(1, 2), Array(3, 4))) should be(4999949998L)
  }
}
