package binaryTree;

import java.util.Stack;

class Result{
	int ans, count;
	public Result(int ans, int count){
		this.ans= ans;
		this.count= count;
	}
}
public class KthLargestElement {

	public int kthLargestRecursion(Node root,int k)
	{
		if(root == null){

		}
		Result r = kthLargeRec(root, k, 0);
		return r.ans;
	}

	public static Result kthLargeRec(Node root,int k,int count){
		if(root == null){
			return new Result(-1, count);
		}
		Result rightAns = kthLargeRec(root.right, k, count);
		count = rightAns.count;
		count++;
		if(k==count){
			return new Result(root.data, count);
		}
		Result leftAns = kthLargeRec(root.left, k, count);
		if(rightAns.ans != -1){
			return rightAns;
		}else{
			return leftAns;
		}
	}
	public static int kthLargestItterative(Node root, int k) {
		Stack<Node> s = new Stack<>();
		Node curr = root;
		int count=0;

		while(curr != null || !s.isEmpty()){
			while(curr!=null){
				s.push(curr);
				curr = curr.right;
			}
			curr = s.pop();
			count++;
			if(count == k){
				return curr.data;
			}
			curr=curr.left;
		}
		return -1;
	}
}
