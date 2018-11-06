def squareList1(xs: List[Int]): List[Int] =
  xs match {
    case Nil => List()
    case y :: ys => y * y :: squareList1(ys)
  }

squareList1(List(1, 2, 3))

def squareList2(xs: List[Int]): List[Int] =
  xs map (x => x * x)

squareList2(List(1, 2, 3))

List(1,2,3,4,5) map (x => x*x)
List(1,2,3,4,5) filter (x => x < 4)
List(1,2,3,4,5) filterNot (x => x < 4)
List(1,2,3,4,5) partition (x => x < 4)
List(1,2,3,4,5) takeWhile (x => x != 4)
List(1,2,3,4,5) dropWhile (x => x != 4)
List(1,2,3,4,5) span (x => x != 4)

def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: xs1 => List(xs takeWhile(y => y==x)) ::: pack(xs dropWhile(y => y==x))
}

pack(List("a", "a", "a", "b", "c", "c", "a"))
// List(List("a", "a", "a"), List("b"), List("c", "c"), List("a"))


def encode[T](xs: List[T]): List[(T, Int)] =
  pack(xs) map (ys => (ys.head, ys.length))

encode(List("a", "a", "a", "b", "c", "c", "a"))
//List(("a", 3), ("b", 1), ("c", 2), ("a", 1))