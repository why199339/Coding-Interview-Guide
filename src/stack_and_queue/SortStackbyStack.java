package stack_and_queue;

import java.util.Stack;

public class SortStackbyStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(2);
		stack.push(1);
		stack.push(4);
		stack.push(3);
		sortStackbyStack(stack);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

	public static void sortStackbyStack(Stack<Integer> stack) {
		Stack<Integer> help = new Stack<Integer>();
		if (stack.isEmpty()) {
			return;
		}
		while (!stack.isEmpty()) {
			int cur = stack.pop();
			while (!help.isEmpty() && help.peek() < cur) {
				stack.push(help.pop());
			}
			help.push(cur);
		}
		while (!help.isEmpty()) {
			stack.push(help.pop());
		}
	}
}
