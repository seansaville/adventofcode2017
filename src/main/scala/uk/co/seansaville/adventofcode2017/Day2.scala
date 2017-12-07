package uk.co.seansaville.adventofcode2017

import scala.io.Source

object Day2 {
  def checkSum1(rows: List[Array[Int]]): Int = rows.map(row => row.max - row.min).sum

  def checkSum2(rows: List[Array[Int]]): Int = {
    val rowCombs = rows.map(row => row.combinations(2))

    val divisors = for {
      pairs <- rowCombs
      p <- pairs
      if p.max % p.min == 0
    } yield p.max / p.min

    divisors.sum
  }

  def main(args: Array[String]): Unit = {
    val fileBuffer = Source.fromFile("./src/main/resources/day2.input")
    val rows = fileBuffer.getLines.toList.map(_.split("\\s+").map(_.toInt))
    println(checkSum1(rows))
    println(checkSum2(rows))
    fileBuffer.close
  }
}
