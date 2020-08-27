package TelephoneBook;

public class Address {
	
	//Setting Variables
	private String address;
	private String city;
	private String state;
	private String zip;
	
	//This is where input is matched to the variables
	public Address (String address, String city, String state, String zip) {
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	
	//This method prints the Address
	public void printAddress() {
		System.out.println(address + " " + city + " " + state + " " + zip);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}