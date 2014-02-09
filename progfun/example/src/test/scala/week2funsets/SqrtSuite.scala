package week2funsets

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

import week2funsets.Sqrt.sqrt

@RunWith(classOf[JUnitRunner])
class SqrtSuite extends FunSuite {

  test("sqrt 2") {
    assert(sqrt(2) === Math.sqrt(2))
  }

  test("sqrt 1e-3") {
    assert(Math.abs(1e-3 - sqrt(1e-3) * sqrt(1e-3)) ===
      Math.abs(1e-3 - Math.sqrt(1e-3) * Math.sqrt(1e-3)))
  }

  test("sqrt 1e-20") {
    assert(sqrt(1e-20) === Math.sqrt(1e-20))
  }

  test("sqrt 1e-21") {
    assert(sqrt(1e-21) === Math.sqrt(1e-21))
  }

  test("sqrt 1e20") {
    assert(sqrt(1e20) === Math.sqrt(1e20))
  }

  test("sqrt 1e50") {
    assert(sqrt(1e50) === Math.sqrt(1e50))
  }
}
