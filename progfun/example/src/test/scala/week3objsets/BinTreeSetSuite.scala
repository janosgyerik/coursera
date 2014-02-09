package week3objsets

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class BinTreeSetSuite extends FunSuite {

  trait TestSets {
    val e = Empty
    val s3 = new NonEmpty(3)
    val s3x = new NonEmpty(3)
    val s4 = new NonEmpty(4)
    val s34 = s3 incl 4
    val s43 = s4 incl 3
    val s345 = s34 incl 5
  }

  new TestSets {
    test("empty union empty") {
      assert((e union e) === Empty)
    }

    test("empty union other") {
      assert((e union s3) === s3)
    }
    
    test("other union empty") {
      assert((s3 union e) === s3)
    }
    
    test("s3 union s3") {
      assert((s3 union s3) === s3)
    }

    test("s3 === s3x") {
      assert(s3 === s3x)
    }
    
    test("s3 union s34") {
      assert((s3 union s34) === s34)
    }
    
    test("s3 union s345") {
      assert((s3 union s345) === s345)
    }
    
    test("s34 union s43") {
      //assert((s34 union s43) === s34)
      assert((s34 union s43) contains 3)
      assert((s34 union s43) contains 4)
    }
    
    test("s43 union s34") {
      //assert((s34 union s43) === s34)
      assert((s34 union s43) contains 3)
      assert((s34 union s43) contains 4)
    }
    
    test("s3 union s4") {
      //assert((s3 union s4) === s34)
      assert((s3 union s4) contains 3)
      assert((s3 union s4) contains 4)
      assert(!((s3 union s4) contains 5))
    }
    
    test("s4 union s3") {
      assert((s4 union s3) === s34)
    }
    
    test("s4 union s345") {
      assert((s4 union s345) === s345)
    }
  }
}
