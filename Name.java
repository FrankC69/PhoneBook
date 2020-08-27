package TelephoneBook;

public class Name {
	
	//set variables
	private String firstName;
	private String middleName;
	private String lastName;
	private Address address;
	private String phoneNumber;

	//This is where input is matched to the variables
	public Name (String firstName, String middleName, String lastName, Address address, String phoneNumber) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.address = address;
		this.setPhoneNumber(phoneNumber);
	}
	
	//this method prints the name, phone number and the address on the next line
	public void printName() {
		System.out.println(firstName + " " + middleName + " " + lastName + " " + phoneNumber);
		address.printAddress();	
	}	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	//Formatting a phone number
	public void setPhoneNumber(String phoneNumber) {
		String formattedNumber = "(" + phoneNumber.substring(0,3) + ")-" + phoneNumber.substring(3,6) + "-" + phoneNumber.substring(6);
		this.phoneNumber = formattedNumber;
	}
}