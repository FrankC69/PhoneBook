package TelephoneBook;

import java.util.Scanner;

public class Directory {
	
	//Sets the Array
	Name[] nameArray = new Name[0];
	
	//This method add a new name to the directory
	public void addName(Name name) {
		Name[] tempArray = new Name[nameArray.length+1];
		for (int i=0; i < nameArray.length; i++) {
			//copy from nameArray into tempArray
			tempArray[i] = nameArray[i]; 
		}
		//adding all the variable from new name into the tempArray
		tempArray[tempArray.length-1] = name;
		//copy from tempArray back to nameArray
		nameArray = tempArray;
	}

	//This method prints the entire directory
	public void printAll( ) {
		for (int i=0; i < nameArray.length; i++) {
			nameArray[i].printName();
		}
	}
	
	//This method will delete a name from the directory
	public void deleteName(Name name) {
		Name[] tempArray = new Name[nameArray.length-1];
		int j = 0;
		for (int i=0; i < nameArray.length; i++) {
			if (name != nameArray[i]) {
				tempArray[j] = nameArray[i];
				j++;
			}				
		}
		//copy from tempArray back to nameArray
		nameArray = tempArray;
	}

	//CALLED in from Application Case 2
	//This method searches through first names
	public void searchFirstName(String firstName) {
		//this part counts the number of names matching the search criteria
		int count = 0;
		for (int i=0; i < nameArray.length; i++) {
			//(firstName) is what the user is searching for
			//getting the firstName from the nameArray in this class
			if (nameArray[i].getFirstName().equals(firstName)) {
				count++;
				}
			}
		
		//this part reruns through the directory after knowing how many names match
		//knowing the number means we can properly set the size of the Array
		Name[] matchArray = new Name[count];
		for (int i = 0; i < nameArray.length; i++) {
			if (nameArray[i].getFirstName().equals(firstName)) {
				nameArray[i].printName();
				}
			}
		if (matchArray.length > 0) {
		}
		else {
			System.out.println("No such first name.");
		}
	}
	
	//CALLED in from Application Case 3
	//This method searches through last names
	public void searchLastName(String lastName) {
		//this part counts the number of names matching the search criteria
		int count = 0;
		for (int i=0; i < nameArray.length; i++) {
			//(lastName) is what the user is searching for
			//getting the lastName from the nameArray in this class
			if (nameArray[i].getLastName().equals(lastName)) {
				count++;
				}
			}
		
		//this part reruns through the directory after knowing how many names match
		//knowing the number means we can properly set the size of the Array
		Name[] matchArray = new Name[count];
		for (int i = 0; i < nameArray.length; i++) {
			if (nameArray[i].getLastName().equals(lastName)) {
				nameArray[i].printName();
				}
			}
		if (matchArray.length > 0) {
		}
		else {
			System.out.println("No such last name.");
		}
	}

	//CALLED in from Application Case 4
	//This method searches through first and last names
	public void searchFullName(String firstName, String lastName) {
		//this part counts the number of names matching the search criteria
		int count = 0;
		for (int i=0; i < nameArray.length; i++) {
			//(lastName) is what the user is searching for
			//getting the lastName from the nameArray in this class
			if (nameArray[i].getFirstName().equals(firstName) && nameArray[i].getLastName().equals(lastName)) {
				count++;
				}
			}
		
		//this part reruns through the directory after knowing how many names match
		//knowing the number means we can properly set the size of the Array
		Name[] matchArray = new Name[count];
		for (int i = 0; i < nameArray.length; i++) {
			if (nameArray[i].getFirstName().equals(firstName) && nameArray[i].getLastName().equals(lastName)) {
				nameArray[i].printName();
				}
			}
		if (matchArray.length > 0) {
		}
		else {
			System.out.println("No such full name.");
		}
	}
	
	//CALLED in from Application Case 5
	//This method searches through telephone numbers
	public Name searchPhoneNumber(String phoneNumber) {
		for (int i = 0; i < nameArray.length; i++) {
			if (nameArray[i].getPhoneNumber().equals(phoneNumber)) {
				nameArray[i].printName();
				return nameArray[i];
				}
			}
		return null;
	}
	
	//CALLED in from Application Case 6
	//This method searches through city and state
	public void searchCityState(String city, String state) {
		//this part counts the number of names matching the search criteria
		int count = 0;
		for (int i=0; i < nameArray.length; i++) {
			//(lastName) is what the user is searching for
			//getting the lastName from the nameArray in this class
			if (nameArray[i].getAddress().getCity().equals(city) && nameArray[i].getAddress().getState().equals(state)) {
				count++;
				}
			}
		
		//this part reruns through the directory after knowing how many cities and states match
		//knowing the number means we can properly set the size of the Array
		Name[] matchArray = new Name[count];
		for (int i = 0; i < nameArray.length; i++) {
			if (nameArray[i].getAddress().getCity().equals(city) && nameArray[i].getAddress().getState().equals(state)) {
				nameArray[i].printName();
				}
			}
		if (matchArray.length > 0) {
		}
		else {
			System.out.println("No one with that city and state.");
		}
	}
	
	public void editCustomer(Name name) {
		int update = 0;
		String newFirstName;
		String newMiddleName;
		String newLastName;
		String newAddress;
		String newCity;
		String newState;
		String newZip;
		String newPhone;
		Scanner scan = new Scanner(System.in);
		Scanner scanInt = new Scanner(System.in);
		
		do {
		System.out.println("Please enter the number of the information would you like to edit?");
		System.out.println("1) First Name. ");
		System.out.println("2) Middle Name. ");
		System.out.println("3) Last Name. ");
		System.out.println("4) Street Address. ");
		System.out.println("5) City. ");
		System.out.println("6) State. ");
		System.out.println("7) Zip Code. ");
		System.out.println("8) Telephone Number. ");
		System.out.println("9) Finished editting.");
		
		update = scanInt.nextInt();

		switch (update) {
		case 1:
			System.out.println("What is the new first name?");
			newFirstName = scan.next();
			name.setFirstName(newFirstName);
		case 2: 
			System.out.println("What is the new middle name?");
			newMiddleName = scan.next();
			name.setMiddleName(newMiddleName);
		case 3:
			System.out.println("What is the new last name?");
			newLastName = scan.next();
			name.setLastName(newLastName);
		case 4:
			System.out.println("What is the new street address?");
			newAddress = scan.next();
			name.getAddress().setAddress(newAddress);
		case 5:
			System.out.println("What is the new city?");
			newCity = scan.next();
			name.getAddress().setCity(newCity);
		case 6:
			System.out.println("What is the new state?");
			newState = scan.next();
			name.getAddress().setState(newState);
		case 7:
			System.out.println("What is the new zip code?");
			newZip = scan.next();
			name.getAddress().setZip(newZip);
		case 8:
			System.out.println("What is the new phone number?");
			newPhone = scan.next();
			name.setPhoneNumber(newPhone);
		case 9:
			System.out.println("You have chosen to leave the editting part of this program.");
			}
		}
		//the program will exit the loop if the user inputs a 0
		while (update != 9);
	}
}