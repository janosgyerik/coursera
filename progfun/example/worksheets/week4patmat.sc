object week4patmat {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  trait List[T] {
  	def head: T
  	def tail: List[T]
  	def isEmpty: Boolean
  }
  class Cons[T](val head: T, val tail: List[T]) extends List[T] {
    def isEmpty = false
    override def toString() = head + "::" + tail.toString
  }
  class Nil[T] extends List[T] {
  	def head = throw new NoSuchElementException("Nil.head was called")
  	def tail = throw new NoSuchElementException("Nil.tail was called")
  	def isEmpty = true
  	override def toString() = "Nil"
  }
  object List {
    def apply[T](): List[T] = new Nil[T]
  	def apply[T](a: T): List[T] = new Cons(a, new Nil)
  	def apply[T](a: T, b: T): List[T] = new Cons(a, new Cons(b, new Nil))
  }
  List()                                          //> res0: week4patmat.List[Nothing] = Nil
  List(3)                                         //> res1: week4patmat.List[Int] = 3::Nil
  List(1, 2)                                      //> res2: week4patmat.List[Int] = 1::2::Nil
  1 :: 2 :: Nil                                   //> res3: List[Int] = List(1, 2)
  scala.List(1) ::: scala.List(2)                 //> res4: List[Int] = List(1, 2)
}