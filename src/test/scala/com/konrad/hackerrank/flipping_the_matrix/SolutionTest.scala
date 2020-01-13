package com.konrad.hackerrank.flipping_the_matrix

import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers

class SolutionTest extends AnyFunSuite with Matchers {

  test("example 1") {
    Solution.flippingMatrix(Array(Array(1, 2), Array(3, 4))) should be(4)
  }

  test("example 2") {
    Solution.flippingMatrix(Array(Array(112, 42, 83, 119), Array(56, 125, 56, 49), Array(15, 78, 101, 43), Array(62, 98, 114, 108))) should be(414)
  }

}
