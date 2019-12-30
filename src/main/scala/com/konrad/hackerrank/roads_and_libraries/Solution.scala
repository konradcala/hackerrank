package com.konrad.hackerrank.roads_and_libraries

import java.io._

import scala.collection.{MapView, mutable}
//https://www.hackerrank.com/challenges/torque-and-development/problem
object Solution {

  // Complete the roadsAndLibraries function below.
  def roadsAndLibraries(n: Int, c_lib: Int, c_road: Int, cities: Array[Array[Int]]): Long = {
    if (c_lib <= c_road) {
      return c_lib.toLong * n.toLong;
    }
    val citiesZeroIndexed = cities.map(_.map(_ - 1))
    val directedRoads = citiesZeroIndexed.map(c => (c(0), c(1)))
    val roads = directedRoads ++ directedRoads.map(r => (r._2, r._1))
    val roadsMap: MapView[Int, Array[Int]] = roads.groupBy(_._1).view.mapValues(_.map(_._2))
    val visited = new Array[Boolean](n)
    var totalCost: Long = 0L

    for (i <- 0 until n) {
      if (visited(i) == false) {
        val queue: mutable.Queue[Int] = mutable.Queue.empty
        queue.addOne(i)
        visited(i) = true
        totalCost += c_lib
        while (!queue.isEmpty) {
          val city = queue.dequeue()
          val neighbours = roadsMap.get(city).getOrElse(Array.empty)
          neighbours.foreach(c => {
            if (visited(c) == false) {
              visited(c) = true
              totalCost += c_road
              queue.addOne(c)
            }
          }
          )
        }
      }
    }
    totalCost
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val q = stdin.readLine.trim.toInt

    for (qItr <- 1 to q) {
      val nmC_libC_road = stdin.readLine.split(" ")

      val n = nmC_libC_road(0).trim.toInt

      val m = nmC_libC_road(1).trim.toInt

      val c_lib = nmC_libC_road(2).trim.toInt

      val c_road = nmC_libC_road(3).trim.toInt

      val cities = Array.ofDim[Int](m, 2)

      for (i <- 0 until m) {
        cities(i) = stdin.readLine.split(" ").map(_.trim.toInt)
      }

      val result = roadsAndLibraries(n, c_lib, c_road, cities)

      printWriter.println(result)
    }

    printWriter.close()
  }
}
