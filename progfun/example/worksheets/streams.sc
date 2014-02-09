object streams {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  for (i <- 1 to 3) println(i)                    //> 1
                                                  //| 2
                                                  //| 3
  
  
  val list = List(3, 4, 5)                        //> list  : List[Int] = List(3, 4, 5)
  val v = Vector(list)                            //> v  : scala.collection.immutable.Vector[List[Int]] = Vector(List(3, 4, 5))
  v(1)                                            //> java.lang.IndexOutOfBoundsException: 1
                                                  //| 	at scala.collection.immutable.Vector.checkRangeConvert(Vector.scala:137)
                                                  //| 
                                                  //| 	at scala.collection.immutable.Vector.apply(Vector.scala:127)
                                                  //| 	at streams$$anonfun$main$1.apply$mcV$sp(streams.scala:9)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at streams$.main(streams.scala:1)
                                                  //| 	at streams.main(streams.scala)
  
  
}