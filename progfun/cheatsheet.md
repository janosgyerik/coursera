### Class with preconditions

```scala
class Rational(x: Int, y: Int) {
  require(y > 0, ”denominator must be positive”)
  ...
}
```


### Class with auxiliary constructor

```scala
class Rational(x: Int, y: Int) {
  def this(x: Int) = this(x, 1)
  ...
}
```


### Operator precedence

The precedence of an operator is determined by its first character.

The following table lists the characters in increasing order of priority
precedence:

```
(all letters)
|
^
&
< >
= !
:
+ -
* / %
(all other special characters)
```


### Operator definition example

```scala
package idealized.scala
abstract class Boolean {
  def ifThenElse[T](t: => T, e: => T): T

  def && (x: => Boolean): Boolean = ifThenElse(x, false)
  def || (x: => Boolean): Boolean = ifThenElse(true, x)
  def unary_!: Boolean = ifThenElse(false, true)
  def == (x: Boolean): Boolean = ifThenElse(x, x.unary_!)
  def != (x: Boolean): Boolean = ifThenElse(x.unary_!, x)
  def < (x: Boolean): Boolean = ifThenElse(false, x)
}
```


### Class terms

- abstract class
- A extends B = A conforms to the type B
- superclass
- subclass
- base class: direct or indirect superclass


### Singleton object example

```scala
object Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
}
```


### Standalone application example

```scala
object Hello {
  def main(args: Array[String]) = println(”hello world!”)
}
```


### Imports come in several forms

```scala
import week3.Rational	        // imports just Rational
import week3.{Rational, Hello}  // imports both Rational and Hello
import week3._              	// imports everything in package week3
```

The first two forms are called *named imports*,
the last form is called a *wildcard import*.


### Traits

A trait is declared like an abstract class,
just with trait instead of abstract class.

```scala
trait Planar {
  def height: Int
  def width: Int
  def surface = height * width
}
```

Classes, objects and traits can inherit from at most one class but
arbitrary many traits.

Example:

    class Square extends Shape with Planar with Movable ...

Traits resemble interfaces in Java, but are more powerful
because they can contains fields and concrete methods.

On the other hand,
traits cannot have (value) parameters, only classes can.


### Class hierarchy

- Any
    - AnyVal
        - Double
        - Float
        - Long
        - ...
    - AnyRef
        - String
        - List
        - ...


### The Null type

Every reference type also has `null` as a value.

The type of `null` is `Null`.

`Null` is a subtype of every class that inherits from `Object`.
It is incompatible with subtypes of `AnyVal`.


