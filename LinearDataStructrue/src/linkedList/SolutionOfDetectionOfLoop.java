//Given a linked list of N nodes. The task is to check if the linked list has a loop. 
//Linked list can contain self loop.

package linkedList;

import java.util.HashMap;

public class SolutionOfDetectionOfLoop {

	public static boolean detectLoop(Node head){
		if(head == null){
			return false;  
		}
		HashMap<Node, Boolean> map = new HashMap<>();
		while(head!=null){
			if(map.containsKey(head)) {
				return true;
			}
			map.put(head, true);
			head = head.next;
		}
		return false;
	}

}
class Node
{
    int data;
    Node next;
    Node(int d) {data = d; next = null; }
}