object main {

  def isSorted[A](x:Array[A],compareFunction:(A,A)=>Boolean):Boolean={
    val temp = x.sortWith(compareFunction)
    
    print("not sorted array ")
    x.foreach(n=>(print(n+" ")))
    println()
    
    print("sorted array ") 
    temp.foreach(n=>(print(n+" ")))
    println()
    
    x.sameElements(x.sortWith(compareFunction))				//compare not sorted array with sorted

  } 
  
def main(args:Array[String]){

  val b = Array(3,4,1,0)						//create array for test 
  println("array is sorted? " + isSorted(b,(x:Int, y: Int )=> x > y))	


  val a = b.sortWith(_<_)
  println("array is sorted? "+isSorted(a,(x:Int, y: Int )=> x < y))

  
}
}