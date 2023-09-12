/*
 * Given a Binary Tree, return Left view of it. Left view of a Binary Tree is set 
 * of nodes visible when tree is visited from Left side. The task is to complete 
 * the function leftView(), which accepts root of the tree as argument.
 */

package binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfTree {
	
	public static ArrayList<Integer> leftViewByRecursion(Node root){
        ArrayList<Integer> result = new ArrayList<>();
        leftViewHelper(root, result, 0);
        return result;
    }
    
    public static void leftViewHelper(Node root ,ArrayList<Integer> result, int currLev){
      if(root == null){
          return;
      }
      if(currLev == result.size()){
      result.add(root.data);
      }
      leftViewHelper(root.left, result, currLev+1);
      leftViewHelper(root.right, result, currLev+1);
    }
    
    public static ArrayList<Integer> leftViewByIteration(Node root){
    	     ArrayList<Integer> ans = new ArrayList<>();
    	     if(root == null){
    	          return ans;
    	      }
    	      
    	      Queue<Node> q = new LinkedList<>();
    	      q.add(root);
    	    
    	      
    	      while(!q.isEmpty()){
    	          
    	          int levelSize = q.size();
    	          boolean leftFound = false;
    	          
    	          for(int i=0; i<levelSize; i++){
    	               Node node = q.remove();
    	              if(!leftFound){
    	                  ans.add(node.data);
    	                  leftFound = true;
    	              }
    	              if(node.left!=null){
    	                  q.add(node.left);
    	              }
    	              if(node.right!=null){
    	                  q.add(node.right);
    	              }
    	          }
    	      }
    	      return ans;
    }
}
