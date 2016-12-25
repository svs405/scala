object main {

    def isSorted[A](x:Array[A],compareFunction:(A,A)=>Boolean):Boolean={
      
      def localCompare(x:A,y:A):Boolean={
        x==y match {
          case true => true
          case false => false
        }
      }
      
      def isEq(iter:Int):Boolean={
      
        x.length-iter -1 match{
          case 0 => true
          case _ => localCompare(x(iter),x(iter+1)) match{
            case true => isEq(iter+1)
            case false => compareFunction(x(iter),x(iter+1)) match{
                            case true => isEq(iter+1)
                            case false => false
                          }
          }
            
        }
      
      }
    
    x.length match{
      case 0 => true
      case 1 => true
      case _ => isEq(0) 
    
    }
  }
  
def main(args:Array[String]){

  val empt = Array()

  val single = Array(1)
  val arr = Array(3,4,1,0)
  val replays = Array(0,1,1,3,3,4,7,5)
  val sortedR = Array(1,1,1,1,1,1,1,1)
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
  
  replays.foreach(n=>(print(n+" ")))                                  //not sorted with replays      
  println("array is sorted? "+isSorted(replays,(x:Int, y: Int)=>x<y)) 
  
  sortedR.foreach(n=>(print(n+" ")))                                  //sorted with replays
  println("array is sorted? "+isSorted(sortedR,(x:Int, y: Int)=>x<y))
}
}