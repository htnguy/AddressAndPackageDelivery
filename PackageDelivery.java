package cecs220HW3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PackageDelivery {
	
	// creating one object method
	public static Package createPackage() {
		// Variables
				Random rand = new Random();
				String street, city, state, shippingMethod;
				int zip, i;
				double weight;
				Package.Shipping method = Package.Shipping.Ground;
				Scanner scan  = new Scanner(System.in);
		// getting weight
				System.out.println("Enter the weight: ");
				weight = scan.nextDouble();
				scan.nextLine();
		// getting shipping method
				System.out.println("Enter the shipping method(Ground, Air, Sea), if no shipping method is entered the default is Ground: ");
				try {
					shippingMethod = scan.nextLine();
					// if the user enter some value 
					if(!shippingMethod.isEmpty()) {
						// the value assigned is unpredictable since java is case sensitive, the user might enter
						// the wrong value that does not correspond to a specific enum constant
						// hence this will prompt an exception that will be handled by the catch
						method = Package.Shipping.valueOf(shippingMethod);
					}
				}
				catch(Exception a){
						// Reminding the user to enter the value as specified.
						System.out.println("Please enter one of the following(case sensitive): Ground, Air, Sea");
						shippingMethod = scan.nextLine();
						if(!shippingMethod.isEmpty()) {
							method = Package.Shipping.valueOf(shippingMethod);
						}
				}
				finally {
						// if assignment was successful or the user entered nothing
						System.out.println("Shipping method recieved: " + method.name());
				}
					
					// getting street, city, state, and zip
					System.out.println("Enter the street address: ");
					street = scan.nextLine();
					System.out.println("Enter the city: ");
					city = scan.nextLine();
					System.out.println("Enter the state: ");
					state = scan.nextLine();
					System.out.println("Enter the Zip Code: ");
					zip = scan.nextInt();
					scan.nextLine();
					// initializing a new Address object
					Address destination = new Address(street, city, state, zip);
					// initializing a new Package object with the Address object passed as a parameter to the constructor
					Package Package = new Package(weight, method, destination);
					// generate random ID
					Package.GenerateID(rand);
					// returning Package object
					return Package;
	}
	// method for displaying each package's information
	public static void  displayPackages(ArrayList <Package> packages) {
	 int i;
	 for(i = 0 ; i< packages.size(); i++) {
		 System.out.println(packages.get(i).toString());
	 }
	}
	// adding or removing package from the ArrayList of package
	public static ArrayList<Package> addOrRemove(ArrayList <Package> packages, String addOrRemove){
		Scanner scan = new Scanner(System.in);
		int packageIndex;

		if(addOrRemove.equals("add")) {
			packages.add(createPackage());
			displayPackages(packages);
		}else if(addOrRemove.equals("remove")) {
			System.out.println("Please enter the index that corresponds to the package to be removed: ");
			packageIndex = scan.nextInt();
			packages.remove(packageIndex);
			displayPackages(packages);
		}
		return packages;
	}
// main method
	public static void main(String[] args) {
		// Variables
		int nPackages,i;
		Scanner scan  = new Scanner(System.in);
		// Getting number of packages
		System.out.println("How many package do you want to deliver? ");
		nPackages = scan.nextInt();
		// Generating the appropriate number of references
		ArrayList<Package> packages = new ArrayList<Package>();
		// Loop to gather information and initialized package objects inside the array
		for(i = 0 ; i <nPackages; i++ ) {
			packages.add(createPackage());
		}
		// displaying package information
		displayPackages(packages);
		
		// adding and removing Package
		String addOrRemove;
		System.out.println("Do you want to add or remove package, enter 'add' , 'remove', or 'no'");
		scan.nextLine();
		addOrRemove = scan.nextLine();
		while(!addOrRemove.equals("no")) {
			addOrRemove(packages, addOrRemove);
			System.out.println("Add or Remove another package? enter 'add', 'remove', or 'no': ");
			addOrRemove = scan.nextLine();
		}
	System.out.println("Thank you for using our delivery service!");
	}

}
