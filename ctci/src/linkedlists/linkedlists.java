package linkedlists;

public class linkedlists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node m = new Node(1);
		m.appendToTail(new Node(2));
		m.appendToTail(new Node(3));
		m.appendToTail(new Node(4));
		m.appendToTail(new Node(5));
		
		Node n = new Node(11);
		n.appendToTail(new Node(12));
		n.appendToTail(new Node(13));
		n.appendToTail(new Node(14));
		n.appendToTail(new Node(15));
		n.appendToTail(new Node(16));
		n.appendToTail(new Node(17));
		n.appendToTail(new Node(18));
		n.appendToTail(new Node(19));
		
		Node o = new Node(100);
		o.appendToTail(new Node(101));
		o.appendToTail(new Node(102));
		o.appendToTail(new Node(103));
		o.appendToTail(new Node(104));
		
		m.appendToTail(o);
		n.appendToTail(o);
		
		m.printList();
		n.printList();
		
		Node intsec = Node.getIntersection(n, m);
		System.out.print(intsec.data);
		/*
		Node n = new Node(7);
		n.appendToTail(1);
		n.printList();
		
		Node m = new Node(5);
		m.appendToTail(9);
		m.appendToTail(5);
		m.printList();
		
		Node res = Node.sumLists(n, m);
		res.printList();
		*/
		/* DELETE NODE
		System.out.println("\n\nDeleting 9:");
		n = n.deleteNode(9);
		*/
		
		/*
		 REMOVE DUPLICATES
		 n.removeDupsBuffer();
		 */
		
		/*
		 Kth to Last
		 n.kToLast(n, 7);
		 */
		
		/*
		 * DELETE Middle node given access to only that node
		 
		int k = 10;
		Node nn = n;
		while(nn != null) {
			if(nn.data == k) {
				break;
			}
			nn = nn.next;
		}
		n.deletMiddle(nn);
		*/
		//n.partition(4);
		
	}

}
