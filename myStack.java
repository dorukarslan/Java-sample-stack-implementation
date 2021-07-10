//----------------------------------------------------- 
// Title: Linked list, STACK, QUEUE
// Author: Doruk Arslan
// Description: This class is uses for creating a generic stack with considering Linked List implemantation.
//-----------------------------------------------------


import java.util.Scanner;

public class myStack<Item> {

	private Node<Item> first;
	
	//to keep count of the nodes
	public int count;
	private class Node<Item>{
		//generic datas 
		Item data;
		// to link next node
		Node<Item> next;
	}
	
	public myStack(){
		// to make first node null when stack is created
		first = null;
		count = 0;
	}

	
	public Node<Item> getFirst() {
		// returning first element of the stack
		return first;
	}


	public boolean isEmpty() {
		if(first == null) {
			// if there is no first element means that the stack is empty
			return true;
		}
		else {
			return false;
		}
		// means if the first item is null the stack is empty
	}


	public int size() {
		//  Since we have count var that holds  data of count of the elements it is enough to return it.
		return count;
	}

	public Item pop(){
		
		if(!isEmpty()) {
			//to get first item in the stack
			Item top = first.data;
			// Since we are removing first element of the stack the one under it must be the new first.
			first = first.next;
			//Since one element has been removed we need to decrease count
			count--;
			return top;
		}
		else {
			// error message if  there is no element in the stack
			System.out.println("There is no item in the stack");
			return null;
		}
		
		
	}
	public void push(Item data) {
		
		// Creating first node to hold the recent data and making it first element of the stack
		Node<Item>  recent = new Node<Item>();
		recent.data = data;
		
		if(isEmpty()) {
			first = recent;
			
		}
		else {
			// creating a node in order to keep the previous first	
			Node<Item> temp = first;
			first = recent;
			first.next = temp;
	
		}
		// increasing count since one has been added
		count++;
	}
	
	
	// Since there is a possbility that stack may be empty, if there is no element in stack we are priting an error message. Otherwise we are returnin first item in the stack without removeing it
	public Item peek() {
		if(isEmpty()) {
			System.out.println("No item in the stack");
			return null;
		}
		else {
			return first.data;
		}
		
	}
	
	
	








}
