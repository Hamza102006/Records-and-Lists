/**
 * 
 */

/**
 * Author: Hamza Khan 
 * Date; November 14, 2023
 * Desc. Represents objects containing student academic  records 
 */
public class StudentRecord {

	/**
	 * Instantaneous  Data 
	 */
	
	private String studentName;
	private String address;
	private String studentID;
	private double average;
	
	
	public StudentRecord() {
		// TODO Auto-generated constructor stub
		//intialize 
		this.studentName = "";
		this.address = "";
		this.studentID = "";
		this.average = 0;
		
			
	}
	

	/**
	 * @return the studentName
	 */
	public String getStudentName() {
		return studentName;
	}

	/**
	 * @param studentName the studentName to set
	 */
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the studentID
	 */
	public String getStudentID() {
		return studentID;
	}

	/**
	 * @param studentID the studentID to set
	 */
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	/**
	 * @return the average
	 */
	public double getAverage() {
		return average;
	}

	/**
	 * @param average the average to set
	 */
	public void setAverage(double average) {
		this.average = average;
	}

	/*
	 * String representaion of the object 
	 */
	
	@Override
	public String toString() {
		return "StudentRecord [studentName=" + studentName + ", address=" + address + ", studentID=" + studentID
				+ ", average=" + average + "]";
	}

	
	
	
	
	/*
	 * Method to process my record 
	 */
	
	// Record format; First Name Last Name, Student ID, 35 Daviselm dr., 89
	public void processRecord (String record) {
		String word[];
		word = record.split(","); //splits the record in to elements 
		this.studentName = word[0];
		this.studentID = word[1];   // asign the elements into diffre private data
		this.address = word[2];
		this.average = Double.parseDouble(word[3]);
		
	}
	
	
	public static void main(String[] args) {
		//create an object based on a record 
		String rec = "Tony Campos,P012345, 45 Daviselm dr., 99";
		
		
		//create object 
		StudentRecord info = new StudentRecord(); //test teh constucotr 
		
		//test toString
		System.out.println(info.toString());
		
		info.processRecord(rec);//test teh record data 
		
		System.out.println(info.toString()); //test with data

		//test the setters and getters
		info.setStudentName("Mr.Gupta");
		info.setAddress("The Galaxy, 23 Saturn way");
		info.setStudentID("123456");
		info.setAverage(65.2);
		
		//display  
		System.out.println(info.toString()); //test with data
		
		//test the getters
	
		System.out.println(info.getStudentName()); //test with data
		System.out.println(info.getStudentID()); //test with data
		System.out.println(info.getAddress()); //test with data
		System.out.println(info.getAverage()); //test with data

		
	}

}
