package cecs220HW3;

import java.text.NumberFormat;
import java.util.Random;

public class Package {
	// instance variable
	private int trackingId;
	private double weight;
	private double cost;
	private Shipping shippingMethod;
	enum Shipping{Air, Ground, Sea};
	private Address destination;
	// constructor
	Package(double weight, Shipping method, Address destination){
		this.cost = calculateCost(weight, method);
		this.shippingMethod = method;
		this.destination = destination;
		this.weight = weight; 
	}
	//calculating shipping cost
	public double calculateCost(double weight, Shipping method) {
		double cost=0;
		// for air shipping 
			if(method == Shipping.Air) {
				if(weight<=8 && weight>= 1) {
					cost = 4.0;
				}else if(weight<=16 && weight>=9) {
					cost = 6.0;
				}else if(weight>=17) {
					cost = 9.0;
				}
		// got ground shipping
			}else if(method== Shipping.Ground) {
				if(weight<=8 && weight>= 1) {
					cost = 1.8;
				}else if(weight<=16 && weight>=9) {
					cost = 2.8;
				}else if(weight>=17) {
					cost = 4.0;
				}
			}
		// for sea shipping	
			else if(method== Shipping.Sea) {
				if(weight<=8 && weight>= 1) {
					cost = 0.55;
				}else if(weight<=16 && weight>=9) {
					cost = 1.55;
				}else if(weight>=17) {
					cost = 2.00;
				}
			}
		return cost;
	}
	//Accessesors
	public double getWeight() {
		return this.weight;
	}
	public Shipping getShippingMethod() {
		return this.shippingMethod;
	}
	public Address getDestination() {
		return this.destination;
	}
	
	// Mutators
	public void changeWeight(double newWeight) {
		this.cost = calculateCost(newWeight, this.shippingMethod);	
	}
	public void changeShippingMethod(Shipping method) {
		this.cost = calculateCost(this.weight, method);
	}
	public void changeDestination(Address newDestination) {
		this.destination = newDestination;
	}
	// Random ID Generator
	public int GenerateID(Random rand) {
		int randomId =  100000 + rand.nextInt(900000);
		this.trackingId = randomId;
		return randomId;
	}
	// toString Method
	public String toString() {
		NumberFormat fm = NumberFormat.getCurrencyInstance();
		String packageInformation = "The package with ID: "+ this.trackingId+" that weighs " + this.weight+"oz will cause "
									+ fm.format(this.cost) + " to ship by "+ this.shippingMethod+ 
									" to the destination: "+ this.destination.toString();
		return packageInformation;
	}
}
