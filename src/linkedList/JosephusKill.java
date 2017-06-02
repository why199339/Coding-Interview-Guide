package linkedList;

public class JosephusKill {

	public static void main(String[] args) {

	}

	public Node josephusKill_1(Node head, int m) {
		if (head == null || head.next == head || m < 1) {
			return head;
		}
		Node last = head;
		while (last.next != head) {
			last = last.next;
		}
		int count = 0;
		while (head != last) {
			count++;
			if (count == m) {
				last.next = head.next;
				count = 0;
			} else {
				last = last.next;
			}
			head = last.next;
		}
		return head;
	}

	public Node josephusKill_2(Node head, int m) {
		if (head == null || head.next == head || m < 1) {
			return head;
		}
		Node node = head.next;
		int len = 1;
		while (node != head) {
			len++;
			node = node.next;
		}
		int pos = getLive(len, m);
		while (--pos != 0) {
			head = head.next;
		}
		head.next = head;
		return head;
	}

	private int getLive(int len, int m) {
		if (len == 1) {
			return 1;
		}
		return (getLive(len - 1, m) + m - 1) % len + 1;
	}

}
