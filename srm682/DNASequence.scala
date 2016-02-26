object test {
	def longestDNASequence(sequence: String): Int = {
		var max = 0
		var currentLength = 0
		for(c <- sequence){
			if(Array('A','C','G','T').contains(c)){
				currentLength = currentLength + 1
			} else{
				if(max < currentLength){
					max = currentLength
				}
					currentLength = 0
			}
		}
		return(max)
	}

	def findShortestNewSequence(sequence: String): Option[String] ={
		var found: Option[String] = None
		for(depth <- 0 to sequence.length+1){
			found = DLS("",depth, sequence)
			if(found.isDefined) return found
		}
		return None

	}

	def DLS(node : String, depth : Int, sequence : String): Option[String] ={
		var found: Option[String] = None
		if(depth == 0 && !sequence.contains(node) && node != ""){
			return Some(node)
		}else if(depth > 0){
			for(c <- "ACTG"){
				found = DLS(node + c,depth-1,sequence)
				if(found.isDefined)return found
			}	
		}
		return None
	}

}