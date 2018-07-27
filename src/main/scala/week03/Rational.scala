package week03

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
