### Tail recursion

> If a function calls itself as its last action,
> the function's stack frame can be reused.
> This is called *tail recursion*.

Tail recursive functions are iterative processes.

In general, if the last action of a function consists of calling a function (which may be the same),
one stack frame would be sufficient for both functions.
Such calls are called tail-calls.


### Higher order functions

Functional languages treat functions as first-class values.
This means that, like any other value,
a function can be passed as a parameter and returned as a result.
This provides a flexible way to compose programs.
Functions that take other functions as parameters or that return functions as results are called *higher order functions*.


### Currying

Consider this function that returns another function:
```scala
def sum(f: Int => Int): (Int, Int) => Int = {
  def sumF(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sumF(a + 1, b)
  sumF
}
```

Scala has a special syntax to write the equivalent:
```scala
def sum(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 0 else f(a) + sum(f)(a + 1, b)
```

And the type of `sum` is `(Int => Int) => ((Int, Int) => Int)`

Since functional types associate to the right,
the above is equivalent to: `(Int => Int) => (Int, Int) => Int`


### The fixed point of a function

A number `x` is called a fixed point of a function `f` if `f(x) = x`


### Summary on abstraction

Functions are essential abstractions because they allow us to introduce
general methods to perform computations as explicit and named elements in
our programming language.

These abstractions can be combined with higher-order functions to create
new abstractions.

As a programmer, one must look for opportunities to abstract and reuse.

The highest level of abstraction is not always the best, but it is
important to know the techniques of abstraction, so as to use them when
appropriate.


### Context-free syntax in Extended Backus-Naur form (EBNF)

```
| denotes an alternative
[...] an option (0 or 1)
{...} a repetition (0 or more)
```


### Dynamic method dispatch

The code invoked by a method call depends on the runtime type of the object
that contains the method.


### Types and evaluation

Type parameters do not affect evaluation in Scala.

We can assume that all type parameters and type arguments are removed
before evaluating the program.

This is called *type erasure*.

Languages that use type erasure include Java, Scala, Haskell, ML.

Some other languages keep the type parameters around at run time,
these include C++, C#, F#.


### Polymorphism

Polymorphism means that a function type comes "in many forms".

In programming it means that:

- the function can be applied to arguments of many types, or
- the type can have instances of many types

Two principal forms of polymorphism:

- subtyping: instances of a subclass can be passed to a base class
- generics: instances of a function or class are created by type
  parameterization


### The Liskov Substitution Principle

A type can be a subtype of another if:

> If A <: B, then everything one can do with a value of type B,
> one should also be able to do with a value of type A.

Originally:

> Let q(x) be a property provable about objects x of type B.
> Then q(y) should be provable for objects y of type A where A <: B
