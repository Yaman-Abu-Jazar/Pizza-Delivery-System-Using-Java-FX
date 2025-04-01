//name : yaman lutfi abu jazar
//id : 1212199
//lab section : 6
package application;

public class Delivery extends PizzaOrder{
	//the attributes of the Delivery class
	private double tripRate;
	private int zone;
	//default constructor for Delivery class
	public Delivery() {}
	//non default constructor for Delivery class
	public Delivery(String customerName,int pizzaSize, int numberOfToppings, double toppingPrice, double tripRate, int zone) {
		super(customerName,pizzaSize,numberOfToppings,toppingPrice);
		this.tripRate = tripRate;
		this.zone = zone;
	}
//getters and setters for Delivery class
	public double getTripRate() {
		return tripRate;
	}

	public void setTripRate(double tripRate) {
		this.tripRate = tripRate;
	}

	public int getZone() {
		return zone;
	}

	public void setZone(int zone) {
		this.zone = zone;
	}
	//toString method that overrides the method in PizzaOrder class
	public String toString() {
		if(pizzaSize==1)
		return "customerName = " + customerName + "\n\ndateOrder = " + dateOrder + "\n\npizzaSize = " + "small"
				+ "\n\nNumber of Toppings = " + numberOfToppings + "\n\nTopping Price = " + toppingPrice 
				+ "\n\ntripRate = " + tripRate + "\n\nzone = " + zone + "\n\nOrder Price = " + calculateOrderPrice();
		else if(pizzaSize==2)
			return "customerName = " + customerName + "\n\ndateOrder = " + dateOrder + "\n\npizzaSize = " + "medium"
					+ "\n\nNumber of Toppings = " + numberOfToppings + "\n\nTopping Price = " + toppingPrice 
					+ "\n\ntripRate = " + tripRate + "\n\nzone = " + zone + "\n\nOrder Price = " + calculateOrderPrice();
		else
			return "customerName = " + customerName + "\n\ndateOrder = " + dateOrder + "\n\npizzaSize = " + "large"
					+ "\n\nNumber of Toppings = " + numberOfToppings + "\n\nTopping Price = " + toppingPrice 
					+ "\n\ntripRate = " + tripRate + "\n\nzone = " + zone + "\n\nOrder Price = " + calculateOrderPrice();
	}
//method to calculate the price if the order is with delivery
	@Override
	public int calculateOrderPrice() {
		double price = numberOfToppings * toppingPrice * pizzaSize;
		return (int)(price + ((tripRate/100) * price * zone));
	}
}
	

