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

def freq1(chars: List[Char]): List[(Char, Int)] = {
  chars.sorted match {
    case List() => List()
    case c :: cs => freq(cs, c, 1)
  }
}

def freq(chars: List[Char], previous: Char, n: Int): List[(Char, Int)] = chars match {
  case List() => List((previous, n))
  case c :: cs => {
    if (c == previous) {
      freq(cs, c, n+1)
    } else {
      List((previous, n)) ::: freq(cs, c, 1)
    }
  }
}

freq1(List('a','a','b','a'))
freq1(List('a','a','b','a','c','b'))