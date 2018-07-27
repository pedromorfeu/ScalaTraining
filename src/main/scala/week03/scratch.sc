import week03.Rational

object scratch {
  println("hello")

  new Rational(1, 2)

  def error(msg: String) = throw new Error(msg)

//  error("aaa")

  println(null)

  val x = null
  val y: String = x
//  val z: Int = x

  if (true) 1 else false
}