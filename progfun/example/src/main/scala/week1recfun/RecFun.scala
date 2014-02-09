package week1recfun

import common._
import scala.annotation.tailrec

object RecFun {
  
  @tailrec
  def gcd(a: Int, b: Int): Int = {
    if (b == 0) a else gcd(b, a % b)
  }
  
  def factorial1(n: Int): Int = {
    if (n < 2) 1 else n * factorial1(n - 1)
  }
  
  def factorial2(n: Int): Int = {
    @tailrec
    def factorial(n: Int, acc: Int): Int = {
      if (n < 2) acc else factorial(n - 1, n * acc)
    }
    factorial(n, 1)
  }
  
  def factorial(n: Int) = factorial2(n)
}
