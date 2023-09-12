/*
* 	Given the total number of persons n and a number k which indicates that k-1 persons 
*	are skipped and kth person is killed in circle in a fixed direction.
	After each operation, the count will start from k+1th person. The task is to choose 
	the safe place in the circle so that when you perform these operations starting from 
	1st place in the circle, you are the last one remaining and survive.
	
	Example 1:
	
	Input:
	n = 3 k = 2
	Output: 3
	Explanation: There are 3 persons so 
	skipping 1 person i.e 1st person 2nd 
	person will be killed. Thus the safe 
	position is 3.
	 
	
	Example 2:
	
	Input:
	n = 5 k = 3
	Output: 4
	Explanation: There are 5 persons so 
	skipping 2 person i.e 3rd person will 
	be killed. Thus the safe position is 4.
 */
package rec;

import java.util.ArrayList;

public class KillInCricle {
	 public int josephus(int n, int k)
	    {
	        ArrayList<Integer> arr = new ArrayList<>();
	        
	        for(int i=1; i<=n; i++){
	            arr.add(i);
	        }
	        
	        solve(n, k, arr, 0);
	        return arr.get(0);
	    }
	    
	    public void solve(int n, int k, ArrayList<Integer> arr,int index){
	        if(arr.size() == 1){
	            return;
	        }
	        index = ((index + k -1)% arr.size());
	        
	    // -1 is for array start form index 0 and we stored 1 in index 0 
	    
	        arr.remove(index);
	        solve(n, k, arr, index);
	    }
}
