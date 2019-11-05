package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import linkedlists.Node;

public class Tnode {
	String name;
	ArrayList<Tnode> children;
	public boolean visited;
	
	public Tnode(String c) {
		this.name = c;
		this.children = new ArrayList<Tnode>();
	}
}

/*
 * class linkedlist { Node root;
 * 
 * linkedlist (Node root) { this.root = root; }
 * 
 * public void appendToTail(int d) { this.root.appendToTail(d); } }
 */

class Challenge{
	public static void main(String[] args) {
		/*Node n = new Node('2'),
			 n1 = new Node('3'),
			 n2 = new Node('4'),
			 n3 = new Node('5'),
			 n4 = new Node('6'),
			 n5 = new Node('7');
		n.children.add(n1);
		n.children.add(n2);
		n.children.add(n3);
		n.children.add(n5);
		
		n1.children.add(n4);
		n1.children.add(n5);
		
		Node n6 = new Node('H');
		//bfs(n);
		//System.out.println(routeExists(n5, n));
*/	
		//sumLevelsDriver();	
		
		
				
	}
	
	public static void bfs(Tnode root) {
		Queue<Tnode> queue = new LinkedList<Tnode>();
		root.visited = true;
		queue.add(root);
		
		System.out.println(root.name);
		System.out.println("--");
		
		while(!queue.isEmpty()) {
			Tnode curr = queue.remove();
			
			for(Tnode n : curr.children) {
				if(!n.visited) {
					n.visited = true;
					System.out.println(n.name);
					queue.add(n);
				}
			}
			System.out.println("--");
		}
	}
	
	public static boolean routeExists(Tnode src, Tnode dest) {
		Queue<Tnode> queue = new LinkedList<Tnode>();
		src.visited = true;
		queue.add(src);
		
		while(!queue.isEmpty()) {
			Tnode curr = queue.remove();
			
			for(Tnode n : curr.children) {
				if(!n.visited) {
					if(n.equals(dest)) {
						return true;
					}

					n.visited = true;
					queue.add(n);
				}
			}
		}
		return false;
	}
	
	public static void sumLevelsDriver() {
		Tnode n = new Tnode("1"),
			 n1 = new Tnode("9"),
			 n2 = new Tnode("5"),
			 n3 = new Tnode("8"),
			 n4 = new Tnode("2"),
			 n5 = new Tnode("6"),
			 n6 = new Tnode("9"),
			 n7 = new Tnode("1"),
			 n8 = new Tnode("7");
	
		n.children.add(n1);
		n.children.add(n2);
		n1.children.add(n3);
		n1.children.add(n4);
		
		n2.children.add(n5);
		n5.children.add(n6);
		
		n6.children.add(n7);
		n6.children.add(n8);
			
		//sumLevels(n);
		listDepths(n);
	}
	
	//	Calculate sum of nodes at each level in a tree
	public static int[] sumLevels(Tnode root) {
		// add root at the zeroth index
		int level = 0;
		ArrayList<Integer> sumLevels = new ArrayList<Integer>();
		sumLevels.add(level, Integer.valueOf(root.name));
		
		// iterate the sub tree to sum on each level
		iterLevels(level+1, sumLevels, root);
		
		for(int x : sumLevels) {
			System.out.println(x);
		}
		return null;
	}
	
	private static void iterLevels(int level, ArrayList<Integer> sumLevels, Tnode n) {
		if(n != null && !n.children.isEmpty()) {
			
			// calc sum of all children
			for(Tnode c : n.children) {
				
				// add new empty element if new level cannot be accomodated  
				if(sumLevels.size()-1 < level) {
					sumLevels.add(level, 0);
				}
				
				// get value at current index (level)
				int x = sumLevels.get(level);
				
				// update value at current level
				sumLevels.set(level, x + Integer.valueOf(c.name));
				
				// process on next level
				iterLevels(level+1, sumLevels, c);
			}
		}
	}
	
	// Create linked list at each level in a tree
	public static void listDepths(Tnode tnode) {
		ArrayList<LinkedList<Node>> arrLists = new ArrayList<LinkedList<Node>>();
		Node n = new Node(Integer.valueOf(tnode.name));
		LinkedList<Node> ll = new LinkedList<Node>();
		ll.add(n);
		arrLists.add(ll);
		
		iterListDepths(arrLists, 1, tnode);
		
		for(LinkedList<Node> printll : arrLists) {
			System.out.println("Level");
			Node r = printll.pop();
			while(r != null) {
				System.out.println(r.data);
				
				if(!printll.isEmpty()) {
					r = printll.pop();
				}
				else {
					r = null;
				}
			}
		}
	} 
	
	private static void iterListDepths(ArrayList<LinkedList<Node>> arrLists, int level, Tnode n) {
		if(n != null && !n.children.isEmpty()) {
			
			for(Tnode c: n.children) {
				if(arrLists.size()-1 < level) {
					arrLists.add(level, new LinkedList<Node>());
				}
				LinkedList<Node> tempLL = arrLists.get(level);
				tempLL.add(new Node(Integer.valueOf(c.name)));
				iterListDepths(arrLists, level+1, c);
			}
		}
	}
}
