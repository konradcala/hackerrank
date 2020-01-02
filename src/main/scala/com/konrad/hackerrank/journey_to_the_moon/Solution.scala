package com.konrad.hackerrank.journey_to_the_moon

import java.io._

import scala.collection.mutable

//https://www.hackerrank.com/challenges/journey-to-the-moon/problem
object Solution {

  // Complete the journeyToMoon function below.
  def journeyToMoon(n: Int, astronaut: Array[Array[Int]]): Long = {
    val checkedAstronauts = new Array[Boolean](n)
    val neighbours = new mutable.HashSet[Tuple2[Int, Int]]()

    for (a <- astronaut) {
      neighbours.add((a(0), a(1)))
      neighbours.add((a(1), a(0)))
    }

    val graph: Map[Int, Set[Int]] = neighbours.toSet.groupBy[Int](_._1).view.mapValues(_.map(_._2)).toMap
    var countryNumber = 0
    var citizenPerCountry = List[Int]()

    for (i <- 0 until checkedAstronauts.length) {
      if (checkedAstronauts(i) == false) {
        checkedAstronauts(i) = true
        var numberOfCitizens = 1
        val queue: mutable.Queue[Int] = new mutable.Queue[Int]()
        queue.addOne(i)

        while (!queue.isEmpty) {
          val current = queue.dequeue()
          val others = graph.getOrElse(current, Set())
          for (a <- others) {
            if (checkedAstronauts(a) == false) {
              checkedAstronauts(a) = true
              queue.addOne(a)
              numberOfCitizens += 1
            }
          }
        }
        citizenPerCountry = numberOfCitizens :: citizenPerCountry
      }
    }

    var sum = 0L
    var result = 0L
    for (p <- citizenPerCountry) {
      result += sum * p
      sum += p
    }
    result
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val np = stdin.readLine.split(" ")

    val n = np(0).trim.toInt

    val p = np(1).trim.toInt

    val astronaut = Array.ofDim[Int](p, 2)

    for (i <- 0 until p) {
      astronaut(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }

    val result: Long = journeyToMoon(n, astronaut)

    printWriter.println(result)

    printWriter.close()
  }
}

