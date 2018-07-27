object overrides {

  abstract class Base {
    def foo = 1

    def bar: Int
  }

  class Sub extends Base {
    override def foo = 2

    def bar = 3
  }

  class Square(_x: Int, _y: Int) {
    val x = _x
    val y = _y
  }

  val s = new Square(10, 20)
  s.x
  s.y

  trait Shape {
    def area: Int
  }

  class Triangle extends Base with Shape {
    override def area = 2

    override def bar = 10
  }

  val f1 = println("f1 printed")
  def f2 = println("f2 printed")
  f1
  f2

}