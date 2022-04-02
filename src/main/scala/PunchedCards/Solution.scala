package PunchedCards
import scala.io.StdIn.readLine
object Solution {
  def main(args: Array[String]) = {
    val T = readLine().toInt
    for(i <- 0 until T) {
      val RC = readLine().split(" ")
      val R = RC.head.toInt
      val C = RC.last.toInt
      val borderRow = (0 to C * 2).map(j => if(j % 2 == 0) '+' else '-').mkString
      val dotRow = (0 to C * 2).map(j => if(j % 2 == 0) '|' else '.').mkString
      val output = new StringBuilder()
      output.append('.' + borderRow.tail)
      output.append('\n')
      output.append('.' + dotRow.tail)
      output.append('\n')
      for(j <- 2 to R * 2) {
        if(j % 2 == 0) output.append(borderRow)
        else output.append(dotRow)
        output.append('\n')
      }
      println(s"Case #${i + 1}:")
      println(output.toString())
    }
  }

}
