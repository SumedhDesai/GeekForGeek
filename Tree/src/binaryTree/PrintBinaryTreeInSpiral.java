//Complete the function to find spiral order traversal of a tree.

package binaryTree;
import java.util.*;



public class PrintBinaryTreeInSpiral {
	//traversal in spiral form.	
    ArrayList<Integer> findSpiral(Node root) 
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        
        s1.push(root);
        ans.add(root.data);
        
        while(!s1.isEmpty() || !s2.isEmpty()){
            while(!s1.isEmpty()){
                
                Node temp = s1.pop();
                // ans.add(temp.data);
                
                if(temp.left!= null){
                    s2.push(temp.left);
                    ans.add(temp.left.data);
                }
                 if(temp.right!= null){
                    s2.push(temp.right);
                    ans.add(temp.right.data);
                }
            }
            while(!s2.isEmpty()){
                
                Node temp = s2.pop();
                // ans.add(temp.data);
                
                if(temp.right!= null){
                    s1.push(temp.right);
                    ans.add(temp.right.data);
                }
                if(temp.left!= null){
                    s1.push(temp.left);
                    ans.add(temp.left.data);
                }
                 
            }
        }
        return ans;
    }
   
}
