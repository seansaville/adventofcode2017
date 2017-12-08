package uk.co.seansaville.adventofcode2017

import scala.io.Source

object Day4 {
  def checkValid(passPhrase: String): Boolean = {
    val split = passPhrase.split(" ")
    split.distinct.length == split.length
  }

  def checkValidWithAnagrams(passPhrase: String): Boolean = {
    val split = passPhrase.split(" ").map(_.sorted)
    split.distinct.length == split.length
  }

  def main(args: Array[String]): Unit = {
    val fileBuffer = Source.fromFile("./src/main/resources/day4.input")
    val passPhrases = fileBuffer.getLines().toList
    println(passPhrases.count(checkValid))
    println(passPhrases.count(checkValidWithAnagrams))
    fileBuffer.close
  }
}
