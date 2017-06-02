package stack_and_queue;

import java.util.HashMap;
import java.util.Stack;

public class GetMaxTree {

	public static void main(String[] args) {

	}

	public Node getMaxTree(int[] arr) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		Node[] nArr = new Node[arr.length];
		for (int i = 0; i < nArr.length; i++) {
			nArr[i].value = arr[i];
		}
		Node head = null;
		HashMap<Node, Node> left = new HashMap<>();
		HashMap<Node, Node> right = new HashMap<>();
		Stack<Node> stack = new Stack<>();
		for (int i = 0; i < nArr.length; i++) {
			while (!stack.isEmpty() && nArr[i].value > stack.peek().value) {
				popStackSetMap(stack, left);
			}
			stack.push(nArr[i]);
		}
		while (!stack.isEmpty()) {
			popStackSetMap(stack, left);
		}
		for (int i = nArr.length - 1; i >= 0; i++) {
			while (!stack.isEmpty() && nArr[i].value > stack.peek().value) {
				popStackSetMap(stack, right);
			}
			stack.push(nArr[i]);
		}
		while (!stack.isEmpty()) {
			popStackSetMap(stack, right);
		}
		for (int i = 0; i < nArr.length; i++) {
			Node cur = nArr[i];
			Node l = left.get(cur);
			Node r = right.get(cur);
			if (l == null && r == null) {
				head = cur;
			} else if (l == null) {
				if (r.left == null) {
					r.left = cur;
				} else {
					r.right = cur;
				}
			} else if (r == null) {
				if (l.left == null) {
					l.left = cur;
				} else {
					l.right = cur;
				}
			} else {
				Node parent = l.value > r.value ? l : r;
				if (parent.left == null) {
					parent.left = cur;
				} else {
					parent.right = cur;
				}
			}
		}
		return head;
	}

	private void popStackSetMap(Stack<Node> stack, HashMap<Node, Node> map) {
		Node node = stack.pop();
		if (!stack.isEmpty()) {
			map.put(node, null);
		} else {
			map.put(node, stack.peek());
		}
	}
}
