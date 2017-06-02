package stack_and_queue;

import java.util.Deque;
import java.util.LinkedList;

public class GetMaxWindow {

	public static void main(String[] args) {

	}

	public static int[] getMaxWindow(int[] arr, int w) {
		if (arr == null || arr.length == 0 || w < 1 || arr.length < w) {
			return null;
		}
		LinkedList<Integer> list = new LinkedList<>();
		int[] result = new int[arr.length - w + 1];
		for (int i = 0; i < arr.length; i++) {
			while(!list.isEmpty() && arr[i] >= arr[list.getLast()]) {
				list.pollLast();
			}
			list.addLast(i);
			if(list.peekFirst() == i - w) {
				list.pollFirst();
			}
			if(i >= w - 1) {
				result[i - w + 1] = arr[list.peekFirst()];
			}
		}
		return result;
	}
}
