package quickcheck

import org.scalacheck.Arbitrary._
import org.scalacheck.Gen._
import org.scalacheck.Prop._
import org.scalacheck._

abstract class QuickCheckHeap extends Properties("Heap") with IntHeap {

  property("min1") = forAll { a: Int =>
    val h = insert(a, empty)
    findMin(h) == a
  }

  property("gen1") = forAll { (h: H) =>
    val m = if (isEmpty(h)) 0 else findMin(h)
    findMin(insert(m, h)) == m
  }

  property("after add x and x + 1 find x") = {
    val m1 = 3
    val m2 = m1 + 1
    findMin(insert(m2, insert(m1, empty))) == m1
  }

  property("after add x + 1 and x find x") = {
    val m1 = 3
    val m2 = m1 + 1
    findMin(insert(m1, insert(m2, empty))) == m1
  }

  property("after add + delete the heap is empty again") = forAll { a: Int =>
    deleteMin(insert(a, empty)) == empty
  }

  property("add + add + delete -> not empty") = forAll { a: Int =>
    deleteMin(insert(a, insert(a, empty))) != empty
  }

  property("add + add + delete + delete -> empty") = forAll { a: Int =>
    deleteMin(deleteMin(insert(a, insert(a, empty)))) == empty
  }

  property("add x -> add x -> add x + 1 -> delete -> delete -> get -> x + 1") = {
    val m1 = 3
    val m2 = m1 + 1
    findMin(deleteMin(deleteMin(insert(m2, insert(m1, insert(m1, empty)))))) == m2
  }

  property("min of melded") = forAll { (h1: H, h2: H) =>
    val m1 = findMin(h1)
    val m2 = findMin(h2)
    findMin(meld(h1, h2)) == m1.min(m2)
  }

  lazy val genHeap: Gen[H] = for {
    a <- arbitrary[A]
    heap <- oneOf(const(empty), genHeap)
  } yield insert(a, heap)

  implicit lazy val arbHeap: Arbitrary[H] = Arbitrary(genHeap)

}
