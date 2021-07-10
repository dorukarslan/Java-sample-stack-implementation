//----------------------------------------------------- 
// Title: Linked list, STACK, QUEUE
// Author: Doruk Arslan
// Description: This class is uses for creating a stack which can be oparated by the user's commands.The stack holds data about the serial number countr name and number  of vaccines. 
//-----------------------------------------------------





import java.util.Scanner;

public class VaccineStock {
	
	
	private int serialNumber;
	private String countryName;
	private int numberOfVaccines;
	
	
	// in order to keep vaccineStock objects in the firstStock object that we created at line 71, we implement a stack of type vaccineStock
	private myStack<VaccineStock> stockStack;
	// Constructor to initilizae the stack which will hold the items.
	public VaccineStock() {
		stockStack = new myStack<VaccineStock>();
		
	}
	// related getters/setters to oparate the private variables
	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public int getNumberOfVaccines() {
		return numberOfVaccines;
	}

	public void setNumberOfVaccines(int numberOfVaccines) {
		this.numberOfVaccines = numberOfVaccines;
	}

	
	
	public void popItem() {
		// check that if the stack of the object is empty or not.Hence,  got if statements for diverse operations.
		if(!stockStack.isEmpty()) {
			// to print the information of the item that removed from the stack
			System.out.println(stockStack.peek().serialNumber+", "+stockStack.peek().countryName + ", " + stockStack.peek().numberOfVaccines);
			//in order to pop it, we need to call pop method that we implement in myStack class.
			// Which means that after we create the first VaccineStock object we operate the pop and push operations in stockStack stack and since it derived from the myStack class, we call the 'pop' method from myStack class.
			stockStack.pop();
			
		}
		else {
			//Since the stack is empty we can not pop an element therefore we are priting an error message
			System.out.println("there is no element in the stack");
		}
		
	}
	public void pushItem(VaccineStock vac) {
		// we gave the intended data that we want to push into stack as argument and perform the operation on stockStack stack.
		stockStack.push(vac);
			
	}
	// to get input from the user we are returning diverse numbers depending on the inputs and we will use those numbers as cases in switch case statment.
	public int Action() {
		Scanner key = new Scanner(System.in);
		System.out.println("Enter COMMAND(ADD/DELETE/EXIT)?");
		String input = key.nextLine();
		
		if(input.equals("ADD")) {
			return 0;
		}
		if(input.equals("DELETE")) {
			return 1;
		}
		else{
			return 2;
		}
	}
	
	
	
	
	public static void main(String[] args) {
		
		VaccineStock firstStock = new VaccineStock();
		// we created first VaccineStock object which well keep other vaccineStock objects on its stockStack stack.
		
		
		Scanner key = new Scanner(System.in);
		
		boolean flag = true;
		// in order to end the loop when user performes EXIT operation we control the loop via bool variable.
		int serial;
		String country;
		int number;
		// to keep input datas
		while(flag) {
			
			
			
			
			
			// we will chose the appropriate operations from imput via switch case statement.
			// In switch case statements we are using return type of Action method for the diverse cases
			switch(firstStock.Action()) {
			
			
				case 0:
					
					System.out.println("Enter ITEM DATA ");
					serial = key.nextInt();
					country = key.next();
					number = key.nextInt();
					// first we scan the inputs and assagin those values to serial contry number variables.
					VaccineStock vaccine = new VaccineStock();
					vaccine.setSerialNumber(serial);
					vaccine.setCountryName(country);
					vaccine.setNumberOfVaccines(number);
					// with scanned values we create diverse vaccineStock objects and push them to stack that in the firstStock object.
					firstStock.pushItem(vaccine);
					//to push item to stack.
					break;
				
				
				case 1:
					//  Since we already satisfied intended opearitons inside the method we only need the call popItem method.
					firstStock.popItem();
					
					break;
					
					
				
				case 2:
					
					for(int i=0;i<firstStock.stockStack.count;i++) {
						// in order to pop whole the items consider the for loop via the count variable that we declared in the myStack class.
						// since loop will continue until i= stockStack.count() of the firstStock object we get the intended result.(For ex  if count is  equal to 2 loop will perform two time as i=0 and i=1 and the pop operation will occur twice.)
						// 
						firstStock.popItem();
					}
					// to terminate the loop
					flag = false;
					break;
				}
		}
		
	}
		
	
	
	
	
	

}
