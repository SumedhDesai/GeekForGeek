/*
 * Given two unsorted arrays A of size N and B of size M of distinct elements, the task is 
 * to find all pairs from both arrays whose sum is equal to X.

	Note: All pairs should be printed in increasing order of u. For eg. for two pairs (u1,v1) 
	and (u2,v2), if u1 < u2 then
	(u1,v1) should be printed first else second.
	
	Example 1:
	
	Input:
	A[] = {1, 2, 4, 5, 7}
	B[] = {5, 6, 3, 4, 8} 
	X = 9 
	Output: 
	1 8
	4 5 
	5 4
	Explanation:
	(1, 8), (4, 5), (5, 4) are the
	pairs which sum to 9.
	Example 2:
	Input:
	A[] = {-1, -2, 4, -6, 5, 7}
	B[] = {6, 3, 4, 0} 
	X = 8 
	Output:
	4 4 
	5 3
	
	Your Task:  
	You don't need to read input or print anything. Your task is to complete the function 
	allPairs() which takes the array A[], B[], its size N and M respectively, and an integer
	X as inputs and returns the sorted vector pair values of all the pairs u,v where u belongs 
	to array A and v belongs to array B. If no such pair exists return empty vector pair.
 */
package arrays;

import java.util.ArrayList;
import java.util.Arrays;

class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
public class PairSumInTwoArray {

	public pair[] allPairs(long[] A, long[] B, long N, long M, long X) {
		
		Arrays.sort(A);
		Arrays.sort(B);
		ArrayList<pair> ans = new ArrayList<>();

		
		int i = 0;
		int j = B.length-1;

		System.out.println("&&");
		while(i<A.length && j>=0){
			if(A[i]+B[j]>X){
				j--;
			}else if(A[i]+B[j]<X){
				i++;
			}else{		
				pair p = new pair(A[i], B[j]);
				ans.add(p);
				i++;
				j--;
			}
		}

		pair[] arr = new pair[ans.size()];
		for(int k=0; k<ans.size(); k++){
			arr[k]= ans.get(k);
		}
	
		return  arr; 
	}
}

