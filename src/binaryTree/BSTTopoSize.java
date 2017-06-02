package binaryTree;

import java.util.HashMap;
import java.util.Map;

public class BSTTopoSize {

	public static void main(String[] args) {

	}

	public int bstTopoSize1(Node root) {
		Map<Node, Record> map = new HashMap<Node, Record>();
		return postOrder(root, map);
	}

	private int postOrder(Node root, Map<Node, Record> map) {
		if(root == null) {
			return 0;
		}
		int pleft = postOrder(root.left, map);
		int pright = postOrder(root.right, map);
		modifyMap(root.left, root.value, map, true);
		modifyMap(root.right, root.value, map, false);
		Record rleft = map.get(root.left);
		Record rright = map.get(root.right);
		int lbst = rleft == null ? 0 : rleft.left + rleft.right + 1;
		int rbst = rright == null ? 0 : rright.left + rright.right + 1;
		map.put(root, new Record(lbst, rbst));
		return Math.max(lbst + rbst + 1, Math.max(pleft, pright));
	}

	private int modifyMap(Node root, int value, Map<Node, Record> map, boolean flag) {
		if(root == null || !map.containsKey(root)) {
			return 0;
		}
		Record record = map.get(root);
		if((flag && root.value > value) || (!flag && root.value < value)) {
			map.remove(root);
			return record.left + record.right + 1;
		} else {
			int minus = modifyMap(flag ? root.right : root.left, value, map, flag);
			if(flag) {
				record.right = record.right - minus;
			} else {
				record.left = record.left - minus;
			}
			map.put(root, record);
			return minus;
		}
	}

}

class Record {
	int left;
	int right;

	public Record(int left, int right) {
		this.left = left;
		this.right = right;
	}
}
