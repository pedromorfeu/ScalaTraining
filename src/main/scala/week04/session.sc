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

  val number = Number(1)
  number match {
    case Number(1) => println("one")
    case Number(_) => println("else")
  }

  val char = 'b'
  char match {
    case 'a' => println("one")
    case _ => println("else")
  }

}