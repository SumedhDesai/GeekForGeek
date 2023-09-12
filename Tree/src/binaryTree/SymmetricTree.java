/*
 * Given a Binary Tree. Check whether it is Symmetric or not, i.e. 
 * whether the binary tree is a Mirror image of itself or not.
 */

package binaryTree;

import java.util.Stack;

public class SymmetricTree {
	public static boolean isSymmetric(Node root)
    {
        if(root == null){
            return true;
        }
        
        Stack<Node> pending = new Stack<>();
        pending.push(root.left);
        pending.push(root.right);
        
        while(!pending.isEmpty()){
            Node node1 = pending.pop();
            Node node2 = pending.pop();
            
            if(node1 == null && node2 == null){
                continue;
            }
            if(node1 == null || node2 == null){
                return false;
            }
            if(node1.data != node2.data){
                return false;
            }
            pending.push(node1.left);
            pending.push(node2.right);
            pending.push(node1.right);
            pending.push(node2.left);
        }
        return true;
    }
}
