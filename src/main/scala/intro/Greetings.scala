package intro

trait Greetings {
  def sayHello: String
}

trait DefaultGreetings {
  def defaultHello = "Hello"
}

class JapaneseGreetings extends Greetings {
  override def sayHello: String = "Konnichiwa"
}

class GermanGreetings extends Greetings with DefaultGreetings {
  override def sayHello: String = "Guten Tag"
}

object Run extends App {
  override def main(args: Array[String]): Unit = {
    val greetings = new JapaneseGreetings
    println(greetings.sayHello)

    val german = new GermanGreetings()
    println(german.sayHello)
    println(german.defaultHello)

    val j = new JapaneseGreetings with DefaultGreetings
    println(j.sayHello)
    println(j.defaultHello)
  }
}