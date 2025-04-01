//name : yaman lutfi abu jazar
//id : 1212199
//lab section : 6
package application;

import java.util.Date;

public class PizzaOrder implements Comparable<PizzaOrder>{
	
	final static int SMALL = 1 , MEDIUM = 2 , LARGE = 3;
	//declaring the attributes of PizzaOrder class
	protected String customerName;
	protected Date dateOrder = new Date();
	protected int pizzaSize;
	protected int numberOfToppings;
	protected double toppingPrice;
	//a default constructor
	public PizzaOrder() {}
//non default constructor
	public PizzaOrder(String customerName,int pizzaSize, int numberOfToppings, double toppingPrice) {
		super();
		this.customerName = customerName;
		this.pizzaSize = pizzaSize;
		this.numberOfToppings = numberOfToppings;
		this.toppingPrice = toppingPrice;
	}
//getters and setters for PizzaOrder class
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Date dateOrder) {
		this.dateOrder = dateOrder;
	}

	public int getPizzaSize() {
		return pizzaSize;
	}

	public void setPizzaSize(int pizzaSize) {
		this.pizzaSize = pizzaSize;
	}

	public int getNumberOfToppings() {
		return numberOfToppings;
	}

	public void setNumberOfToppings(int numberOfToppings) {
		this.numberOfToppings = numberOfToppings;
	}

	public double getToppingPrice() {
		return toppingPrice;
	}

	public void setToppingPrice(double toppingPrice) {
		this.toppingPrice = toppingPrice;
	}

	public static int getSmall() {
		return SMALL;
	}

	public static int getMedium() {
		return MEDIUM;
	}

	public static int getLarge() {
		return LARGE;
	}
	//toString method 
	@Override
	public String toString() {
		if(pizzaSize==1)
			return "customerName = " + customerName + "\n\ndateOrder = " + dateOrder + "\n\npizzaSize = " + "small"
				+ "\n\nNumber of Toppings = " + numberOfToppings + "\n\nTopping Price = " + toppingPrice + "\n\nOrder Price = "
				+ calculateOrderPrice();
		else if(pizzaSize==2)
			return "customerName = " + customerName + "\n\ndateOrder = " + dateOrder + "\n\npizzaSize = " + "medium"
				+ "\n\nNumber of Toppings = " + numberOfToppings + "\n\nTopping Price = " + toppingPrice + "\n\nOrder Price = "
				+ calculateOrderPrice();
		else
			return "customerName = " + customerName + "\n\ndateOrder = " + dateOrder + "\n\npizzaSize = " + "large"
				+ "\n\nNumber of Toppings = " + numberOfToppings + "\n\nTopping Price = " + toppingPrice + "\n\nOrder Price = "
				+ calculateOrderPrice();
	}
	//method to calculate the price of an order
	public int calculateOrderPrice() {
		double price = numberOfToppings * toppingPrice * pizzaSize;
		return (int)price;
	}
	//method to print the information of the order such name and order price
	public void printOrderInfo() {
		System.out.println(customerName + "\t"+calculateOrderPrice());
	}
//method to compare two pizza orders based on their prices
	public int compareTo (PizzaOrder z){
		if (calculateOrderPrice() > z.calculateOrderPrice())
			return 1 ;
		else if (calculateOrderPrice() < z.calculateOrderPrice())
			return -1 ;
		else 
			return 0 ;
	}
}

