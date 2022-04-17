package com.practise.ds;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTasks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/**
 * 					1
 * 			2				3
 * 		4		5		6		7
 * 	8		9	
 *
 */
		Node root = new Node(1);
		Tree tree = new Tree(root);
		
		Node nodeL1 = new Node(2);
		Node nodeR1 = new Node(3);
		root.setLeft(nodeL1); root.setRight(nodeR1);
		
		Node nodeL2 = new Node(4);
		Node nodeR2 = new Node(5);
		nodeL1.setLeft(nodeL2); nodeL1.setRight(nodeR2);
		
		Node nodeL3 = new Node(6);
		Node nodeR3 = new Node(7);
		nodeR1.setLeft(nodeL3); nodeR1.setRight(nodeR3);
		
		Node nodeL4 = new Node(8);
		Node nodeR4 = new Node(9);
		nodeL2.setLeft(nodeL4); nodeL2.setRight(nodeR4);
	
		Node nodeL10 = new Node(10);
		nodeL3.setRight(nodeL10);
		
		tree.search();
	}
}



class Tree {
	private Node root;
	
	/**
	 * Tree DFS & BFS Coding. 
	 */
	public void search() {
		System.out.println("In Order");
		inorderSearch(root);
		System.out.println();
		System.out.println("Pre Order");
		preorderSearch(root);
		System.out.println();
		System.out.println("Post Order");
		postOrderSearch(root);
		System.out.println();
		System.out.println("BreathFirst Search");
		breathFirstSearch(root);
	}
	
	public void breathFirstSearch(Node node) {
		if(node != null){
			Queue<Node> q = new LinkedList<>();
			q.add(node);
			while(q.peek() != null){
				Node topNode = q.poll();
				System.out.print(topNode.getData() + " ");
				if(topNode.getLeft() != null){
					q.add(topNode.getLeft());	
				}
				if(topNode.getRight() != null){
					q.add(topNode.getRight());	
				}
			}
		}
	}
	
	public void inorderSearch(Node node) {
		if(node == null) {
			return;
		}
		inorderSearch(node.getLeft());
		System.out.print(node.getData() + " ");
		inorderSearch(node.getRight());
	}
	
	public void preorderSearch(Node node) {
		if(node == null) {
			return;
		}
		System.out.print(node.getData() + " ");
		preorderSearch(node.getLeft());
		preorderSearch(node.getRight());
	}
	
	public void postOrderSearch(Node node) {
		if(node == null) {
			return;
		}
		postOrderSearch(node.getLeft());
		postOrderSearch(node.getRight());
		System.out.print(node.getData() + " ");
	}
	
	public Tree(Node root) {
		this.root = root;
	}
	
	public Node getRootNode () {
		return root;
	}
}

class Node {
	private int data;
	private Node right;
	private Node left;
	
	
	public Node(int data) {
		super();
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
}