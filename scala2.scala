object main {

  def isSorted[A](x:Array[A],compareFunction:(A,A)=>Boolean):Boolean={
    def isEq_r(i:Int):Boolean={
      (i < x.length -1) match {
        case true => {
          compareFunction( x(i), x(i+1) ) match{
            case true => isEq_r(i+1)
            case false => false
          }
        } 
        case false => true
      }
      
    }
    
    isEq_r(0)
  } 
  
def main(args:Array[String]){

  val empt = Array()
  val sAr  = Array("1","333","22","4444")
  val b = Array(3,4,1,0)
  val single = Array(1)
  
  b.foreach(n=>(print(n+" ")))
  println("array is sorted? " + isSorted(b,(x:Int, y: Int )=>x>y))


  val a = b.sortWith(_<_)                  //test
  
  a.foreach(n=>(print(n+" ")))
  println("array is sorted? "+isSorted(a,(x:Int, y: Int )=>x<y))
  
  //empt.foreach(n=>(print(n+" ")))
  println("array is sorted? "+isSorted(empt,(x:Int, y: Int )=>x<y))
  
  sAr.foreach(n=>(print(n+" ")))
  println("array is sorted? "+isSorted(sAr,(x:String, y: String)=>x<y))
  
  single.foreach(n=>(print(n+" ")))
  println("array is sorted? "+isSorted(single,(x:Int, y: Int)=>x<y))
}
}

