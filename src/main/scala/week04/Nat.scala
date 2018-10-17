package week04

// Peano numbers
abstract class Nat {
  def isZero: Boolean

  def predecessor: Nat

  def successor: Nat = new Succ(this)

  def +(that: Nat): Nat

  def -(that: Nat): Nat
}

object Zero extends Nat {
  def isZero: Boolean = true

  def predecessor = throw new Error("no predecessor for Zero")

  def +(that: Nat): Nat = that

  def -(that: Nat): Nat = if (that.isZero) this else throw new Error("no subtraction allowed for Zero")
}

class Succ(n: Nat) extends Nat {
  def isZero = false

  def predecessor: Nat = n

  //    def +(that: Nat): Nat = {
  //      if (that.isZero) this
  //      else this.+(that.predecessor)
  //    }

  def +(that: Nat): Nat = new Succ(n + that)

  def -(that: Nat): Nat = if (that.isZero) this else n - that.predecessor
}
