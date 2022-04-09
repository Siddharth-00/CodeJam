package Printing3D

import scala.io.StdIn.readLine

object Solution {
  def main(args: Array[String]) = {
    val T = readLine().toInt
    for(i <- 0 until T) {
      val P1 = readLine().split(" ").map(_.toInt)
      val P2 = readLine().split(" ").map(_.toInt)
      val P3 = readLine().split(" ").map(_.toInt)
      val c = P1(0) min P2(0) min P3(0)
      val m = P1(1) min P2(1) min P3(1)
      val y = P1(2) min P2(2) min P3(2)
      val k = P1(3) min P2(3) min P3(3)
      if((c + m + y + k) < 1000000) {
        println(s"Case #${i + 1}: IMPOSSIBLE")
      }
      else {
        val available = Array(c,m,y,k)
        val currColour = Array(0,0,0,0)
        for(i <- 0 until 4) {
          val currTotal = currColour.sum
          if(currTotal < 1000000) {
            currColour(i) += (1000000 - currTotal) min available(i)
          }
        }
        println(s"Case #${i + 1}: ${currColour.mkString(" ")}")
      }
    }
  }
}
