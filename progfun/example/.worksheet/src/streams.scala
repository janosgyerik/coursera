object streams {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(60); 
  println("Welcome to the Scala worksheet");$skip(34); 
  
  for (i <- 1 to 3) println(i);$skip(33); 
  
  
  val list = List(3, 4, 5);System.out.println("""list  : List[Int] = """ + $show(list ));$skip(23); 
  val v = Vector(list);System.out.println("""v  : scala.collection.immutable.Vector[List[Int]] = """ + $show(v ));$skip(7); val res$0 = 
  v(1);System.out.println("""res0: List[Int] = """ + $show(res$0))}
  
  
}
