package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int =
    if (c == 0 || c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {

    def balanceExtra(c: Char, chars: List[Char], count: Int): Int = {

      val res = if (c == '(') 1 else if (c == ')') -1 else 0

      if (count < 0) -1
      else if (chars.isEmpty) count + res
      else balanceExtra(chars.head, chars.tail, count + res)

    }

    if (chars.isEmpty) true
    else balanceExtra(chars.head, chars.tail, 0) == 0

  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {

    //    def counter(money: Int, coins: List[Int], count: Int): Int = {
    //      if (money == count) 1
    //      else if (coins.isEmpty) 0
    //
    //      if(counter(money, coins, coins.head)
    //
    //    }
    //
    //    counter(money, coins.tail, coins.head)

    1

  }

  println(countChange(4, List(1, 2)))

}
