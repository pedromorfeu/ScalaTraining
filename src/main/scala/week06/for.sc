case class Person(name: String, age: Int)

val persons = List(Person("e", 10), Person("b", 15), Person("c", 60), Person("a", 5))

for (p <- persons) yield p.name

for (p <- persons if p.age > 10) yield p.name

persons filter (_.age > 10) map (_.name)

for {
  p <- persons
  name = p.name
  age = p.age
  if name.startsWith("b") && age > 10
} yield p.name


def scalarProduct(xs: List[Double], ys: List[Double]): Double =
  (for ((x,y) <- xs zip ys) yield x * y).sum

scalarProduct(List(1,2), List(3,4))