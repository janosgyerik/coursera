package week4patmat

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class InsertionSortSuite extends FunSuite {

  trait TestSets {
    val sorter = new InsertionSort
  }
  
  new TestSets {
    test("sort 1 2 3") {
      assert(sorter.isort(List(1, 2, 3)) === List(1, 2, 3))
    }
    test("sort 3 1 2 3") {
      assert(sorter.isort(List(3, 1, 2, 3)) === List(1, 2, 3, 3))
    }
    test("sort 5 4 1 2 3") {
      assert(sorter.isort(List(5, 4, 1, 2, 3)) === List(1, 2, 3, 4, 5))
    }
  }
}