package linkedlists;

import java.util.HashSet;

public class Node {
	public Node next = null;
	public int data;
	
	public Node(int d) {
		data = d;
	}
	
	private static class Result {
		Node tail;
		int size;
		
		private Result (Node tail, int size) {
			this.size = size;
			this.tail = tail;
		}
	}
	
	public Node removeDupsBuffer() {
		Node n = this;
		
		HashSet<Integer> hashSet = new HashSet<Integer>();
		
		Node prev = null;
		while(n != null) {
			if(hashSet.contains(n.data)) {
				prev.next = n.next;
			}
			else {
				hashSet.add(n.data);
				prev = n;
			}
			n = n.next;
		}
		return null;
	}
	
	public int kToLast(Node n, int k) {
		if(n.next != null) {
			int val = kToLast(n.next, k) + 1;
			if(val == k) {
				System.out.println(n.data);
			}
			return val;
		}
		return 0;
	}
	
	public void partition(int p) {
		Node n1 = this;
		
		while(n1.next != null) {
			if(n1.data >= p){
				Node n2 = n1.next;
				
				while(n2 != null && n2.data >= p) {
					n2 = n2.next;
				}
				if(n2 != null) {
					int temp = n1.data;
					n1.data = n2.data;
					n2.data = temp;
				}
			}
			n1 = n1.next;
		}
	}
	
	public void appendToTail(int d) {
		Node newNode = new Node(d);
		Node currentNode = this;
		
		while( currentNode.next != null ) {
			currentNode = currentNode.next;
		}
		currentNode.next = newNode;
	}
	
	public void appendToTail(Node newNode) {
		Node currentNode = this;
		
		while( currentNode.next != null ) {
			currentNode = currentNode.next;
		}
		currentNode.next = newNode;
	}
	
	public Node deleteNode(int data) {
		Node currentNode = this;
		
		if(currentNode.data == data) {
			return currentNode.next;
		}
		
		while(currentNode.next != null) {
			if(currentNode.next.data == data) {
				currentNode.next = currentNode.next.next;
				return this;
			}
			currentNode = currentNode.next;
		}
		return null;
	}
	
	public void deletMiddle(Node n) {
		if(n !=  null) {
			n.data = n.next.data;
			n.next = n.next.next;
		}
	}
	
	public void printList() {
		Node n = this;
		while(n != null) {
			System.out.print(n.data);
			if(n.next != null) {
				System.out.print(" -> ");
			}
			n = n.next;			
		}
		System.out.print("\n\n");
	}
	
	public static Node sumLists(Node n, Node m) {
		int sum = 0, cy = 0;
		Node res = null;
		while(true) {
			if(n == null && m == null && cy == 0) {
				break;
			}

			sum = ((n != null) ? n.data : 0 ) + ((m != null) ? m.data : 0) + cy;
			cy = sum / 10;
			sum = sum % 10;
			
			if(res == null) {
				res = new Node(sum);
			}
			else{
				res.appendToTail(sum);
			}
			
			
			n = (n == null) ? null : n.next;
			m = (m == null) ? null : m.next;
			
		}
		return res;
	}
	
	public void isPalindrome() {
		Node n = this;
		Node rev= n.getReverse();
		
		while(n != null) {
			if(n.data != rev.data) {
				System.out.println("is not a Palindrome.");
				return;
			}
			n = n.next;
			rev = rev.next;
		}
		System.out.println("is a Palindrome.");
	}
	
	public Node getReverse() {
		Node node = this;
		Node reverse = null;
		
		while(node != null) {
			Node temp = new Node(node.data);
			if(reverse != null) {
				temp.next = reverse;
			}
			reverse = temp;
			node = node.next;
		}
		return reverse;
	}
	
	public static Node getIntersection(Node n, Node m) {
		if(n == null || m == null) return null;
		Result res1 = getTailAndResult(n);
		Result res2 = getTailAndResult(m);
		
		if(res1.tail != res2.tail) {
			return null;
		}
		
		Node larger = res1.size > res2.size ? n : m;
		Node smaller = res1.size < res2.size ? n : m;
		
		Node kthNode = getKthNode(larger, Math.abs(res1.size - res2.size));
		
		while(smaller != kthNode) {
			smaller = smaller.next;
			kthNode = kthNode.next;
		}
		return kthNode;
	}
	
	public static Node getKthNode(Node p, int k) {
		while( k > 0) {
			p = p.next;
			k--;
		}
		return p;
	}
	
	public static Result getTailAndResult(Node node) {
		int size = 1;
		while(node.next != null) {
			size++;
			node = node.next;
		}
		Result res = new Node.Result(node, size); 
		return res;
	}
}
