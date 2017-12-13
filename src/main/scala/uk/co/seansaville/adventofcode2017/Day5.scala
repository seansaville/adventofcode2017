package uk.co.seansaville.adventofcode2017

import scala.io.Source

object Day5 {
  def evaluateInstruction1(instructions: Array[Int], index: Int): Int = {
    val current = instructions(index)
    instructions(index) += 1
    index + current
  }

  def evaluateInstruction2(instructions: Array[Int], index: Int): Int = {
    val current = instructions(index)
    instructions(index) += (if (current < 3) 1 else -1)
    index + current
  }

  def main(args: Array[String]): Unit = {
    val fileBuffer = Source.fromFile("./src/main/resources/day5.input")
    val instructions1 = fileBuffer.getLines.map(_.toInt).toArray
    val instructions2 = instructions1.clone()

    var nextIndex = 0
    var steps = 0
    while (nextIndex >= 0 && nextIndex < instructions1.length) {
      nextIndex = evaluateInstruction1(instructions1, nextIndex)
      steps += 1
    }
    println(steps)

    nextIndex = 0
    steps = 0
    while (nextIndex >= 0 && nextIndex < instructions2.length) {
      nextIndex = evaluateInstruction2(instructions2, nextIndex)
      steps += 1
    }
    println(steps)

    fileBuffer.close()
  }
}
