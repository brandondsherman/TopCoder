object test {
	def findShortestNewSequence(sequence: String): String = {
		var found: Option[String] = None
		var i = 0
		for(i <- 0 to sequence.length){
			found = dls("", i, sequence)
			if(found.isDefined) return found.get
		}
		return ""
	}

	def dls(node: String, depth: Int, sequence: String): Option[String] = {
		var found: Option[String] = None
		if(depth == 0 && !sequence.contains(node) && node != ""){
			return Some(node)
		}else if(depth > 0){
			for(c <- "ACGT"){
				found = dls(node + c,depth-1,sequence)
				if(found.isDefined) return found
			}
		} 
		return None
	}
}




