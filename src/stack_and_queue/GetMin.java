package stack_and_queue;

import java.util.Stack;

public class GetMin {

	Stack<Integer> stack_data = new Stack<>();
	Stack<Integer> stack_min = new Stack<>();

	public static void main(String[] args) {

	}

	public void push(int val) {
		stack_data.push(val);
		if (stack_min.isEmpty() || val < stack_min.peek()) {
			stack_min.push(val);
		} else {
			stack_min.push(stack_min.peek());
		}
	}

	public int pop() {
		if (stack_data.isEmpty()) {
			return -1;
		}
		int result = stack_data.pop();
		stack_min.pop();
		return result;
	}

	public int getMin() {
		if (stack_min.isEmpty()) {
			return -1;
		}
		return stack_min.peek();
	}
}
