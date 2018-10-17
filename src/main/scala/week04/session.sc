object session {
  def func(x: => Boolean): Boolean = {
    if (x) return true else false
  }

  func(1 == 1)
  func("a" == "a")
  func("b" == 1)

  println(List().isEmpty)
  println(List(1).head)
  println(List(1, 2).head)
  println(List(1, 2).tail.head)

  case class Number(n: Int)

  Number(1).n
}