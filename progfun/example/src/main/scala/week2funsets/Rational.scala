package week2funsets

class Rational(x: Int, y: Int) {
  
  require(y != 0, "denominator must be non-zero")
  
  def this(x: Int) = this(x, 1)
  
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  
  private val g = gcd(x, y)
  
  private val sign = if (x / g * (y / g) > 0) 1 else -1 
  
  val numer = Math.abs(x / g) * sign
  
  val denom = Math.abs(y / g)
  
  def + (r: Rational) =
    new Rational(numer * r.denom + r.numer * denom,
        denom * r.denom)
  
  def - (r: Rational) =
    new Rational(numer * r.denom - r.numer * denom,
        denom * r.denom)
  
  def * (r: Rational) =
    new Rational(numer * r.numer, denom * r.denom)
  
  def unary_- = new Rational(-numer, denom)
  
  def less(that: Rational) =
    numer * that.denom < that.numer * denom

  def max(that: Rational) =
    if (less(that)) that else this
  
  def toDouble = numer / denom
  
  override def toString = numer + "/" + denom
  
  override def equals(r: Any) = {
    if (r.isInstanceOf[Rational]) {
      numer / denom == r.asInstanceOf[Rational].toDouble
    }
    else false
  }
  
}