package recfun

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class PascalSuite extends FunSuite {
  import Main.pascal
  test("pascal: col=0,row=2") {
    assert(pascal(0,2) === 1)
  }

  test("pascal: col=1,row=2") {
    assert(pascal(1,2) === 2)
  }

  test("pascal: col=1,row=3") {
    assert(pascal(1,3) === 3)
  }

  test("pascal 0 0") {
    assert(pascal(0,0) === 1)
  }

  test("pascal 1 5") {
    assert(pascal(1,5) === 5)
  }

  test("pascal 2 5") {
    assert(pascal(2,5) === 10)
  }

  test("pascal 3 6") {
    assert(pascal(2,6) === 15)
  }

  test("pascal -1 0") {
    intercept[IllegalArgumentException] {
      pascal(-1, 0)
    }
  }
  
  test("pascal 0 -1") {
    intercept[IllegalArgumentException] {
      pascal(0, -1)
    }
  }
  
  test("pascal -1 -1") {
    intercept[IllegalArgumentException] {
      pascal(-1, -1)
    }
  }
  
  test("pascal -1 -2") {
    intercept[IllegalArgumentException] {
      pascal(-1, -2)
    }
  }
  
  test("pascal -2 -1") {
    intercept[IllegalArgumentException] {
      pascal(-2, -1)
    }
  }
  
  test("pascal 6 5") {
    intercept[IllegalArgumentException] {
      pascal(6, 5)
    }
  }
}
