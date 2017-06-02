package linkedList;

public class ListPartition {

	public static void main(String[] args) {

	}

	public Node listPartition_1(Node head, int pivot) {
		if (head == null) {
			return head;
		}
		Node cur = head;
		int len = 0;
		while (cur != null) {
			len++;
			cur = cur.next;
		}
		Node[] nodeArr = new Node[len];
		cur = head;
		for (int i = 0; i < nodeArr.length; i++) {
			nodeArr[i] = cur;
			cur = cur.next;
		}
		arrPartition(nodeArr, pivot);
		for (int i = 1; i < nodeArr.length; i++) {
			nodeArr[i - 1].next = nodeArr[i];
		}
		nodeArr[nodeArr.length - 1].next = null;
		return nodeArr[0];
	}

	private void arrPartition(Node[] nodeArr, int pivot) {
		int small = -1;
		int big = nodeArr.length;
		int index = 0;
		while (index != big) {
			if (nodeArr[index].value < pivot) {
				small++;
				swap(nodeArr, small, index);
				index++;
			} else if (nodeArr[index].value == pivot) {
				index++;
			} else {
				big--;
				swap(nodeArr, big, index);
			}
		}
	}

	private void swap(Node[] nodeArr, int small, int index) {
		Node temp = nodeArr[small];
		nodeArr[small] = nodeArr[index];
		nodeArr[index] = temp;
	}

	public Node listPartition_2(Node head, int pivot) {
		Node sH = null;
		Node sT = null;
		Node eH = null;
		Node eT = null;
		Node bH = null;
		Node bT = null;
		while (head != null) {
			Node next = head.next;
			if (head.value < pivot) {
				if (sH == null) {
					sH = head;
					sT = head;
				} else {
					sT.next = head;
					sT = head;
				}
			} else if (head.value == pivot) {
				if (eH == null) {
					eH = head;
					eT = head;
				} else {
					eT.next = head;
					eT = head;
				}
			} else {
				if(bH == null) {
					bH = head;
					bT = head;
				} else {
					bT.next = head;
					bT = head;
				}
			}
			head.next = next;
		}
		if(sT != null) {
			sT.next = eH;
			eT = (eT == null) ? sT : eT;
		}
		if(eT != null) {
			eT.next = bH;
		}
		return (sH != null) ? sH : (eH != null) ? eH : bH;
	}
}
