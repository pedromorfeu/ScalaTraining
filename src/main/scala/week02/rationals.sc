object rationals {
  val x = new Rational(1, 3)
  val y = new Rational(5, 7)
  val z = new Rational(3, 2)

  x.add(y)
  x.neg
  x.sub(y).sub(z)
  y.add(y)
  x.less(y)
  x.max(y)

  new Rational(2).numer

//  val strange = new Rational(1, 0)
//  strange.add(strange)

  x.add(y)
  x add y
  x.+(y)
  x + y

  class Rational(x: Int, y: Int) {

    require(y != 0, "denominator must be nonzero")

    def this(x: Int) = this(x, 1)

    private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

    private val g: Int = gcd(x, y)

    val numer = x

    val denom = y

    def less(that: Rational) = numer * that.denom < that.numer * denom

    def max(that: Rational) = if (this.less(that)) that else this

    def +(that: Rational): Rational = add(that)

    def add(that: Rational): Rational = {
      new Rational(
        this.numer * that.denom + this.denom * that.numer,
        this.denom * that.denom)
    }

    def neg: Rational = new Rational(-numer, denom)

    def sub(that: Rational): Rational = add(that.neg)

    override def toString: String = (numer / g) + "/" + (denom / g)
  }

}


