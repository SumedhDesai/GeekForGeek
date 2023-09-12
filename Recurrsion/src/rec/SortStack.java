/*
 * Given a stack, the task is to sort it such that the top of the stack 
 * has the greatest element.

	Example 1:
	
	Input:
	Stack: 3 2 1
	Output: 3 2 1
	Example 2:
	
	Input:
	Stack: 11 2 32 3 41
	Output: 41 32 11 3 2
	Your Task: 
	You don't have to read input or print anything. Your task is to complete 
	the function sort() which sorts the elements present in the given stack. 
	(The sorted stack is printed by the driver's code by popping the elements 
	of the stack.)
	
	Expected Time Complexity: O(N*N)
	Expected Auxiliary Space: O(N) recursive.
 */
package rec;

import java.util.Stack;

public class SortStack {
	public Stack<Integer> sort(Stack<Integer> s)
	{
		if(s.size()==1 || s.isEmpty()){
		    return s;
		}
		
		int temp = s.pop();
		
		Stack<Integer> ans = sort(s);
		Stack<Integer> store = new Stack<>();
		while(!ans.isEmpty() && ans.peek() > temp){
		    store.push(ans.pop());
		}
		
		ans.push(temp);
		
		while(!store.isEmpty()){
		    ans.push(store.pop());
		}
		return ans;
		
	}
}
