package week1recfun

object Sqrt {
  
  /* TODO
   * http://codereview.stackexchange.com/questions/31628/how-to-write-better-an-sqrt-square-root-function-in-scala
   * - how to make sqrt(1e-3) === Math.sqrt ? 
   * - more logical way to determine threshold
   * - is there a better way than divide by 2?
   */
  def sqrt1(x: Double): Double = {
    if (x < 0) throw new IllegalArgumentException("negative numbers not allowed")
    val threshold = if (x < 1) x / 1e15 else 1e-12
    def sqrt(p: Double): Double = {
      if (p == x / p) p  // without this condition, non-termination with 1e50
      else if (Math.abs(p * p - x) < threshold) {
        def diff1 = Math.abs(x - p * p)
        def diff2 = Math.abs(x - x / p * x / p)
        if (diff1 < diff2) p else x / p
      }
      else sqrt((p + x / p) / 2)
    }
    sqrt(x / 2)
  }
  
  def sqrt2(x: Double): Double = {
    if (x < 0) throw new IllegalArgumentException("negative numbers not allowed")
    val threshold = if (x < 1) x / 1e15 else 1e-12
    
    def isGoodEnough(p: Double) = {
      if (p == x / p) true  // without this condition, non-termination with 1e50
      else if (Math.abs(p * p - x) < threshold) true
      else false
    }

    def improve(x: Double, p: Double) = {
      (p + x / p) / 2
    }
    
    def betterQuotient(x: Double, p: Double) = {
        def diff1 = Math.abs(x - p * p)
        def diff2 = Math.abs(x - x / p * x / p)
        if (diff1 < diff2) p else x / p      
    }
    
    def sqrtIter(x: Double, p: Double): Double = {
      if (isGoodEnough(p)) betterQuotient(x, p)
      else sqrtIter(x, improve(x, p))
    }
    
    sqrtIter(x, x / 2)
  }
  
  def sqrt(x: Double): Double = sqrt2(x)
}