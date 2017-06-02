package binaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerialByPre {

	public static void main(String[] args) {

	}

	public String serial(Node root) {
		StringBuffer sb = new StringBuffer();
		buildTree(root, sb);
		return sb.toString();
	}

	private void buildTree(Node root, StringBuffer sb) {
		if(root == null) {
			sb.append("$").append(",");
		} else {
			sb.append(root.value).append(",");
			buildTree(root.left, sb);
			buildTree(root.right, sb);
		}
	}
	
	public Node deserial(String str) {
		Queue<String> queue = new LinkedList<>();
		queue.addAll(Arrays.asList(str.split(",")));
		return buildTree(queue);
	}

	private Node buildTree(Queue<String> queue) {
		if(queue.isEmpty()) {
			return null;
		} else {
			String val = queue.poll();
			if(val.equals("$")) {
				return null;
			} else {
				Node node = new Node(Integer.valueOf(val));
				node.left = buildTree(queue);
				node.right = buildTree(queue);
				return node;
			}
		}
	}
}
