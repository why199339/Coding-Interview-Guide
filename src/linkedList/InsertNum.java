package linkedList;

public class InsertNum {

	public static void main(String[] args) {

	}

	public Node insertNum(Node head, int num) {
		if(head == null) {
			Node node = new Node(num);
			node.next = node;
			return node;
		}
		Node prev = head;
		Node cur = head.next;
		while(cur != head) {
			if(prev.value <= num && cur.value >= num) {
				break;
			}
			prev = prev.next;
			cur = cur.next;
		}
		Node node = new Node(num);
		prev.next = node;
		node.next = cur;
		if(num < cur.value) {
			return node;
		} else {
			return head;
		}
	}
}
