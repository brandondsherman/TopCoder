object test { 
	
	def get(s : String): Int = {
		var count = 0
		val n = s.length();

		for(i <- 0 to (n-2)){
			//println("i = " + i)
			for(j <- (i+1) to (n-1)){
				//println("j = " + j)
				for(k <- j to (n-1)){
					//println("k = " + k)
					for(l <- (k+1) to n){
						//println("l = " + l)
						if(s.substring(i, j).equals(s.substring(k,l))){
							count = count + 1
						}
					}
				}
			}
		}
		return count
	}


}