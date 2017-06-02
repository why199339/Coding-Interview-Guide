package linkedList;

import java.util.HashSet;

public class RemoveRep {

	public static void main(String[] args) {

	}

	public Node removeRep(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		HashSet<Integer> set = new HashSet<>();
		set.add(head.value);
		Node prev = head;
		Node cur = head.next;
		while(cur != null) {
			if(set.contains(cur.value)) {
				prev.next = cur.next;
			} else {
				set.add(cur.value);
				prev = cur;
			}
			cur = cur.next;
		}
		return head;
	}
}
