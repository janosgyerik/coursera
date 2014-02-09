package week3objsets

abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

object Empty extends IntSet {
  def incl(x: Int) = new NonEmpty(x, Empty, Empty)
  def contains(x: Int) = false
  def union(other: IntSet) = other
  override def toString = "." 
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet {
  
  def this(elem: Int) = this(elem, Empty, Empty)
  
  def incl(x: Int): IntSet = {
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  }
  
  def contains(x: Int): Boolean = {
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  }
  
  override def toString = "{" + left.toString + elem + right.toString + "}"
  
  override def equals(r: Any) = {
    if (r.isInstanceOf[NonEmpty]) {
      r.asInstanceOf[NonEmpty].toString == toString
    }
    else false
  }
  
  def union(other: IntSet) = 
    ((left union right) union other) incl elem
}