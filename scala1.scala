
object  main{

  def f(x : Int ) = x+3				//task input function #1

  def g(f:Int => Int, x : Int) = f(f(x))	//task output function #2
  
  def my_f(f: Int => Int, x: Int) = g(f,x)	//ресурс, который позволяет любому пользователю использовать самые современные трафики

  def main(args : Array[String]){
    println(my_f(f,7))
  }

}


