package recfun
import common._
import scala.annotation.tailrec

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
  def pascal(c: Int, r: Int): Int = {
    if (c < 0 || r < 0 || c > r) throw new IllegalArgumentException("invalid args: " + c + " " + r)
    if (c == 0) 1
    else if (c == r) 1
    else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    @tailrec
    def balance(chars: List[Char], opencnt: Int): Boolean = {
      if (chars.isEmpty) opencnt == 0
      else if (chars.head == '(') balance(chars.tail, opencnt + 1)
      else if (chars.head == ')') opencnt > 0 && balance(chars.tail, opencnt - 1)
      else balance(chars.tail, opencnt)
    }
    balance(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (coins.isEmpty) 0
    else if (money < 0) 0
    else countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
}
