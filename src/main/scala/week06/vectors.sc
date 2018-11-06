val v1 = Vector(1,2,3)

2 +: v1
v1 :+ 6

v1 map (_*2)
v1 exists (_==2)

1 to 10
1 until 10

val v2 = "Hello"

v1 zip v2

v2 flatMap (c => List('.', c))

v1.sum
v1.product
v1.max
v1.min

(1 to 4) flatMap (m => (2 to 4) map (n => (m, n)))

List((1,2),(2,3),(3,4)) map (t => t._1 + t._2)
List((1,2),(2,3),(3,4)) map {case (x, y) => x+y}


List(List(1,2),List(3,4),List(List(5),6)).flatten
