package linkedList;

public class RemoveNodeWired {

	public static void main(String[] args) {

	}

	public void removeNodeWired(Node node) {
		if(node == null || node.next == null) {
			return;
		}
		node.value = node.next.value;
		node.next = node.next.next;
	}
}
