package com.datastructures.LinkedList.problems;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import com.datastructures.LinkedList.implementation.LinkedList;
import com.datastructures.LinkedList.implementation.Node;

public class LinkedListProblems {

	public void printLLInReverseOrder(Node head) {
		
		if(head == null)
			return;
		
		if(head!=null) {
			printLLInReverseOrder(head.getNext());
			System.out.print(head.getData() + "\t");
		}
		
	}
	
	public void printLLInReverseOrderIterativeApproach(Node head) {
		
		if(head==null)
			return;
		
		Stack<Integer> stack = new Stack<>();
		Node current = head;
		while(current!=null) {
			stack.add(current.getData());
			current = current.getNext();
		}
		
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + "\t");
		}
		
	}
	
	public Node reverse(Node head) {
		
		if(head == null)
			return null;
		
		Node prev=null;
		Node nextNode=null;
		Node current=head;
		
		while(current!=null) {
			nextNode=current.getNext();
			current.setNext(prev);
			prev=current;
			current=nextNode;
		}
		return prev;
	}
	
	public void printNodes(Node head) {
		
		if(head == null)
			return;
		
		Node current=head;
		while(current!=null) {
			System.out.print(current.getData() + "\t");
			current=current.getNext();
		}
	}
	
	public Node findMiddleNode(Node head) {
		if(head == null)
			return null;
		
		Node slowNode=head;
		Node fastNode=head;
		
		while(fastNode!=null && fastNode.getNext()!=null) {
			slowNode=slowNode.getNext();
			fastNode=fastNode.getNext().getNext();
		}
		return slowNode;
	}
	
	public Node findKthNodeFromEnd(Node head, Integer k) {
		if(k<=0 || head == null)
			return null;
		
		Node kthNode=head;
		Node current=head;
		
		for(int i=1;i<k&&current!=null;++i)
			current=current.getNext();
		
		if(current==null)
			return null;
		
		while(current.getNext()!=null) {
			kthNode = kthNode.getNext();
			current=current.getNext();
		}
		
		return kthNode;
			
	}
	
	public boolean isLoopExist(Node head) {
		if(head == null)
			return false;
		
		Node fastRef=head;
		Node slowRef=head;
		
		while(slowRef!=null && fastRef!=null && fastRef.getNext()!=null) {
			slowRef = slowRef.getNext();
			fastRef = fastRef.getNext().getNext();
			if(slowRef == fastRef) 
				return true;
		}
		
		return false;
	}
	
	public Node getFirstNodeOfLoop(Node head) {
		if(head == null)
			return null;
		
		Node fastRef=head;
		Node slowRef=head;
		boolean isLoopExist=false;
		
		while(slowRef!=null && fastRef!=null && fastRef.getNext()!=null) {
			slowRef = slowRef.getNext();
			fastRef = fastRef.getNext().getNext();
			if(slowRef == fastRef) {
				isLoopExist=true;
				break;
			}
		}
		
		if(!isLoopExist) 
			return null;
		
		slowRef=head;
		
		while(slowRef!=null && fastRef!=null) {
			slowRef=slowRef.getNext();
			fastRef=fastRef.getNext();
			if(slowRef == fastRef)
				return slowRef;
		}
		return null;
	}
	
	public Integer getLength(Node head) {
		if(head == null)
			return 0;
		
		Integer count=0;
		Node current=head;
		while(current!=null) {
			++count;
			current = current.getNext();
		}
		return count;
	}
	
	private Integer carry=0;
	private LinkedList newList = new LinkedList();
	public Node addLinkedLists(Node head1,Node head2) {
		
		if(head1 == null && head2 == null)
			return null;
		
		if(head1 == null)
			return head2;
		if(head2 == null)
			return head1;
			
		Integer length1 = getLength(head1);
		Integer length2 = getLength(head2);
		Integer diff = length1 - length2;
		
		if(diff>0) {
			head2=addZeroAtBeginByKtimes(head2,diff);
		}else if(diff<0) {
			head1=addZeroAtBeginByKtimes(head1,diff);
		}
		
		addLinkedListsHelper(head1,head2);
		if(carry==1) {
			newList.insert(1);
		}
		
		return newList.getHead();
	}
	
	private void addLinkedListsHelper(Node head1, Node head2) {
		if(head1 == null || head2 == null)
			return;
		
		addLinkedListsHelper(head1.getNext(),head2.getNext());
		Integer sum = head1.getData()+head2.getData()+carry;
		if(sum>=10) {
			sum =sum-10;
			carry=1;
		}else {
			carry=0;
		}
		
		newList.insert(sum);
	}

	private Node addZeroAtBeginByKtimes(Node node,Integer k) {
		if(node==null || k<=0)
			return null;
		LinkedList list=new LinkedList(node);
		
		for(int i=0;i<k;++i) {
			list.insert(0);
		}
		return list.getHead();
	}
	
	public Node getIntersectionNodeOfLinkedLists(Node head1, Node head2) {
		if(head1 == null || head2 == null)
			return null;
		
		Integer length1 = getLength(head1);
		Integer length2 = getLength(head2);
		Integer diff = length1 - length2;
		if(diff>0)
			head1 = moveHeadByKtimes(head1,diff);
		else if(diff<0)
			head2 = moveHeadByKtimes(head2,diff);
		
		while(head1!=null && head2!=null) {
			if(head1==head2) 
				return head1;
			head1=head1.getNext();
			head2=head2.getNext();
		}
		
		return null;
	}

	private Node moveHeadByKtimes(Node head, Integer k) {
		if(head==null || k<=0)
			return null;
		
		Node current=head;
		for(int i=0;i<k&&current!=null;++i) {
			current=current.getNext();
		}
		return current;
		
	}
	
	public Node getIntersectionNodeOfLinkedListsUsingCircularListApproach(Node head1, Node head2) {
		if(head1 == null || head2 == null)
			return null;
		
		Node current=head1;
		while(current.getNext()!=null) 
			current=current.getNext();

		Node tail1=current;
		current.setNext(head1);
		
		Node intersectionNode = getFirstNodeOfLoop(head2);
		tail1.setNext(null);
		return intersectionNode;
		
	}
	
	public void alternateSplitOfLinkedList(Node head) {
		
		Node head1 = head;
		Node head2 = head.getNext();
		
		Node current = head;
		Node nextNode = null;
		while(current!=null) {
			nextNode = current.getNext();
			if(nextNode!=null)
				current.setNext(nextNode.getNext());
			current=nextNode;
		}
		
		Node current1=head1;
		System.out.println("Printing List1 Data");
		while(current1!=null) {
			System.out.print(current1.getData() + "\t");
			current1=current1.getNext();
		}
		
		Node current2=head2;
		System.out.println("\nPrinting List2 Data");
		while(current2!=null) {
			System.out.print(current2.getData() + "\t");
			current2=current2.getNext();
		}
		
	}
	
	/*public void isPalindrome(Node head) {
		if(head == null)
			return true;
		if(head.getNext() == null)
			return true;
		
		Node middleNode = findMiddleNode(head);
		
		Node secondHalfHead = reverse(middleNode);
		
		//compare(head,secondHalfHead);
		
		Node current=secondHalfHead;
		while(current!=null) {
			System.out.print(current.getData() + "\t");
			current=current.getNext();
		}
		
	}

	
	public Node getMiddleNode(Node head) {
		
		if(head == null)
			return null;
		
		Integer length = getLength(head);
		Integer middleLength = (int)Math.ceil(length/2.0);
		Node current = head;
		for(int i=0;i<middleLength;++i) 
			current=current.getNext();
		return current;
		
	}*/
	
	
	public Node merge2SortedLinkedList(Node head1,Node head2) {
		if(head1 == null || head2==null)
			return (head1!=null)?head1:head2;
		
		Node mergeListHead;
		Node mergeListTail;
		
		if(head1.getData() <=head2.getData()) {
			mergeListHead=head1;
			head1=head1.getNext();
		}else {
			mergeListHead=head2;
			head2=head2.getNext();
		}
		
		mergeListTail=mergeListHead;
		
		while(head1!=null && head2!=null) {
			if(head1.getData() <=head2.getData()) {
				mergeListTail.setNext(head1);
				mergeListTail=mergeListTail.getNext();
				head1=head1.getNext();
			}else {
				mergeListTail.setNext(head2);
				mergeListTail=mergeListTail.getNext();
				head2=head2.getNext();
			}
		}
		
		mergeListTail.setNext((head1==null)?head2:head1);
		
		/*if(head1==null) {
			mergeListTail.setNext(head2);
		}else {
			mergeListTail.setNext(head1);
		}*/
		
		return mergeListHead;
	}
	
	public Node mergeKSortedLinkedListsUsingMinHeap(Node[] lists) {
		if(lists == null)
			return null;
		if(lists.length==1)
			return lists[0];
		
		Queue<Node> minHeap = new PriorityQueue<>(
				new Comparator<Node>() {
					@Override
					public int compare(Node node1, Node node2) {
						return node1.getData() - node2.getData();
					}
				});
		
		for(Node aNode : lists)
			minHeap.offer(aNode);
		
		LinkedList mergedList = new LinkedList();
		while(!minHeap.isEmpty()) {
			Node current = minHeap.poll();
			mergedList.insertAtEnd(current.getData());
			if(current.getNext()!=null)
				minHeap.offer(current.getNext());
		}
		return mergedList.getHead();
	}
	
	public Node mergeKSortedLinkedListsUsingMergeTechnique(Node[] lists,Integer last) {
		
		if(lists==null || last<0)
			return null;
		
		while(last!=0) {
			Integer start=0;
			Integer end=last;
		
			while(start<end) {	
				lists[start]=merge2SortedLinkedList(lists[start],lists[end]);
				++start;
				--end;
				if(start>=end)
					last=end;
			}
		}
		return lists[0];
		
		
	}
	
}
