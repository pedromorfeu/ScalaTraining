package intro

object Hello extends App {

  val watermelon = 98

  override def main(args: Array[String]) = {
    println(s"hello ${Hello.watermelon}")

    val r = Recipe(100)
    println(r.calories)

    val p = Person("Pedro", 34)
    println(p.name)
  }
}
