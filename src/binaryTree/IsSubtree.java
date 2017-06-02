package binaryTree;

public class IsSubtree {

	public static void main(String[] args) {

	}

	public boolean isSubtree(Node root1, Node root2) {
		String s1 = serialByPre(root1);
		String s2 = serialByPre(root2);
		return getIndexOf(s1, s2) != -1;
	}

	private int getIndexOf(String s, String m) {
		if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
			return -1;
		}
		char[] ss = s.toCharArray();
		char[] ms = m.toCharArray();
		int mi = 0;
		int si = 0;
		int[] next = getNextArr(ms);
		while (mi < ms.length && si < ss.length) {
			if (ss[si] == ms[mi]) {
				mi++;
				si++;
			} else if (next[mi] == -1) {
				si++;
			} else {
				mi = next[mi];
			}
		}
		return mi == ms.length ? si - mi : -1;
	}

	private int[] getNextArr(char[] ms) {
		if (ms.length == 1) {
			return new int[] { -1 };
		}
		int[] next = new int[ms.length];
		next[0] = -1;
		next[1] = 0;
		int pos = 2;
		int cn = 0;
		while (pos < next.length) {
			if (ms[pos - 1] == ms[cn]) {
				cn++;
				next[pos] = cn;
				pos++;
			} else if (cn > 0) {
				cn = next[cn];
			} else {
				next[pos] = 0;
				pos++;
			}
		}
		return next;
	}

	private String serialByPre(Node root) {
		StringBuffer sb = new StringBuffer();
		buildTree(root, sb);
		return sb.toString();
	}

	private void buildTree(Node root, StringBuffer sb) {
		if (root == null) {
			sb.append("$").append(",");
		} else {
			sb.append(root.value).append(",");
			buildTree(root.left, sb);
			buildTree(root.right, sb);
		}
	}
}
