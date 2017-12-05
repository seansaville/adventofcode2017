package uk.co.seansaville.adventofcode2017

import scala.io.Source

object Day1 {
  def inverseCaptchaPart1(captcha: List[Int]): Int = {
    def go(list: List[Int], acc: Int): Int = list match {
      case x1 :: x2 :: xs => if (x1 == x2) go(x2 :: xs, acc + x1) else go(x2 :: xs, acc)
      case x :: List()    => if (x == captcha.head) acc + x else acc
      case _              => 0
    }

    go(captcha, 0)
  }

  def inverseCaptchaPart2(captcha: Array[Int]): Int = {
    def go(index: Int, acc: Int): Int = {
      if (index == captcha.length) return acc

      val otherIndex = (index + (captcha.length / 2)) % captcha.length

      if (captcha(index) == captcha(otherIndex))
        go(index + 1, acc + captcha(index))
      else
        go(index + 1, acc)
    }

    go(0, 0)
  }

  def main(args: Array[String]): Unit = {
    val fileBuffer = Source.fromFile("./src/main/resources/day1.input")
    for (line <- fileBuffer.getLines) {
      val captchaList = line.toList.map(_.asDigit)
      val captchaArray = line.toCharArray.map(_.asDigit)
      println(inverseCaptchaPart1(captchaList))
      println(inverseCaptchaPart2(captchaArray))
    }
    fileBuffer.close
  }
}
