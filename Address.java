package cecs220HW3;

public class Address {
	//instance variables
	private String streetAddress, city, state;
	private int zip;
	// constructor
	Address(String street, String city, String state, int zip){
		this.streetAddress= street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
	// Returns nicely formatted string including the address information
	public String toString() {
		String address = this.streetAddress + " " + this.city+ ", " + this.state +" " + this.zip; 
		return address;
	}
	
	
	
}
