package week2funsets

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

import week2funsets.Product.product
import week2funsets.Product.id
import week2funsets.Product.cube
import week2funsets.Product.factorial
import week2funsets.Product.sum

@RunWith(classOf[JUnitRunner])
class ProductSuite extends FunSuite {

  test("product id 1 0") {
    assert(product(id, 1, 0) === 0)
  }

  test("product id 1 1") {
    assert(product(id, 1, 1) === 1)
  }

  test("product id 1 2") {
    assert(product(id, 1, 2) === 2)
  }

  test("product id 3 5") {
    assert(product(id, 3, 5) === 60)
  }

  test("product id 5 3") {
    assert(product(id, 5, 3) === 0)
  }
  
  test("product cube 1 0") {
    assert(product(cube, 1, 0) === 0)
  }

  test("product cube 1 1") {
    assert(product(cube, 1, 1) === 1)
  }

  test("product cube 1 2") {
    assert(product(cube, 1, 2) === 8)
  }

  test("product cube 3 5") {
    assert(product(cube, 3, 5) === 216000)
  }

  test("product cube 5 3") {
    assert(product(cube, 5, 3) === 0)
  }
  
  test("fact 0") {
    assert(factorial(0) === 1)
  }

  test("fact 1") {
    assert(factorial(1) === 1)
  }

  test("fact 2") {
    assert(factorial(2) === 2)
  }

  test("fact 3") {
    assert(factorial(3) === 6)
  }

  test("fact 10") {
    assert(factorial(10) === 3628800)
  }

  test("sum id 1 0") {
    assert(sum(id, 1, 0) === 0)
  }

  test("sum id 1 1") {
    assert(sum(id, 1, 1) === 1)
  }

  test("sum id 1 2") {
    assert(sum(id, 1, 2) === 3)
  }

  test("sum id 3 5") {
    assert(sum(id, 3, 5) === 12)
  }

  test("sum id 5 3") {
    assert(sum(id, 5, 3) === 0)
  }
  
  test("sum cube 1 0") {
    assert(sum(cube, 1, 0) === 0)
  }

  test("sum cube 1 1") {
    assert(sum(cube, 1, 1) === 1)
  }

  test("sum cube 1 2") {
    assert(sum(cube, 1, 2) === 9)
  }

  test("sum cube 3 5") {
    assert(sum(cube, 3, 5) === 216)
  }

  test("sum cube 5 3") {
    assert(sum(cube, 5, 3) === 0)
  }
  
}
