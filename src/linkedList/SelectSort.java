package linkedList;

public class SelectSort {

	public static void main(String[] args) {

	}

	public Node selectSort(Node head) {
		if(head == null) {
			return head;
		}
		Node tail = null;
		Node small = null;
		Node smallPrev = null;
		Node cur = head;
		while(cur != null) {
			small = cur;
			smallPrev = getSmallestPreNode(cur);
			if(smallPrev != null) {
				small = smallPrev.next;
				smallPrev.next = small.next;
			}
			cur = (cur == small) ? cur.next : cur;
			if(tail == null) {
				head = small;
			} else {
				tail.next = small;
			}
			tail = small;
		}
		return head;
	}

	private Node getSmallestPreNode(Node head) {
		Node smallPrev = null;
		Node small = head;
		Node prev = head;
		Node cur = head.next;
		while(cur != null) {
			if(cur.value < small.value) {
				small = cur;
				smallPrev = prev;
			}
			prev = cur;
			cur = cur.next;
		}
		return smallPrev;
	}
}
