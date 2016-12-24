object main {

  def isSorted[A](x:Array[A],compareFunction:(A,A)=>Boolean):Boolean={
    def isEq_r(i:Int):Boolean={
     x.length-i match {
        case 0 => true
        case 1 => true
        case _ => {
          if (compareFunction(x(i),x(i+1)) ) isEq_r(i+1)
          else false
        }
       
      }
    }
    
    isEq_r(0)
  } 
  
def main(args:Array[String]){

  val empt = Array()
  val single = Array(1)
  val arr = Array(3,4,1,0)
  
  val strAr  = Array("a","ccc","bb","dddd")
  val sortStrArr = strAr.sortWith(_>_)
 
  
  //tests
  //empt.foreach(n=>(print(n+" ")))
  println("array is sorted? "+isSorted(empt,(x:Int, y: Int )=>x<y))   //empty array, true
                                                                      
  single.foreach(n=>(print(n+" ")))
  println("array is sorted? "+isSorted(single,(x:Int, y: Int)=>x<y))  //1 element in array, true
  
  arr.foreach(n=>(print(n+" ")))
  println("array is sorted? " + isSorted(arr,(x:Int, y: Int )=>x<y))   //not sorted array, false

  val sortArr = arr.sortWith(_<_)
  sortArr.foreach(n=>(print(n+" ")))                                   //sorted array
  println("array is sorted? "+isSorted(sortArr,(x:Int, y: Int )=>x<y)) //a<b, true
  
  val sortArrB = arr.sortWith(_>_)
  sortArrB.foreach(n=>(print(n+" ")))                                   //sorted array
  println("array is sorted? "+isSorted(sortArrB,(x:Int, y: Int )=>x>y)) //a>b, true
  
  strAr.foreach(n=>(print(n+" ")))                                        //string not sorted array
  println("array is sorted? "+isSorted(strAr,(x:String, y: String)=>x<y)) //false
  
  sortStrArr.foreach(n=>(print(n+" ")))                                        //sorted string array
  println("array is sorted? "+isSorted(sortStrArr,(x:String, y: String)=>x>y)) //true
}
}