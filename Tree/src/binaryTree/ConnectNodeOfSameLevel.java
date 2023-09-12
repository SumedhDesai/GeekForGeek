/*
	 * Given a binary tree, connect the nodes that are at same level. 
	 * You'll be given an addition nextRight pointer for the same.
	
	Initially, all the nextRight pointers point to garbage values. 
	Your function should set these pointers to point next right for each node.
	       10                       10 ------> NULL
	      / \                       /      \
	     3   5       =>     3 ------> 5 --------> NULL
	    / \     \               /  \           \
	   4   1   2          4 --> 1 -----> 2 -------> NULL
	
	 
	
	Example 1:
	
	Input:
	     3
	   /  \
	  1    2
	Output:
	3 1 2
	1 3 2
	Explanation:The connected tree is
	        3 ------> NULL
	     /    \
	    1-----> 2 ------ NULL
	Example 2:
	
	Input:
	      10
	    /   \
	   20   30
	  /  \
	 40  60
	Output:
	10 20 30 40 60
	40 20 60 10 30
	Explanation:The connected tree is
	         10 ----------> NULL
	       /     \
	     20 ------> 30 -------> NULL
	  /    \
	 40 ----> 60 ----------> NULL
	Your Task:
	You don't have to take input. Complete the function connect() 
	that takes root as parameter and connects the nodes at same level. 
	The printing is done by the driver code. First line of the output will 
	be level order traversal and second line will be inorder travsersal
 */
package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodeOfSameLevel {
	
    public void connect(Node root)
    {
        if(root == null){
            return;
        }
        Queue<Node> pending = new LinkedList<>();
        pending.add(root);
        pending.add(null);
        
        while(!pending.isEmpty()){
            Node temp = pending.remove();
            
            while(temp != null){
                if(temp.left!=null){
                    pending.add(temp.left);
                }
                if(temp.right != null){
                    pending.add(temp.right);
                }
                Node fwd = pending.poll();
                if(fwd == null ){
                    if(!pending.isEmpty()){
                         pending.add(null);
                    }
                }
                temp.nextRight = fwd;
                temp = fwd;
            
            }
        }
    }
}
