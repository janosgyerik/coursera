object week4patmat {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(64); 
  println("Welcome to the Scala worksheet")
  
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
  };$skip(668); val res$0 = 
  List();System.out.println("""res0: week4patmat.List[Nothing] = """ + $show(res$0));$skip(10); val res$1 = 
  List(3);System.out.println("""res1: week4patmat.List[Int] = """ + $show(res$1));$skip(13); val res$2 = 
  List(1, 2);System.out.println("""res2: week4patmat.List[Int] = """ + $show(res$2));$skip(16); val res$3 = 
  1 :: 2 :: Nil;System.out.println("""res3: List[Int] = """ + $show(res$3));$skip(34); val res$4 = 
  scala.List(1) ::: scala.List(2);System.out.println("""res4: List[Int] = """ + $show(res$4))}
}
