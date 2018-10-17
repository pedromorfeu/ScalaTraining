import week04._

object exprs {
  def show(e: Expr): String = e match {
    case Number(n) => n.toString
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
  }


  show(Number(1))
  show(Sum(Number(1), Number(2)))
  show(Sum(Number(1), Sum(Number(2), Number(3))))
  show(Sum(Sum(Number(1), Number(2)), Number(3)))
}