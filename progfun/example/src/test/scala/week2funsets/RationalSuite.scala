package week2funsets

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class RationalSuite extends FunSuite {

  test("1/2 + 1/3") {
    val x = new Rational(1, 2)
    val y = new Rational(1, 3)
    assert(x + y === new Rational(5, 6))
  }

  test("1/3 + 5/7") {
    val x = new Rational(1, 3)
    val y = new Rational(5, 7)
    assert(x + y === new Rational(22, 21))
  }

  test("1/2 * 1/3") {
    val x = new Rational(1, 2)
    val y = new Rational(1, 3)
    assert(x * y === new Rational(1, 6))
  }

  test("(1/3 + 5/7) * 3/2") {
    val x = new Rational(1, 3)
    val y = new Rational(5, 7)
    val z = new Rational(3, 2)
    assert((x + y) * z === new Rational(66, 42))
  }

  test("1/3 - 5/7") {
    val x = new Rational(1, 3)
    val y = new Rational(5, 7)
    assert(x - y === new Rational(-8, 21))
  }
  
  test("1/3 - 5/7 - 3/2") {
    val x = new Rational(1, 3)
    val y = new Rational(5, 7)
    val z = new Rational(3, 2)
    assert(x - y - z === new Rational(-79, 42))
  }

  test("neg 1/3") {
    val x = new Rational(1, 3)
    val y = new Rational(5, 7)
    val z = new Rational(3, 2)
    assert(-x === new Rational(-1, 3))
  }

  test("canonical negatives") {
    assert(new Rational(1, -3).numer === -1)
  }

}
