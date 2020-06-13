object Sorts{
	def main(args: Array[String])={
		println(mergesort(List(4, 7, 3, 8, 5, 5, 3, 32, 8, 653)))
	}
	def quicksort(list: List[Int]): List[Int]={
		if(list.length<=1){
			list
		}else{
			val pivot=list(list.length/2)
			val half1=quicksort(list filter (_<pivot))
			val pivots=list filter (_==pivot)
			val half2=quicksort(list filter (_>pivot))
			half1 ::: pivots ::: half2
		}
	}

	def mergesort(list: List[Int]): List[Int]={
		if(list.length<=1){
			list
		}else{
			def merge(list1: List[Int], list2: List[Int]): List[Int]={
				(list1, list2) match {
					case (Nil, list2) => list2
					case (list1, Nil) => list1
					case (list1, list2) => 
						if(list1(0)<list2(0)) 
							list1(0) :: merge(list1.drop(1), list2)
						else
							list2(0) :: merge(list1, list2.drop(1))
				}
			}
			val split=list splitAt list.length/2
			val half1=mergesort(split._1)
			val half2=mergesort(split._2)
			merge(half1, half2)
		}
	}
}