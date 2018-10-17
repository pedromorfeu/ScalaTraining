def insert(x: Int, xs: List[Int]): List[Int] = xs match {
  case List() => List(x)
  case y :: ys => if (x <= y) x :: xs else y :: insert(x, ys)
}

insert(1, List())
insert(1, List(2, 3))
insert(1, List(0, 2, 3))

"a" :: "b" :: Nil
List("a") ::: List("b")