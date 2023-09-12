/*
 * Given a array of N strings, find the longest common prefix among all strings 
 * present in the array.


	Example 1:
	
	Input:
	N = 4
	arr[] = {geeksforgeeks, geeks, geek,
	         geezer}
	Output: gee
	Explanation: "gee" is the longest common
	prefix in all the given strings.
	Example 2:
	
	Input: 
	N = 2
	arr[] = {hello, world}
	Output: -1
	Explanation: There's no common prefix
	in the given strings.
	
	Your Task:
	You don't need to read input or print anything. Your task is to complete the 
	function longestCommonPrefix() which takes the string array arr[] and its size 
	N as inputs and returns the longest common prefix common in all the strings in 
	the array. If there's no prefix common in all the strings, return "-1".
	
	
	Expected Time Complexity: O(N*max(|arri|)).
	Expected Auxiliary Space: O(max(|arri|)) for result.
	
	
	Constraints:
	1 ≤ N ≤ 103
	1 ≤ |arri| ≤ 103
 */
package arrays;

public class LongestPrefix {
	String longestCommonPrefixBest(String arr[], int n){
        if(n==0){
            return "-1";
        }
        if(n==1){
            return arr[0];
        }
        int smallLength = arr[0].length();
        String small = arr[0];
        
        for(int i=1; i<n; i++){
            if(smallLength > arr[i].length()){
                smallLength = arr[i].length();
                small = arr[i];
            }
        }
        int count = 0;
        boolean flag = true;
        for(int i=0; i<smallLength; i++){
            for(int j=0; j<n; j++){
                if(arr[j].charAt(i)!=small.charAt(i)){
                    flag = false;
                    break;
                }
            }
            if(flag == false){
                break;
            }
            count++;
        }
        if(count ==0){
            return "-1";
        }
        return small.substring(0, count);
    }
	
	String longestCommonPrefix(String arr[], int n){
		if(n==0){
			return "";
		}
		if(n==1){
			return arr[0];
		}
		String s = arr[0];
		String t = arr[1];
		String ans = checkPrefix(s, t);
		if(ans == ""){
			return "-1";
		}
		for(int i=2; i<n; i++){
			ans = checkPrefix(ans, arr[i]);
		}
		return ans;
	}
	public String checkPrefix(String s, String t){
		int smallLength = 0;
		if(s.length() < t.length()){
			smallLength = s.length();
		}else{
			smallLength = t.length();
		}
		String ans ="";
		for(int i=0; i<smallLength; i++){
			if(s.charAt(i)==t.charAt(i)){
				ans += s.charAt(i); 
			}else{
				break;
			}
		}
		return ans;
	}
}
