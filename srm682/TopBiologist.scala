object test {	
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