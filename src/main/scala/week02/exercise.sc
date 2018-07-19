object exercise {

  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 0 else f(a) + product(f)(a + 1, b)
  }

  sum(x => x * x)(3, 4)

  def product(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) 1 else f(a) * product(f)(a + 1, b)
  }

  product((x: Int) => x * x)(3, 4)

  def fact(n: Int): Int = product(x => x)(1, n)

  fact(5)

  // sum and product generic function
  def generic(f: (Int => Int) => (Int, Int) => Int)(f1: Int => Int, a: Int, b: Int): Int = {
    f(f1)(a, b)
  }

  generic(sum)(x => x * x, 3, 4)
  generic(product)(x => x * x, 3, 4)

  def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int = {
    if (a > b) zero else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
  }

  mapReduce(x => x * x, (a, b) => a + b, 0)(3, 4)
  mapReduce(x => x * x, (a, b) => a * b, 1)(3, 4)

  def f1(f: Int => Int)(x: Int): Int = {
    println("In f1 " + x)
    val i = f(x + 1) + 1
    println("In f1 ret " + i)
    i
  }

  def f2(f: Int => Int)(x: Int): Int = {
    println("In f2 " + x)
    val i = f(x) + 1
    println("In f2 ret " + i)
    i
  }

  f1(f2(x => x * 2))(3)

}