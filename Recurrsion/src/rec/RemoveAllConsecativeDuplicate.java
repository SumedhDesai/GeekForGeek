/*
 * Given a string s, remove all its adjacent duplicate characters recursively. 

	Note: For some test cases, the resultant string would be an empty string. In that case, 
	the function should return the empty string only.
	
	Example 1:
	Input:
	S = "geeksforgeek"
	Output: "gksforgk"
	Explanation: 
	g(ee)ksforg(ee)k -> gksforgk
	
	Example 2:
	Input: 
	S = "abccbccba"
	Output: ""
	Explanation: 
	ab(cc)b(cc)ba->abbba->a(bbb)a->aa->(aa)->""(empty string)
	
	Your Task:
	You don't need to read input or print anything. Your task is to complete the function 
	rremove() which takes the string S as input parameter and returns the resultant string.
	
	
	Expected Time Complexity: O(|S|)
	Expected Auxiliary Space: O(|S|)
	
	
	Constraints:
	1<=|S|<=105
 */
package rec;

public class RemoveAllConsecativeDuplicate {
	
	String rremove(String s) {
        if(s == null){
            return null;
        }
        if(s.equals("")){
            return "";
        }
        StringBuilder sb = new StringBuilder(s);
        int i =0;
        boolean flag = false;
        while(i<sb.length()){
            if(i<sb.length()-1 && sb.charAt(i) == sb.charAt(i+1)){
                int start = i;
                while(i<sb.length()-1 && sb.charAt(i) == sb.charAt(i+1)){
                    i++;
                }
                if(start != i+1){
                    sb.delete(start, i+1);
                    flag = true;
                    i=start;
                }
            }else{
                i++;
            }
        }
        if(flag){
            return rremove(sb.toString());
        }else{
            return sb.toString();
        }
    }
    
}
