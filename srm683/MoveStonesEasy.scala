object stones {
	/*def getFunctionalWay(a : Array[Int], b : Array[Int]): Int ={
		def fixStack(index : Int): Int ={

		}

		a.foldLeft((0,))((r,c) => 
			(r + fixStack(c._2),r._2+1)
	}*/

	def get(a : Array[Int], b : Array[Int]): Int = {
		var count = 0
		if(b.sum == a.sum){
			for(i <- 0 to a.length-1){
				if(a(i) == b(i)){
					//do nothing
				}else{
					var addTo = a(i) - b(i)
					count = count + (addTo.abs)
					a(i) = b(i)
					a(i+1) = a(i+1)+addTo
				}
			}
		} else{
			count = -1
		}
		return count
	}
}