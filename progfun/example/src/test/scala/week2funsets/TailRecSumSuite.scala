package week2funsets

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

import week2funsets.Product.id
import week2funsets.Product.cube
import week2funsets.TailRecSum.sum

@RunWith(classOf[JUnitRunner])
class TailRecSumSuite extends FunSuite {

  test("sum id 1 0") {
    assert(sum(id)(1, 0) === 0)
  }

  test("sum id 1 1") {
    assert(sum(id)(1, 1) === 1)
  }

  test("sum id 1 2") {
    assert(sum(id)(1, 2) === 3)
  }

  test("sum id 3 5") {
    assert(sum(id)(3, 5) === 12)
  }

  test("sum id 5 3") {
    assert(sum(id)(5, 3) === 0)
  }
  
  test("sum cube 1 0") {
    assert(sum(cube)(1, 0) === 0)
  }

  test("sum cube 1 1") {
    assert(sum(cube)(1, 1) === 1)
  }

  test("sum cube 1 2") {
    assert(sum(cube)(1, 2) === 9)
  }

  test("sum cube 3 5") {
    assert(sum(cube)(3, 5) === 216)
  }

  test("sum cube 5 3") {
    assert(sum(cube)(5, 3) === 0)
  }
  
}
