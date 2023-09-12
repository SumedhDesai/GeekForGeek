package binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


class Pair{
    Node node;
    int hd;
    public Pair(Node node, int hd){
        this.node = node;
        this.hd = hd;
    }
}

public class VerticalBinaryTraversal {
	
	static ArrayList <Integer> verticalOrder(Node root)
	{
		ArrayList<Integer> ans = new ArrayList<>();
		if(root == null){
			return ans;
		}
		int leftMost =0;
		int rightMost =0;

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		Queue<Pair> pending = new LinkedList<>();

		pending.add(new Pair(root, 0));


		while(!pending.isEmpty()){
			Pair temp = pending.remove();
			Node node = temp.node;
			int hd = temp.hd;
			ArrayList<Integer> smallAns;
			if(map.containsKey(hd)){
				smallAns = map.get(hd);
			}else{
				smallAns = new ArrayList<>();
			}
			smallAns.add(node.data);
			map.put(hd, smallAns);
			if(node.left!=null){
				int leftHd = hd -1;
				pending.add(new Pair(node.left, leftHd));
				if(leftMost > hd-1){
					leftMost = hd-1;
				}
			}

			if(node.right!=null){
				int rightHd = hd+1;
				pending.add(new Pair(node.right, rightHd));
				if(rightMost < hd+1){
					rightMost = hd+1;
				}
			}
		}

		while(leftMost <= rightMost){
			ArrayList<Integer> smallArray = map.get(leftMost);
			for(int i=0; i<smallArray.size(); i++){
				ans.add(smallArray.get(i));
			}
			leftMost++;
		} 
		return ans; 
	}
}
