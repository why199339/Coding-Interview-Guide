package stack_and_queue;

import java.util.LinkedList;

public class GetNum {

	public static void main(String[] args) {

	}

	public int getNum(int[] arr, int num) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int res = 0;
		LinkedList<Integer> qmax = new LinkedList<>();
		LinkedList<Integer> qmin = new LinkedList<>();
		int i = 0;
		int j = 0;
		while (i < arr.length) {
			while (j < arr.length) {
				while (!qmin.isEmpty() && arr[j] <= arr[qmin.peekLast()]) {
					qmin.pollLast();
				}
				qmin.offerLast(j);
				while (!qmax.isEmpty() && arr[j] >= arr[qmax.peekLast()]) {
					qmax.pollLast();
				}
				qmax.offerLast(j);
				if (qmax.peekFirst() - qmin.peekFirst() > num) {
					break;
				}
				j++;
			}
			res += j - i;
			if (qmin.peekFirst() == i) {
				qmin.pollFirst();
			}
			if (qmax.peekFirst() == i) {
				qmax.pollFirst();
			}
			i++;
		}
		return res;
	}
}
