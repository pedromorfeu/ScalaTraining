val pair = (1, "Pedro")

val (key, value) = pair
key
value

(1, "hey", 33)
//[String]("a", "b")
("a", "b")

Tuple2[String, String]("c", "d")

def merge(xs: List[Int], ys: List[Int]): List[Int] =
  (xs, ys) match {
    case (Nil, ys) => ys
    case (xs, Nil) => xs
    case (x :: xs1, y :: ys1) =>
      if (x < y) x :: merge(xs1, ys)
      else y :: merge(xs, ys1)
  }

merge(List(1,3,6), List(2,4))

"a".compareTo("b")