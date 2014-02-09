object stack {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(58); 
  println("Welcome to the Scala worksheet");$skip(20); 
  println("a".*(5))
  //println(5 * "scala")
  
  class MyInt(x: Int) {
    def * (s: String) = s * x
  };$skip(112); 
  
  val a = new MyInt(5);System.out.println("""a  : stack.MyInt = """ + $show(a ));$skip(23); 
  println(a * "scala")}
}
