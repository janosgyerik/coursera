package week2funsets

object Sqrt {
  
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
  
  def sqrt3(x: Double): Double = {
    if (x < 0) throw new IllegalArgumentException("negative numbers not allowed")
    val threshold = if (x < 1) x / 1e15 else 1e-12
    
    def isCloseEnough(x: Double, y: Double) =
      Math.abs((x - y) / x) / x < threshold

    def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2
    
    def fixedPoint(f: Double => Double)(firstGuess: Double) = {
	  def iterate(guess: Double): Double = {
	    val next = f(guess)
		if (isCloseEnough(guess, next)) next
		else iterate(next)
  	  }
	  iterate(firstGuess)
    }
    fixedPoint(averageDamp(y => x / y))(2.0)
  }
  
  def sqrt(x: Double): Double = sqrt3(x)
}