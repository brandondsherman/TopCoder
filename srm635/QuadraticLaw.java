package srm635;

public class QuadraticLaw {

	public static void main(String[] args){
		QuadraticLaw t = new QuadraticLaw();

		System.out.println(t.getTime(1));
		System.out.println(t.getTime(2));
		System.out.println(t.getTime(5));
		System.out.println(t.getTime(6));
		System.out.println(t.getTime(7));
		System.out.println(t.getTime(1482));
	}
	public long getTime(long d){
		
		long a;
		
		a = (long) (-1 + Math.sqrt(1+4*d))/2;
		
		
		return a;
	}
}
