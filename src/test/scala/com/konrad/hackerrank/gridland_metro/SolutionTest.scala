package com.konrad.hackerrank.gridland_metro

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class SolutionTest extends AnyFunSuite with Matchers {
  test("first") {
    Solution.gridlandMetro(4, 4, 4, Array(Array(4, 4, 3), Array(2, 2, 3), Array(3, 1, 4), Array(4, 4, 4))) should be (9)
  }

  test("second") {
    Solution.gridlandMetro(4, 4, 4, Array(Array(4, 4, 3), Array(2, 2, 3), Array(3, 1, 4), Array(4, 4, 4))) should be (9)
  }

}
