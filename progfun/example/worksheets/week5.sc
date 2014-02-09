package patmat

object week5 {
	println("hello")                          //> hello

	type Occurrences = List[(Char, Int)]

/*
	List(1, 2, 3) ++ List(4)
	Nil ++ List(4)
	*/
		
	/*
	val m = List(('a', 1), ('b', 2)).toMap
  m.getOrElse('b', 0)
	m.getOrElse('c', 0)
	*/

/*
	val occ1 = List(('a', 2), ('b', 2), ('c', 1))
	val occ2 = List(('b', 1))

  val occ3 = List(('a', 2), ('b', 2))

	def combinations(xs: Occurrences): List[Occurrences] = {
		def comb(xs: Occurrences): Set[Occurrences] = xs match {
			case Nil => Set(xs)
			case (c, n) :: xs =>
				for {
					combo <- comb(xs)
					i <- 0 to n
				} yield (c, i) :: combo filter{ case (_, n) => n > 0 }
		}
    comb(xs).toList
	}
	combinations(occ3)
  */
/*
	val occ3 = List(1, 2, 3)  // -> List(1), List(2), List(3), List(1, 2), List(1, 3), List(2, 3), List(1, 2, 3)
	
	def comb(xs: List[Int]): Set[List[Int]] = {
		if (xs.length == 0) Set(xs)
		else if (xs.length == 1) Set(List(), xs)
		//else if (xs.length == 2) Set(List(), List(xs.head), List(xs.tail.head), xs)
		else
			for {
				list <- comb(xs.tail)
				x <- List(0, xs.head)
			} yield x :: list
	}
	for { x <- comb(occ3) } yield x.filter(_ > 0)
  */
	/*
	  def placeQueens(k: Int): Set[List[Int]] = {
			if (k == 0) Set(List())
			else
				for {
					queens <- placeQueens(k - 1)
					col <- 0 until n
					if isSafe(col, queens)
				} yield col :: queens
		}
	*/
		
/*
	def subtract(x: Occurrences, y: Occurrences): Occurrences = {
		for {
			(c1, n1) <- x
			(c2, n2) <- y
			if c1 != c2 || (c1 == c2 && n1 != n2)
		} yield if (c1 == c2) (c1, n1 - n2) else (c1, n1)
	}.toList
	subtract(occ1, occ2)
	subtract(occ1, List())
	subtract(occ1, List(('a', 2)))
	subtract(occ1, List(('b', 2)))
	*/
		
/*
	val occ = List(('a', 2), ('b', 2), ('c', 1))
	def comb2(xs: Occurrences): List[Occurrences] = {
		val ys = xs.toSet
		for {
			(c1, n1) <- ys
			(c2, n2) <- ys
			if c1 != c2
			i1 <- 0 to n1
			i2 <- 0 to n2
		} yield List((c1, i1), (c2, i2)).filter(x => x._2 != 0).sorted }.toList
	comb2(occ)
	comb2(Nil)
	List(1, Nil, 2).filter(_ != Nil)
	
	for {
		(c, n) <- occ
		i <- 1 to n
	} yield (c, i)
	
	List(List(3)) ::: List(List())
	
	val n = 3
	for { i <- 1 to n } yield List(i)
	def comb(xs: List[Int]): List[List[Int]] = for {
		x <- xs
		i <- 1 to x
	} yield List(x)
	comb(List(1, 2, 3))
    */
	
/*
	val books = (1 to 5).toSet
	for {
		b1 <- books
		b2 <- books
		if b1 != b2
	} yield b1
*/

/*
	def queens(n: Int) = {
		def isSafe(col: Int, queens: List[Int]) = queens match {
			case Nil => true
			case x :: xs => !(queens contains col) && Math.abs(col - x) > 1
		}
		
		def placeQueens(k: Int): Set[List[Int]] = {
			if (k == 0) Set(List())
			else
				for {
					queens <- placeQueens(k - 1)
					col <- 0 until n
					if isSafe(col, queens)
				} yield col :: queens
		}
		placeQueens(n)
	}
	queens(0)
	queens(3)
	queens(4)
*/

	/*
	val occ = List(('a', 3), ('b', 2))
	
	type Occurrences = List[(Char, Int)]
	
	def decompose(list: Occurrences) =
		list map{ case (c, n) => (1 to n) map (_ => (c, 1)) } flatten
         
  def recompose(list: Occurrences) =
  	list.groupBy(_._1).map{ case (x, y) => (x, y.length) }.toList
  
  def combinations(occurrences: Occurrences): List[Occurrences] =
  	occurrences.toSet[(Char, Int)].subsets.map(_.toList).toList
  	
  def combinations2(occurrences: Occurrences): List[Occurrences] =
  	decompose(occurrences).toSet[(Char, Int)].subsets.map(_.toList).toList

	val v1 = (1 to 3)
	val v2 = (2 to 4)
	(v1 zip v2) map { case (x, y) => x * y }
	(v1 zip v2) map(x => x._1 * x._2)
	//(v1 zip v2) map((x, y) => x * y)
	for { x <- v1; y <- v2 } yield x * y
  for { (x, y) <- (v1 zip v2) } yield x * y

  for { (c, n) <- occ } yield (1 to n) flatMap (x => (1 to x))
  
  def combinations3(occurrences: Occurrences): List[Occurrences] = ???
	//combinations3(occ)
  
  (1 to 2) flatMap (i => List(('a', i)))
  
  (1 to 2) flatMap (x => (1 to 3) map (y => (x, y)))
	*/
	
