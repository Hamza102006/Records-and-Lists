/**
 * 
 */

import javax.swing.JOptionPane;

/**
 * 
 */
public class StudentRecordList {

	/**
	 * Priavate Instance varible /attirbutes 
	 */
	
	private StudentRecord list []; //list of studentrecord object 
	private int maxSize; // the maximum number of records the list can move
	private int size; //the actual usable size
	
	//Default Constuctor  
	public StudentRecordList() {
		this.maxSize = 10;
		this.list = new StudentRecord [maxSize];
		this.size = 0;   
	}

	
	/*
	 * Method to insert a record into the list 
	 * checks if the list is below the maxSize
	 * if so, it increases the size by 1 
	 * and adds the record to the location just below the size
	 * returns true of succesful 
	 */
	
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}


	public boolean insert(StudentRecord record) {
		//if the size is below maxSize
		if (size < maxSize) {
			size++;//increae by 1 
			list [size -1] = record; //add to the record 
			return true; 
		}
		return false;
	}
	
	
	/*
	 * Method to delete a record from the valid list
	 * Cheats the delete by replacing the record to be deleted to be deleted with the last record on the list 
	 * Then is decreases the size of the valid  list. Return true if the scucesful 
	 */
	
	public boolean delete (StudentRecord record) {
		//find the record by using a loop 
		for (int i = 0; i < this.getSize(); i++) {
			//check if the record is found 
			if (list[i].getStudentName().equalsIgnoreCase(record.getStudentName())) {
				list[i] = list [size-1]; //copy the last record to the one to be deleted
				size--; //decrease the valid list size
				return true;

			}
		}
		return false; //record not found 
	}
	
	
	/*
	 * Method to change
	 * delete the old record 
	 * insert a new record 
	 */
	
	public boolean change (StudentRecord oldR, StudentRecord newR) {
		if (delete(oldR)) {
			insert(newR);
			return true; //insert new record cuz old was found 
		}
		return false; //old record not found 
	}
	
	
	
	/*
	 * toString method to convert the list to to a string 
	 */
	
	public String toString() {
		String theList = "";
		for (int i = 0; i < this.getSize(); i++ ) {
			theList = theList + "Record " + i + ":" + list[i].toString() + "\n";
		}
		return theList;

	}
	
	//bubble sort method to sort by name in alpha order
	
	public void bubbleSort () {
		//loop to control how many times we pass through the list 
		for (int i = 0; i < size; i++) {
			//for loop to control the compartions 
			for (int j = 0; j < size - 1; j++) {
				//compare 
				if (list[j].getStudentName().compareToIgnoreCase(list[j+1].getStudentName()) > 0) {
					//out of order
					StudentRecord temp; //declares a temoprary student record 
					//swaps the elements
					temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
				} //ends if
			} //ends j loop 
		} //ends the i loop 
	}
	
	//binary search method 
	
	public int binarySearch(String searchKey) {
		int low = 0;
		int high = size -1;
		int middle;
		
		//while low is below the high value 
		while (low <= high) {
			middle = (high + low) / 2; //divide the array 
			if (searchKey.compareToIgnoreCase(list[middle].getStudentName()) == 0){
				return middle; //found it!
			}
			//search key is lower in alphabet 
			else if (searchKey.compareToIgnoreCase(list[middle].getStudentName()) < 0) {
					high = middle -1; //change the high end of the list 
			}
			
			else {
				low = middle + 1; //change the low end of the list 
			}
		}
		return -1; //name(searchKay) Not Found!!!!!!!!!!
	}
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StudentRecordList students = new StudentRecordList();
		
		//infinite loop for testing 
		while(true) {
			char command;
			command = JOptionPane.showInputDialog(null,
					"i - Insert\n" + "p - Print\n" + "d - Delete\n" + "c - Change\n" +
					"q - Quit\n" + "S - BubbleSort\n" + "B - BinarySearch", "i").charAt(0);
					
			if (command == 'q') {
				break; //break out of the loop 
			}
			switch (command) {
			case 'i': { //inserting test 
				
				//
				String record = JOptionPane.showInputDialog(null, "Enter <name, Id, Address, Average", 
						"Tony Campos, p001, 45 D, 90");
				
				//create a student record object 
				
				StudentRecord info = new StudentRecord();
				
				info.processRecord(record);
				
				if (students.insert(info)) { //insert 
					JOptionPane.showMessageDialog(null, "Insert Succesfull");
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Insert NOT Succesfull");

				}
				break;
				
			}
			
			case 'd': {
				String record = JOptionPane.showInputDialog(null, "Enter <name, Id, Address, Average", 
						"Tony Campos, p001, 45 D, 90");
				
				//create a student record object 
				
				StudentRecord info = new StudentRecord();
				
				info.processRecord(record);
				
				if (students.delete(info)) {
					JOptionPane.showMessageDialog(null, "Record Deleted");
				}
				else {
					JOptionPane.showMessageDialog(null, "Record Deleted");

				}
				break;
			}
			
			case 'c': {
				String oldRecord = JOptionPane.showInputDialog(null, "Enter <name, Id, Address, Average", 
						"Tony Campos, p001, 45 D, 90");
				
				//create a student record object 
				
				StudentRecord oldInfo = new StudentRecord();
				
				oldInfo.processRecord(oldRecord);
				
				
				String newRecord = JOptionPane.showInputDialog(null, "Enter <name, Id, Address, Average", 
						"Tony Campos, p001, 45 D, 90");
				
				//create a student record object 
				
				StudentRecord newInfo = new StudentRecord();
				
				newInfo.processRecord(newRecord);
				
				

				if (students.change(oldInfo, newInfo)) {
					JOptionPane.showMessageDialog(null, "Record Changed");
				}
				else {
					JOptionPane.showMessageDialog(null, "Record NOT Changed/ WAS NOT FOUND");

				} 
				
				break;
				
			}
			
			
			case 'p': {
				JOptionPane.showMessageDialog(null, students.toString());
			}
			
			case 'S':{
				students.bubbleSort();
				break;
			}
			
			case 'B':{
				String nameToFind = JOptionPane.showInputDialog(null, "Please enter Name to Find");
				int location = students.binarySearch(nameToFind);
				
				//check if found 
				if (location >= 0) {
					JOptionPane.showMessageDialog(null, nameToFind + " Found!");
				}
				
				else {
					JOptionPane.showMessageDialog(null, nameToFind + " NOT Found!");

				}
				break;
			}
			
			
			
			}
		}
		
		
	}

}
