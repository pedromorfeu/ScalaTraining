import patmat.Huffman.times

val map1 = Map(1 -> "a", 2 -> "b") withDefaultValue "unknown"

map1(2)

val maybeString1 = map1 get 2
maybeString1.get
maybeString1.foreach(v => println(v + "aa"))

val maybeString2 = map1 get 10
maybeString2.isEmpty
maybeString2.isDefined

map1 get 2 match {
  case Some(x) => x
  case None => "none"
}

map1(10)
map1 get 10

val fruits = List("apple", "orange", "pear", "banana")
fruits.sorted
fruits sortWith(_.length < _.length)

fruits groupBy (_.head)

fruits groupBy (_.length)

List(("a",1),("b",2),("c",3)).toMap
Map("a"->1, "b"->2, "c"->3).toList

val l = List(("a",1),("b",2),("c",3))

val list = "abca".groupBy(t => t).toList
val tuples = for ((c,n) <- list) yield (c, n.length)
tuples.sorted

"Robert".toLowerCase.groupBy(t => t).toList.sortBy(t => t._1)
