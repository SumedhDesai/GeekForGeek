/*
 * Given a string S. The task is to print all unique permutations of the given string in 
 * lexicographically sorted order.

	Example 1:

	Input: ABC
	Output:
	ABC ACB BAC BCA CAB CBA
	Explanation:
	Given string ABC has permutations in 6 
	forms as ABC, ACB, BAC, BCA, CAB and CBA .
	Example 2:
	
	Input: ABSG
	Output:
	ABGS ABSG AGBS AGSB ASBG ASGB BAGS 
	BASG BGAS BGSA BSAG BSGA GABS GASB 
	GBAS GBSA GSAB GSBA SABG SAGB SBAG 
	SBGA SGAB SGBA
	Explanation:
	Given string ABSG has 24 permutations.
	Your Task:  
	You don't need to read input or print anything. Your task is to complete the function find_permutaion()
	 which takes the string S as input parameter and returns a vector of string in lexicographical order.
	
	Expected Time Complexity: O(n! * n)
	Expected Space Complexity: O(n! * n)
 */

package rec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class LexicographicalPermutationOfString {

	public List<String> find_permutation(String S) {
		if(S.length() == 0){
			return null;
		}

		ArrayList<String> ans = permuHelper(S, "");
		Collections.sort( ans );

		ArrayList<String> result = new ArrayList<>();
		HashMap<String, Boolean> map = new HashMap<>();

		for(int i=0; i<ans.size(); i++){
			String elem = ans.get(i);
			if(!map.containsKey(elem)){
				result.add(elem);
				map.put(elem, true);
			}
		}
		return result;
	}

	public ArrayList<String> permuHelper(String str, String output){
		if(str.length()==0){
			ArrayList<String> result = new ArrayList<String>();
			result.add(output);
			return result;
		}
		ArrayList<String> result = new ArrayList<>();
		for(int i=0; i<str.length(); i++){
			ArrayList<String> smallAns = permuHelper(str.substring(0,i)+ str.substring(i+1,str.length()), output + str.charAt(i));
			for(int j=0; j<smallAns.size(); j++){
				result.add(smallAns.get(j));
			}
		}
		return result;
	}
}

