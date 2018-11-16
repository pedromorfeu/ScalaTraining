List(1,2,3)
List(1,2,3).length
List(1,2,3).tail.length
List(1,2,3).last
List(1,2,3).init
List(1,2,3) take 2
List(1,2,3) drop 1
List(1,2,3) apply 2
List(1,2,3)(2)
List(1).init

List(1,2,3) ++ List(4,5,6)
List(1,2,3) ::: List(4,5,6)
List(1,2,3) :: List(4,5,6)
List(1,2,3) updated (1, 4)
List(1,2,3) indexOf 2
List(1,2,3).reverse
List(1,2,3) contains 3

def init[T](xs: List[T]): List[T] = xs match {
  case List() => throw new Error("init of empty list")
  case List(x) => List()
  case y :: ys => y :: init(ys)
}
init(List(1))
init(List(1,2,3))

def reverse[T](xs: List[T]): List[T] = xs match {
  case List() => xs
  case y :: ys => reverse(ys) ++ List(y)
}
reverse(List(1,2,3))

def removeAt[T](n: Int, xs: List[T]): List[T] = xs match {
  case List() => xs
  case y :: ys => if(n == 0) removeAt(n-1, ys) else List(y) ++ removeAt(n-1, ys)
}
removeAt(1, List('a', 'b', 'c', 'd')) // List(a, c, d)

def flatten(xs: List[Any]): List[Any] = xs match {
  case List() => List()
  case x :: xs1 => x match {
    case x1 :: xx1 => flatten(x1 :: xx1) ::: flatten(xs1)
    case z => z :: flatten(xs1)
  }
}
flatten(List(List(1, 1), 2, List(3, List(5, 8))))

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