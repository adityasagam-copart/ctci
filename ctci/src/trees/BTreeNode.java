package trees;
public class BTreeNode {
	public int val;
	public BTreeNode left;
	public BTreeNode right;
	
	BTreeNode (int val){
		this.val = val;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BTreeNode t = new BTreeNode(2),
				t1 = new BTreeNode(7),
				t2 = new BTreeNode(9),
				t3 = new BTreeNode(6),
				t4 = new BTreeNode(5),
				t5 = new BTreeNode(8),
				t6 = new BTreeNode(3),
				t7 = new BTreeNode(22);
		t.left = t1;
		t.right = t2;
		t1.left = t3;
		t1.right = t4;
		t4.left = t6;
		t2.left = t5;
		t5.right = t7;
		System.out.println("Inorder:");
		inorder(t);
		System.out.println("Preorder:");
		preorder(t);
		System.out.println("Postorder:");
		postorder(t);
	}
	
	public static void inorder(BTreeNode r) {
		if(r != null) {
			inorder(r.left);
			System.out.println(r.val);
			inorder(r.right);
		}
	}
	
	public static void preorder(BTreeNode r) {
		if(r != null) {
			System.out.println(r.val);
			preorder(r.left);
			preorder(r.right);
		}
	}
	
	public static void postorder(BTreeNode r) {
		if(r != null) {
			postorder(r.left);
			postorder(r.right);
			System.out.println(r.val);
		}
	}
}
