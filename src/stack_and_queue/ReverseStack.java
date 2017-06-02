package stack_and_queue;

import java.util.Stack;

public class ReverseStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		reverseStack(stack);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

	public static int getAndRemoveLastElement(Stack<Integer> stack) {
		int val = stack.pop();
		if (stack.isEmpty()) {
			return val;
		}
		int result = getAndRemoveLastElement(stack);
		stack.push(val);
		return result;
	}

	public static void reverseStack(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		}
		int val = getAndRemoveLastElement(stack);
		reverseStack(stack);
		stack.push(val);
	}
}
