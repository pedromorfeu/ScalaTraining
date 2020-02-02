package example

import scala.collection.immutable
import scala.collection.immutable.HashSet

object CollectionsBenchmark extends App {

  println("hello")

  val strings = for (i <- 1 to 1000000) yield (i.toString)
  val array: HashSet[String] = immutable.HashSet[String](strings:_*)

  val random = scala.util.Random

  val start: Long = System.currentTimeMillis()

  val res: immutable.IndexedSeq[Boolean] = for (i <- 1 to 1000) yield {
    val n = random.nextInt(1000000)
    array.contains(n.toString)
  }

  println("array: " + res.size)
  println("took " + (System.currentTimeMillis() - start))

}
