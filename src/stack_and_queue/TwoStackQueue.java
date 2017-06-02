package stack_and_queue;

import java.util.Stack;

public class TwoStackQueue {

	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();

	public static void main(String[] args) {

	}

	public void add(int val) {
		stack1.push(val);
	}

	public int poll(int val) {
		if (stack1.isEmpty() && stack2.isEmpty()) {
			return -1;
		}
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}

	public int peek(int val) {
		if (stack1.isEmpty() && stack2.isEmpty()) {
			return -1;
		}
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.peek();
	}
}
