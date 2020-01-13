package com.konrad.hackerrank.flipping_the_matrix

//https://www.hackerrank.com/challenges/flipping-the-matrix/problem

import java.io._
import java.math._
import java.security._
import java.text._
import java.util._
import java.util.concurrent._
import java.util.function._
import java.util.regex._
import java.util.stream._

object Solution {

  // Complete the flippingMatrix function below.
  def flippingMatrix(matrix: Array[Array[Int]]): Int = {
    var sum = 0
    val n = matrix.length / 2
    for (i <- 0 until n) {
      for (j <- 0 until n) {
        sum += Math.max(Math.max(matrix(i)(j), matrix(2 * n - 1 - i)(j)), Math.max(matrix(i)(2 * n - 1 - j), matrix(2 * n - 1 - i)(2 * n - 1 - j)))
      }
    }

    sum
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val q = stdin.readLine.trim.toInt

    for (qItr <- 1 to q) {
      val n = stdin.readLine.trim.toInt

      val matrix = Array.ofDim[Int](2 * n, 2 * n)

      for (i <- 0 until 2 * n) {
        matrix(i) = stdin.readLine.split(" ").map(_.trim.toInt)
      }

      val result = flippingMatrix(matrix)

      printWriter.println(result)
    }

    printWriter.close()
  }
}
