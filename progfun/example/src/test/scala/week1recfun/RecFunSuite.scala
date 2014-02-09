package week1recfun

import scala.annotation.tailrec

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

import week1recfun.RecFun.factorial
import week1recfun.RecFun.gcd

@RunWith(classOf[JUnitRunner])
class RecFunSuite extends FunSuite {
  
  test("gcd") {
    assert(gcd(14, 21) === 7)
    assert(gcd(21, 14) === 7)
    assert(gcd(12, 9) === 3)
    assert(gcd(11, 7) === 1)
    assert(gcd(1023, 2047) === 1)
    assert(gcd(1023, 1024) === 1)
    assert(gcd(1024, 1026) === 2)
  }
  
  test("factorial") {
    assert(factorial(0) === 1)
    assert(factorial(1) === 1)
    assert(factorial(2) === 2)
    assert(factorial(3) === 6)
    assert(factorial(4) === 24)
  }
}
