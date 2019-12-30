package com.konrad.hackerrank.roads_and_libraries

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.must.Matchers

class SolutionTest extends AnyFunSuite with Matchers {
  test("3 3 2 1") {
    Solution.roadsAndLibraries(3, 2, 1, Array(Array(1, 2), Array(3, 1), Array(2, 3))) must be(4)
  }

  test("6 6 2 5") {
    Solution.roadsAndLibraries(6, 2, 5, Array(Array(1, 3), Array(3, 4), Array(2, 4), Array(1, 2), Array(2, 3), Array(5, 6))) must be(12)
  }

  test("5 3 6 1") {
    Solution.roadsAndLibraries(5, 6, 1, Array(Array(1, 2), Array(1, 3), Array(1, 4))) must be(15)
  }

}
