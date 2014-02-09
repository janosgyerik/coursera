package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CountChangeSuite extends FunSuite {
  import Main.countChange
  test("countChange: no pennies") {
    assert(countChange(301,List(5,10,20,50,100,200,500)) === 0)
  }

  test("countChange: example given in instructions") {
    assert(countChange(4,List(1,2)) === 3)
  }

  test("countChange: 4 with 1 2") {
    assert(countChange(4,List(1,2)) === 3)
  }

  test("countChange: sorted CHF") {
    assert(countChange(300,List(5,10,20,50,100,200,500)) === 1022)
  }

  test("countChange: 300 with   5 10 20 50 100 200 500 = 1022") {
    assert(countChange(300,List(5,10,20,50,100,200,500)) === 1022)
  }

  test("countChange: unsorted CHF") {
    assert(countChange(300,List(500,5,50,100,20,200,10)) === 1022)
  }

  test("countChange: 300 with   500 5 50 100 20 200 10 = 1022") {
    assert(countChange(300,List(500,5,50,100,20,200,10)) === 1022)
  }
  
  test("countChange: 6 with 1 2 3") {
    assert(countChange(6,List(1,2, 3)) === 7)
    // 1 1 1 1 1 1
    // 1 1 1 1 2
    // 1 1 2 2
    // 2 2 2
    // 1 1 1 3
    // 1 2 3
    // 3 3
    //
    // 6 | 2
    // 3 | 3
    // 1
    // = 2 2 2
    // = 3 3
    // = 1 1 1 1 1 1
    // 1 1 2 2
    // 1 1 1 1 2 
    // 1 1 1 3
    // 1 2 3
    
    // # of ways to write n - x
    
    // -1 -1 -1 -1 -1 -1 = 0
    // -2 -1 -1 -1 -1 = 0
    // -2 -2 -1 -1 = 0
    // -2 -2 -2 = 0
    // -3 -1 -1 -1 = 0
    // -3 -2 -1 = 0
    // -3 -3 = 0
    
    // 6 => 3 1 2
    // -3 -3 = 0
    // -3 -1 -1 -1 = 0
    // -3 -1 -2 = 0
    // -1 -1 -1 -1 -1 -1 = 0
    // -1 -1 -1 -1 -2 = 0
    // -1 -1 -2 -2 = 0
    // -2 -2 -2 = 0
    
    // 6 => 2 3 1
    // -2 -2 -2 = 0
    // -2 -3 -1 = 0
    // -2 -2 -1 -1 = 0
    // -2 -1 -1 -1 -1 = 0
    // -3 -3 = 0
    // -3 -1 -1 -1 = 0
    // -1 -1 -1 -1 -1 -1 = 0

    // 6 => 1 2 3
    // -1 -1 -1 -1 -1 -1
    // -1 -1 -1 -1 -2 = 0
    // -1 -1 -1 -3 = 0
    // -1 -1 -2 -2 = 0
    // -1 -2 -3 = 0
    // -2 -2 -2 = 0
    // -3 -3 = 0
    
    // x* y* z*
    
    // 4 => 1 2
    // -1 -1 -1 -1 = 0
    // -1 -1 -1 -2 x
    // -1 -1 -2 = 0
    // -2 -2 = 0
    // -1 * 4
    // -1 * 2 -2
    // -2 * 2
    
    // 6 => 1 2 3
    // -1 * 6 -2 * 0 -3 * 0
    // -1 * 4 -2 * 1 -3 * 0
    // -1 * 3 -2 * 0 -3 * 1
    // -1 * 2 -2 * 2 -3 * 0
    // -1 * 1 -2 * 1 -3 * 1
    // -1 * 0 -2 * 3 -3 * 0
    // -1 * 0 -2 * 0 -3 * 2
}

  test("countChange: 7 with 1 2") {
    assert(countChange(7,List(1,2)) === 4)
    // 1 1 1 1 1 1 1
    // 1 1 1 1 1 2
    // 1 1 1 2 2
    // 1 2 2 2
  }

  test("countChange: 6 with 1 2") {
    assert(countChange(6,List(1,2)) === 4)
    // 1 1 1 1 1 1
    // 1 1 1 1 2
    // 1 1 2 2
    // 2 2 2
  }

  test("countChange: 2 with 1 2") {
    assert(countChange(2,List(1,2)) === 2)
  }

  test("countChange: 3 with 1 2") {
    assert(countChange(3,List(1,2)) === 2)
  }

  test("countChange: 4 with 1") {
    assert(countChange(4,List(1)) === 1)
  }

  test("countChange: 4 with 2") {
    assert(countChange(4,List(2)) === 1)
  }

  test("countChange: 4 with 3") {
    assert(countChange(4,List(3)) === 0)
  }

  test("countChange: 4 with 4") {
    assert(countChange(4,List(4)) === 1)
    assert(countChange(4,List(4, 5)) === 1)
  }

  test("countChange: 4 with 5") {
    assert(countChange(4,List(5)) === 0)
    assert(countChange(4,List(5, 6)) === 0)
  }
}
