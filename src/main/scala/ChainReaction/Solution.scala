package ChainReaction

import scala.collection.mutable.ListBuffer
import scala.io.StdIn.readLine
import scala.collection.mutable.Map

object Solution {
  class Module(val num: Int, val fun: BigInt) {
    var inNodes: ListBuffer[Module] = ListBuffer.empty
  }

  def findFun(module: Module): (BigInt, BigInt) = {
    if(module.inNodes.isEmpty) return  (BigInt(0), module.fun)
    val inFun = module.inNodes.map(findFun).zipWithIndex
    val minIndex = inFun.minBy(_._1._2)._2
    val out = inFun.foldLeft((BigInt(0),BigInt(0)))((curr, f) => {
      if(f._2 == minIndex) {
        (curr._1 + f._1._1, f._1._2 max module.fun)
      }
      else {
        (curr._1 + f._1._2 + f._1._1, curr._2)
      }
    })
    out
  }

  def main(args: Array[String]) = {
    val T = readLine().toInt
    for(i <- 0 until T) {
      val N = readLine().toInt
      val moduleMap: Map[Int, Module] = Map.empty
      val F = readLine().split(" ").map(_.toInt)
      moduleMap(0) = new Module(0, 0)
      for(n <- 1 to N) {
        moduleMap(n) = new Module(n, F(n-1))
      }
      val P = readLine().split(" ").map(_.toInt)
      for(j <- 1 to N) {
        moduleMap(P(j-1)).inNodes += moduleMap(j)
      }
      val f = findFun(moduleMap(0))
      println(s"Case #${i + 1}: ${f._1 + f._2}")
    }
  }
}
