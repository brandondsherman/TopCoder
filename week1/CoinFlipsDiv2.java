package week1;

public class CoinFlipsDiv2 {

	
	public int countCoins(String state){
		int count = 0;
		for(int i=0;i<state.length();i++){
			char curState = state.charAt(i);
			if(curState == state.charAt(i-1) || curState == state.charAt(i+1)){
				count++;
			}
		}
		return count;
	}
}
