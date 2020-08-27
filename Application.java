package TelephoneBook;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {

		int action = 0;
		String add;
		String fullName;
		String digits;
		String cityState;
		String rotary;
		Directory directory = new Directory();
		
		//two scanners to avoid programming bugs
		Scanner scan = new Scanner(System.in);
		Scanner scanInt = new Scanner(System.in);

		do {
			//Here is the setup and user choices
			System.out.println("Here is your phonebook.");
			System.out.println("What would you like to do?");
			System.out.println("1) Add a new customer.");
			System.out.println("2) Search for a customer by their first name.");
			System.out.println("3) Search for a customer by their last name.");
			System.out.println("4) Search for a customer by their first and last name.");
			System.out.println("5) Search for a customer by their phone number.");
			System.out.println("6) Search for a customer by city and state.");
			System.out.println("7) Delete a customer.");
			System.out.println("8) Update a customer's information.");
			System.out.println("9) List all records.");
			System.out.println("0) EXIT THE PHONEBOOK.");

			//User input
		    System.out.println("Please enter the number of the action you would like to perform: ");		    
			action = scanInt.nextInt();
			
			switch (action) {
			case 1:
				//Give feedback to the user about their choice
				System.out.println("You have chosen to add a new customer.");
				add = scan.nextLine();
				//Split is putting the user input into an array
				String[] split = add.split(", ");
				//Namesplit is breaking the name into first, middle and last name
				String[] namesplit = split[0].split(" ");
				String firstName = namesplit[0];
				String lastName = namesplit[namesplit.length-1];
				String middleName = "";
				for (int i=1; i < namesplit.length-1; i++) {
					middleName = middleName + namesplit[i] + " ";
				}
				//Split[1] = street address, Split[2] = city, Split[3] = state, Split[4] = zip code
				Address address = new Address (split[1], split[2], split[3], split[4]);
				//Split[5] is the telephone number
				Name name = new Name (firstName, middleName, lastName, address, split[5]);
				//This next line puts the information from the Name object into the directory
				directory.addName(name);
				break;
			case 2:
				System.out.println("You have chosen to search for a customer by their first name.");
				System.out.println("Who are you looking for?");
				firstName = scan.nextLine();
				directory.searchFirstName(firstName);
				break;
			case 3:
				System.out.println("You have chosen to search for a customer by their last name.");
				System.out.println("Who are you looking for?");
				lastName = scan.nextLine();
				directory.searchLastName(lastName);
				break;
			case 4:
				System.out.println("You have chosen to search for a customer by their first and last name.");
				System.out.println("Who are you looking for? Please enter ONLY their first and last name.");
				fullName = scan.nextLine();
				String[] splitter = fullName.split(" ");
				String oneName = splitter[0];
				String twoName = splitter[1];
				directory.searchFullName(oneName, twoName);
				break;
			case 5:
				System.out.println("You have chosen to search for a customer by their phone number.");
				System.out.println("Who are you looking for? Please enter ONLY the phone number. Do NOT use dashes or parentheses.");
				digits = scan.nextLine();
				directory.searchPhoneNumber(digits);
				break;
			case 6:
				System.out.println("You have chosen to search for a customer by their city and state.");
				System.out.println("Who are you looking for? Please enter ONLY their city and state.");
				cityState = scan.nextLine();
				String[] spliting = cityState.split(", ");
				String city = spliting[0];
				String state = spliting[1];
				directory.searchCityState(city, state);
				break;
			case 7:
				System.out.println("You have chosen to delete a customer.");
				System.out.println("Please enter the phone number of the customer you wish to delete.");
				System.out.println("Please enter ONLY the phone number. Do NOT use dashes or parentheses.");
				digits = scan.nextLine();
				Name deletion = directory.searchPhoneNumber(digits);
				System.out.println("Is this the customer you wish to delete? Y or N");
				char choice = scan.next().charAt(0);
				if (choice == 'Y') {
					directory.deleteName(deletion);
				}
				break;
			case 8:
				System.out.println("You have chosen to edit a customer.");
				System.out.println("Please enter the phone number of the customer you wish to edit.");
				System.out.println("Please enter ONLY the phone number. Do NOT use dashes or parentheses.");
				rotary = scan.nextLine();
				Name editing = directory.searchPhoneNumber(rotary);
				System.out.println("Is this the customer you wish to edit? Y or N");
				char choices = scan.next().charAt(0);
				if (choices == 'Y') {
					directory.editCustomer(editing);
				}
				break;
			case 9:
				//This next line calls to the Directory class and activates the printAll method
				directory.printAll();
				System.out.println();
				break;
			}
		}
		//the program will exit the loop if the user inputs a 0
		while (action != 0);
		
	    scan.close();
	    scanInt.close();
	}
}