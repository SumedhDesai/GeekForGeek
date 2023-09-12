package binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BottomView {

	public ArrayList <Integer> bottomView(Node root)
	{
		ArrayList<Integer> ans = new ArrayList<Integer> ();
		if(root == null){
			return ans;
		}

		// last node of vertical order traversal of binary tree is bottom view
		// of tree

		HashMap<Integer, Integer> map = new HashMap<>();
		Queue<Node> pending = new LinkedList<>();
		int leftMost = 0;
		int rightMost = 0;

		root.hd =0;
		pending.add(root);


		while(!pending.isEmpty()){
			
			Node temp = pending.remove();
			int hd = temp.hd;
			map.put(hd, temp.data);
			
			if(temp.left != null){
				temp.left.hd = hd -1;
				if(leftMost>hd-1){
					leftMost = hd-1;
				}
				pending.add(temp.left);
			}
			
			if(temp.right!= null){
				temp.right.hd= hd+1;
				if(rightMost < hd +1){
					rightMost = hd+1;
				}
				pending.add(temp.right);
			}
		}
		
		while(leftMost<=rightMost){
			ans.add(map.get(leftMost));
			leftMost++;
		}
		return ans;   
	}
}
