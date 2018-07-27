object intsets {
  println("welcome")
  val t1 = new NonEmpty(3, Empty, Empty)
  val t2 = t1 incl 4
  val t3 = new NonEmpty(5, Empty, Empty)
  val t4 = t1 union t3

  abstract class IntSet {
    def contains(x: Int): Boolean
    def incl(x: Int): IntSet
    def union(other: IntSet): IntSet
  }

  object Empty extends IntSet {
    override def contains(x: Int) = false
    override def incl(x: Int) = new NonEmpty(x, Empty, Empty)
    override def toString: String = "."
    override def union(other: IntSet) = other
  }

  class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
    override def contains(x: Int) =
      if (x < elem) left.contains(x)
      else if (x > elem) right.contains(x)
      else true

    override def incl(x: Int) =
      if(x < elem) new NonEmpty(elem, left.incl(x), right)
      else if (x > elem) new NonEmpty(elem, left, right.incl(x))
      else this

    override def toString: String = "{" + left + elem + right + "}"

    override def union(other: IntSet) =
      ((left union right) union other) incl elem
  }
}

