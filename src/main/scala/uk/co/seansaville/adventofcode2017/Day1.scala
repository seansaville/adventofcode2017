package uk.co.seansaville.adventofcode2017

import scala.io.Source

object Day1 {
  def inverseCaptcha1(captcha: Seq[Int]): Int = {
    (captcha :+ captcha.head).sliding(2).filter(_.distinct.size == 1).map(_.head).sum
  }

  def inverseCaptcha2(captcha: Seq[Int]): Int = {
    val matchingDigits = for {
      (digit, index) <- captcha.zipWithIndex
      offset = (index + (captcha.length / 2)) % captcha.length
      if digit == captcha(offset)
    } yield digit

    matchingDigits.sum
  }

  def main(args: Array[String]): Unit = {
    val fileBuffer = Source.fromFile("./src/main/resources/day1.input")
    for (line <- fileBuffer.getLines) {
      val captcha = line.toSeq.map(_.asDigit)
      println(inverseCaptcha1(captcha))
      println(inverseCaptcha2(captcha))
    }
    fileBuffer.close
  }
}
