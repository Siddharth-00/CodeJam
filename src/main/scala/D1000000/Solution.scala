package D1000000

import scala.io.StdIn.readLine

object Solution {
  def main(args: Array[String]) ={
    val T = readLine().toInt
    for(i <- 0 until T) {
      val N = readLine().toInt
      val S = readLine().split(" ").map(_.toInt).sorted
      var curr = 0
      for(j <- 0 until N) {
        if(S(j) >= (curr + 1)) {
          curr += 1
        }
      }
      println(s"Case #${i + 1}: ${curr}")
    }
  }
}
