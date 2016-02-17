package week1;

public class ExplodingRobots {
	public String canExplode(int x1, int y1, int x2, int y2, String instructions){
		
		if(x1==x2 && y1==y2){
			return "Explosion";
		}
		
		
		char instruct1 = instructions.charAt(0);
		String bothMove = "";
		String oneIgnores = "";
		String twoIgnores = "";
		String bothIgnore = "";
		if(instructions.length() == 1){
			if(instruct1 == 'U'){
				if((x1==x2 && y1+1 == y2+1) || (x1==x2 && y1==y2+1)|| (x1==x2 && y1+1==y2)){
					return "Explosion";
				}else return "Safe";
			}else if(instruct1=='D'){
				if((x1==x2 && y1-1 == y2-1) || (x1==x2 && y1==y2-1)|| (x1==x2 && y1-1==y2)){
					return "Explosion";
				} else return "Safe";
			}else if(instruct1=='L'){
				if((x1-1==x2-1 && y1 == y2) || (x1==x2-1 && y1==y2)|| (x1-1==x2 && y1==y2)){
					return "Explosion";
				} else return "Safe";
			}else if(instruct1=='R'){
				if((x1+1==x2+1 && y1 == y2) || (x1==x2+1 && y1==y2)|| (x1+1==x2 && y1==y2)){
					return "Explosion";
				} else return "Safe";
			}
		}else
		if(instruct1 == 'U'){
			bothMove = canExplode(x1,y1+1,x2,y2+1,instructions.substring(1));
			oneIgnores = canExplode(x1,y1,x2,y2+1,instructions.substring(1));
			twoIgnores = canExplode(x1,y1+1,x2,y2,instructions.substring(1));
			bothIgnore = canExplode(x1,y1,x2,y2,instructions.substring(1));
		}else if(instruct1=='D'){
			bothMove = canExplode(x1,y1-1,x2,y2-1,instructions.substring(1));
			oneIgnores = canExplode(x1,y1,x2,y2-1,instructions.substring(1));
			twoIgnores = canExplode(x1,y1-1,x2,y2,instructions.substring(1));
			bothIgnore = canExplode(x1,y1,x2,y2,instructions.substring(1));
		}else if(instruct1=='L'){
			bothMove = canExplode(x1-1,y1,x2-1,y2,instructions.substring(1));
			oneIgnores = canExplode(x1,y1,x2-1,y2,instructions.substring(1));
			twoIgnores = canExplode(x1-1,y1,x2,y2,instructions.substring(1));
			bothIgnore = canExplode(x1,y1,x2,y2,instructions.substring(1));
		}else if(instruct1=='R'){
			bothMove = canExplode(x1+1,y1,x2+1,y2,instructions.substring(1));
			oneIgnores = canExplode(x1,y1,x2+1,y2,instructions.substring(1));
			twoIgnores = canExplode(x1+1,y1,x2,y2,instructions.substring(1));
			bothIgnore = canExplode(x1,y1,x2,y2,instructions.substring(1));
		}
		
		
		if(bothMove.equals("Explosion") || oneIgnores.equals("Explosion")||twoIgnores.equals("Explosion")||bothIgnore.equals("Explosion")){
			return "Explosion";
		}
		
		return "";
	}
}
