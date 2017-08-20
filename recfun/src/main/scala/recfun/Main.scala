package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
    println("balance: " + balance("Hello".toList))
    println("countChange: " + countChange(3, List(1,2)))
  }

  /**
   * Exercise 1
   */

  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else pascal(c-1, r-1) + pascal(c, r-1)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {

    def balanceIter(acc: Int, chars: List[Char]): Boolean = {
      if (chars.isEmpty) acc == 0
      else {
        val c = chars.head
        val newAcc = if (c == '(') acc + 1 else if (c == ')') acc - 1 else acc
        if (newAcc < 0) false
        else balanceIter(newAcc, chars.tail)
      }
    }

    balanceIter(0, chars)
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    if(money == 0)
      1
    else if(money > 0 && !coins.isEmpty)
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
    else
      0
  }

  }
