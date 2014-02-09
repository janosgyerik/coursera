object stack {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  println("a".*(5))                               //> aaaaa
  //println(5 * "scala")
  
  class MyInt(x: Int) {
    def * (s: String) = s * x
  }
  
  val a = new MyInt(5)                            //> a  : stack.MyInt = stack$$anonfun$main$1$MyInt$1@82a6f16
  println(a * "scala")                            //> scalascalascalascalascala
}