package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }
  
  ignore("createCodeTree") {
    assert(List("a") === createCodeTree("aaaaaaaabbbcdefgh".toList))
    /*
     * Fork(
     * 	Leaf(a,8),
     *  Fork(
     *  	Fork(
     *   		Fork(
     *     			Leaf(g,1),
     *        		Leaf(h,1),
     *          	List(g, h), 2),
 *           	Fork(
 *            		Leaf(e,1),
 *              	Leaf(f,1),
 *               	List(e, f), 2),
 *              List(g, h, e, f), 4),
 *          Fork(
 *          	Fork(
 *           		Leaf(c,1),
 *             		Leaf(d,1),
 *               	List(c, d), 2),
 *              Leaf(b,3), List(c, d, b),5),
 *          List(g, h, e, f, c, d, b), 9),
 *      List(a, g, h, e, f, c, d, b),17)
     */
  }
  
  test("decode 11101100") {
    val tree = createCodeTree("aaaaaaaabbbcdefgh".toList)
    assert(decode(tree, List(1, 1, 1, 0, 1, 1, 0, 0)) === "bac".toList)
  }
  
  test("decoded secret") {
    assert(decodedSecret === "huffmanestcool".toList)
  }
  
  test("decode and encode bac using aaaaaaaabbbcdefgh") {
    val tree = createCodeTree("aaaaaaaabbbcdefgh".toList)
    assert(encode(tree)("bac".toList) === List(1, 1, 1, 0, 1, 1, 0, 0))
    assert(decode(tree, encode(tree)("bac".toList)) === "bac".toList)
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }
  
  test("decode and encode a very short text using quickEncode") {
    new TestTrees {
      assert(decode(t1, quickEncode(t1)("ab".toList)) === "ab".toList)
    }
  }
  
  test("decode and encode a longer text using quickEncode") {
    val tree = createCodeTree("decode and encode a longer text using quickEncode".toList)
    assert(decode(tree, quickEncode(tree)("decode".toList)) === "decode".toList)
  }
}
