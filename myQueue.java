//----------------------------------------------------- 
// Title: Linked list, STACK, QUEUE
// Author: Doruk Arslan
// Description: This class is uses for creating a generic queue with considering resizing array approach
//-----------------------------------------------------
import java.util.Scanner;

public class myQueue<Item> {
	
	// to keep first and last items top and end variables will be used
	// count variable holds number of elements in the item typed Array and also  int the array we are holding indexes of first and last elements via indexOftop and indexOfEnd
	private Item top;
	private Item end;
	private int count;
	private Item[] array;
	private int indexOfTop;
	private int indexOfEnd;
	
	// consturctor to initiliza variables,
	public myQueue() {
		count = 0;
		array =(Item[]) new Object[2];
		indexOfTop = 0;
		indexOfEnd = 0;
		
	}
	
	
	// to check if there is an element in the queue or not
	public boolean isEmpty() {
		if(count == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	// to check wheter the count of the elements in the array is equal to the length of the aray  
	public boolean isFull() {
		if(array == null) {
			
			return false;
		}
		else {
			if(count ==array.length) {
			return true;
		}
		else {
			return false;
		
		}
}
		
	}
	//  to show how many elements is in the queue.Since we hold this value via variable count, it is sufficent to return it.
	public int size() {
		return count;
	}
	
	// to add an item to the queue
	public void enqueue(Item item) {
		
		if(isFull()) {
			// since cannot create a generic array we need to show type inside parantesis
			
		 Item tempArray[] = (Item[])new Object[count*2];
		 
		 // to copy all inside a loop
		 for(int i = 0; i<count;i++) {
			// we are putting all datas of array inside tempArray
			 tempArray[i] = array[(indexOfTop+i)% array.length];
			 //  since the queue does not have to start from index 0 of the array(due to dequeue opperations that may be performed) we need to copy elements start from the index of the top of queue (first element of the array) instead of index 0 of the array
			 //  Moreover, there might be some elements(such as en of the queue) that are located in previous indexs from the top element. In order to also copy them to array we are using % operation
			 //  in order to find index of the first element (top) of the queue we are using indexTop() method
			 
			 
		 }
		 // to assagin temp Array to our orginal array
		  	array = tempArray;
		  	// since we have a new index we can automaticly assagin 0 to index of t the  top element and capacity of the array to the last object
		  	indexOfTop = 0;
		  	indexOfEnd = count;
		}
		// to assaign the item to the available index of the array that held by variable indexOfEnd
		// Since we addded new item we are also incresing indexOfEnd and count variables  by 1
		// since it is the last item that added to queue we are assignin its value to the varaible end 
		
		array[indexOfEnd] = item;
		indexOfEnd += 1;
		count ++;
		end = item;
		
		
		
		
	
		
	}
	// To find top elements index
	public void indexTop() {
		//to do that we are travelling on the array and when we encounter with top element of the array we are assigning it's index to the indexOfTop variable.
		for(int i = 0; i<array.length; i++) {
			if(array[i]== top) {
				indexOfTop = i;	
			}
			
		}
		
		
	}
	
	
	public Item dequeue () {
		if(!isEmpty()) {

			// to remove first item in the array and make it's index null
			Item oldTop = array[indexOfTop];
			array[indexOfTop] = null;
			// since we removed one we need to alter indexofTop and count
			indexOfTop +=1;
			top = array[indexOfTop];
			count --;
			
			//also there is a possibility that first elemnt may be at the end of the array. If we consider this case, when we dequeue we need to make indexofTop as zero to satisfy the intended condition
			if(indexOfTop == array.length) {
				indexOfTop = 0;
			}
			
			// in order to make resizing array operation, after removing one element, we need to check wheter the lenght of array is equal to 4 times count.
			if(count == array.length/4) {
				// for an efficient design we need to create another  array that has halve of the size  when the count becomes 1/4 of the size
				Item tempArray[] = (Item[])new Object[array.length/2];
				
				for(int i = 0; i<count; i++) {
					// same operation mentioned in the enqueue operation for resizing array approach
					tempArray[i] = array[(indexOfTop+i)% array.length];
					
			}
				// since we have a new array we are assignin it to array and reseting our variables.
				array = tempArray;
				indexOfTop = 0;
				indexOfEnd = count;
				
			}
				
				
				return oldTop;
			}
			
		
		else {
			// to prit an error message if there is no element in the array
			System.out.println("No item in the queue");
			return null;
		}
		
	}
		
	// to return first element of the queue
	public Item peek() {
		return array[indexOfTop];
		
	}
	// to print all elements in the queue
	public void print() {
		// for the loop design we need to prin first element 
		System.out.println(top);
		
		// to control loop wheter we came to end of the elements or not 
		Item tempItem = end; 
		
		
		
		// a variable to travel on array which increasis by one in every itteration
		int counter = indexOfTop;	
		// we continue loop until finding the top element again.
		while(tempItem != top && tempItem != null) {
			
			// if  indexOfTop > indexOfEnd  and counter comes the end of the array. Means that in the previous dequeue operrations must occurred and we added some elmements to the indexex smaller than the first one's
			// in order to continue the loop we need to assign counter values to -1 and to lines later it will become 0 and we obtain the first index of the array.
			if(indexOfTop > indexOfEnd && counter == array.length) {
				counter = -1;
			}
			
			counter +=1;
			//  get items in order to print via variable counter 
			tempItem = array[counter];
			if(tempItem!= null) {
				// to print it if it is not null 
				System.out.println(tempItem);
			}
			
			
		}
		}

		
		
	

}