	/*
  def isPrime(n: Int) =
    (2 to n/2) forall(x => n % x != 0)

  def findPrimePairs(n: Int) =
    (1 until n) map (i =>
      (1 until i) map (j => (i, j)) filter (pair => isPrime(pair._1 + pair._2))) flatten
      
  println(findPrimePairs(7))
  */
  
	/*
  def isPrime(n: Int) =
    (2 to n/2) forall(x => n % x != 0)
  
  def findPrimePairs(n: Int) =
    (1 until n-1) map (j => (j+1 until n) map (i => (i, j)) filter (pair => isPrime(pair._1 + pair._2))) flatten
    
  println(findPrimePairs(7))
*/
/*
	def mapFun[T, U](xs: List[T], f: T => U): List[U] =
		(xs foldRight List[U]())((x, xs) => f(x) :: xs)

	mapFun[Int, Int](List(1, 2, 3), x => x * x)
	
	def lengthFun[T](xs: List[T]): Int =
		(xs foldRight 0)((_, y) => 1 + y)
		
	lengthFun(List(1, 2, 3))
	lengthFun(List(1, 2, 3, 4))
	lengthFun(List(1, 2, 3, 5, 6))
	*/
	
/*
  def concat[T](xs: List[T], ys: List[T]): List[T] =
  	(xs foldRight ys)(_ :: _)
  	
  concat(List(1, 2, 3), List(4, 5, 6))
  
  def reverse[T](xs: List[T]) =
  	(xs foldLeft List[T]())((xs, x) => x :: xs)
  	
  reverse(List(1, 2, 3))
  */
  	
/*
	def pack[T](xs: List[T]): List[List[T]] = xs match {
		case Nil => Nil
		case x :: xs1 => {
			val (start, rest) = xs1 span (y => y == x)
			List(x :: start) ::: pack(rest)
		}
	}
	pack(List(1, 1, 1, 2, 3, 3, 1))

	def encode[T](xs: List[T]) =
		pack(xs) map (xs => (xs.head, xs.length))
	encode(List("a", "a", "a", "b", "c", "c", "a"))
  */
	
/*
  def squareList(xs: List[Int]): List[Int] = xs match {
  	case Nil => Nil
  	case x :: xs => x * x :: squareList(xs)
  }
  squareList(List(1, 2, 3))
  
  def squareList2(xs: List[Int]): List[Int] =
  	xs map(x => x * x)
  	
  squareList2(List(1, 2, 3))
  */
  
/*
	def msort(xs: List[Int]): List[Int] = {
	  val n = xs.length / 2
	  if (n == 0) xs
	  else {
			def merge(xs: List[Int], ys: List[Int]): List[Int] = (xs, ys) match {
				case (_, Nil) => xs
			  case (Nil, _) => ys
				case (x :: xs2, y :: ys2) =>
				  if (x < y) x :: merge(xs2, ys)
					else y :: merge(xs, ys2)
			}
			val (first, second) = xs splitAt n
			merge(msort(first), msort(second))
	  }
	}
	msort(List(1, 2, 3))
	msort(List(3, 1, 2, 3))
	msort(List(3, 2, 1))
	msort(List(1, 2, 3, 4, 5, 6))
	msort(List(1, 2, 3, 4, 5, 6, 7))
	*/
	
	/*
	def flatten(xs: List[Any]): List[Any] = xs match {
	  case Nil => Nil
	  case x :: xs => x match {
     case x: List[Any] => flatten(x) ++ flatten(xs)
     case x => x :: flatten(xs)
	  }
	}
	flatten(List(List(1, 1), 2, List(3, List(5, 8))))
*/
/*
	def removeAt[T](xs: List[T], n: Int): List[T] = xs match {
		case x :: xs =>
			if (n == 0) xs
			else x :: removeAt(xs, n - 1)
	}
	
	removeAt(List(1, 2, 3, 4), 1)
	
	def removeAt2[T](xs: List[T], n: Int): List[T] = (xs take n) ::: (xs drop n + 1)
	
	removeAt2(List(1, 2, 3, 4), 1)
*/

/*
	def reverse[T](xs: List[T]): List[T] = xs match {
		case Nil => Nil
		case x :: xs => reverse(xs) ::: List(x)
	}
	
	reverse(List(1, 2, 3))
	*/
	
/*
  List(1, 2, 3) ::: List(4, 5)
  List(1, 2, 3) ++ List(4, 5)
  
  1 :: 2 :: Nil
  List(1, 2) :: Nil
  
  def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
    case Nil => ys
    case x :: xs => x :: concat(xs, ys)
  }
  
  concat(List(1, 2, 3), List(4, 5))
  */
    
/*
  def init[T](xs: List[T]): List[T] = xs match {
    case Nil => throw new Error("init of empty list")
    case List(x) => Nil
    case y :: ys => y :: init(ys)
  }
  init(List(1,2,3,4))
  init(List(1,2))
  init(List(1))
  */
}