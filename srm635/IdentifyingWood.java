package srm635;

public class IdentifyingWood {

	public static void main(String[] args){
		IdentifyingWood x = new IdentifyingWood();
		System.out.println(x.check("absdefgh","asdfg"));
		System.out.println(x.check("oxoxoxox","ooxxoo"));
		System.out.println(x.check("oxoxoxox","xxx"));
		System.out.println(x.check("qwerty","qwerty"));
		System.out.println(x.check("string","longstring"));
	}
	
	public String check(String s, String t){
		if(s.length() < t.length()){
			return "Nope.";
		}
		
		int index = 0;
		for(int i = 0; i < s.length() && index < t.length();i++){
			char sChar = s.charAt(i);
			char tChar = t.charAt(index);
			if(sChar==tChar){
				index++;
			}
		}
		
		if(index == t.length()){
			return "Yep, it's wood.";
		} else return "Nope.";
		
		
		
		
		
	}
}
