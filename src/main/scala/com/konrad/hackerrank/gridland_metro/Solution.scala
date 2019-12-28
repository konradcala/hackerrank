package com.konrad.hackerrank.gridland_metro

import java.io._

import scala.collection.MapView

object Solution {

  def convertToPair(row: Array[Int]): Tuple2[Int, Tuple2[Int, Int]] = {
    val r = row(0) - 1
    val c1 = row(1) - 1
    val c2 = row(2) - 1
    (r, (c1, c2))
  }

  val compareRanges: ((Int, Int), (Int, Int)) => Boolean = {
    case (a, b) => a._1 < b._1
  }

  def merge(left: (Int, Int), right: (Int, Int)): List[(Int, Int)] = {
    if (left._2 >= right._2) {
      List(left)
    } else if (left._2 < right._1) {
      List(left, right)
    } else {
      List((left._1, right._2))
    }
  }

  // Complete the gridlandMetro function below.
  def gridlandMetro(n: Int, m: Int, k: Int, track: Array[Array[Int]]): Long = {
    val trackMap: Predef.Map[Int, Array[(Int, (Int, Int))]] = track.map(convertToPair).groupBy(_._1)
    val trackView: MapView[Int, Array[(Int, Int)]] = trackMap.view.mapValues(arr => arr.map(_._2))
    val sortedMap: MapView[Int, Array[(Int, Int)]] = trackView.view.mapValues(arr => arr.sortWith(compareRanges))
    val mergedRanges = sortedMap.mapValues(arr => arr.foldLeft(List[Tuple2[Int, Int]]())((acc: List[Tuple2[Int, Int]], pair: Tuple2[Int, Int]) => acc match {
      case Nil => pair :: Nil
      case x :: xs => merge(x, pair) ++ xs
    }))
    val numberOfTracks = mergedRanges
      .mapValues(ranges => ranges.foldLeft(0)((acc, pair) => acc + pair._2 - pair._1 + 1))
      .values.foldLeft(0L)(_ + _)

    n.toLong * m.toLong - numberOfTracks
  }

  def main(args: Array[String]) {
    val stdin = scala.io.StdIn

    val printWriter = new PrintWriter(sys.env("OUTPUT_PATH"))

    val nmk = stdin.readLine.split(" ")

    val n = nmk(0).trim.toInt

    val m = nmk(1).trim.toInt

    val k = nmk(2).trim.toInt

    val track = Array.ofDim[Int](k, 3)

    for (i <- 0 until k) {
      track(i) = stdin.readLine.split(" ").map(_.trim.toInt)
    }

    val result = gridlandMetro(n, m, k, track)

    printWriter.println(result)

    printWriter.close()
  }
}
