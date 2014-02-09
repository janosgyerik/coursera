package week2funsets

object Product {

  def product1(f: Int => Int, a: Int, b: Int): Int = {
    if (a > b) 0
    else if (a == b) f(a)
    else f(a) * product1(f, a + 1, b)
  }
  
  def sum1(f: Int => Int, a: Int, b: Int): Int = {
    if (a > b) 0
    else if (a == b) f(a)
    else f(a) + sum1(f, a + 1, b)
  }
  
  def accum(op: (Int, Int) => Int, f: Int => Int, a: Int, b: Int): Int = {
    if (a > b) 0
    else if (a == b) f(a)
    else op(f(a), accum(op, f, a + 1, b))
  }
  
  def sum(f: Int => Int, a: Int, b: Int): Int =
    accum((a, b) => a + b, f, a, b)
  
  def product(f: Int => Int, a: Int, b: Int): Int =
    accum((a, b) => a * b, f, a, b)
  
  def id(x: Int): Int = x
  
  def cube(x: Int): Int = x * x * x

  def factorial1(x: Int): Int = {
    if (x < 2) 1
    else x * factorial1(x - 1)
  }
  
  def factorial2(x: Int): Int = {
    if (x < 2) 1
    else product(id, 1, x)
  }
  
  def factorial(x: Int): Int = factorial2(x)
}