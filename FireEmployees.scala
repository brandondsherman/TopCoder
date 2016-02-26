class FireEmployees(){
	var man: Option[Array[Int]] = None
	var sal: Option[Array[Int]] = None
	var prod: Option[Array[Int]] = None
	val map = scala.collection.mutable.HashMap.empty[Int,Array[Int]]

def fire(manager: Array[Int], salary: Array[Int], productivity: Array[Int]): Int = {
	man match{
		case None => man = Some(manager)
		case Some(s) => println("This shouldn't have happened")
	}
	sal match{
		case None => sal = Some(salary)
		case Some(s) => println("This shouldn't have happened")
	}
	prod match{
		case None => prod = Some(productivity)
		case Some(s) => println("This shouldn't have happened")
	}
	
	
	val lastEmp = man.get.length-1
	val lastEmpKey = man.get.last
	val lastEmpProfits = prod.get(lastEmp) - sal.get(lastEmp)
	val lastEmpManager = man.get(lastEmp)
	var lastEmpManagerProfits = 0
	if(lastEmpManager != 0){
		lastEmpManagerProfits = prod.get(lastEmpManager-1) - sal.get(lastEmpManager-1)
	}

	map +=(lastEmpKey -> Array(lastEmpProfits))
	map +=(lastEmpManager -> Array(lastEmpManagerProfits + lastEmpProfits, lastEmpKey))
	
	fireRest(lastEmp-1)

	var total = 0
	for ((key,value) <- map) {
		total = total + value(0)
	}
	return total
}

def fireRest(i: Int): Unit = {
	if(i != 0){
		val iProfits = prod.get(i-1) - sal.get(i-1)
		val manager = man.get(i-1)
		if(manager != 0){
			val managerProfits = prod.get(manager-1)-sal.get(manager-1)
			val managerInMap = map contains manager
			
			if(!managerInMap){
				map += (manager -> Array(managerProfits))
			}
			val manArr = map(manager)
			manArr(0) = manArr(0) + iProfits
			manArr :+ i
			map += (manager -> manArr)
		} 
		if(map contains i){
			if(map(i)(0) < 0){
				fireEmps(i)
			}
		} else{
			map += ( i -> Array(iProfits))
		}
		fireRest(i-1)
	}
}

def fireEmps(i: Int): Unit ={
	val manager = map(i)
	val employees = manager.slice(1,manager.length-1)
	map -= i
	for(emp <- employees){
		fireEmps(emp)
	}
}


}