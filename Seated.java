//name : yaman lutfi abu jazar
//id : 1212199
//lab section : 6
package application;

public class Seated extends PizzaOrder{
	private double serviceCharge;
	private int numberOfPeople;
	//default constructor for Seated class
	public Seated() {}
	//non default constructor for Seated class
	public Seated(String customerName,int pizzaSize, int numberOfToppings, double toppingPrice, double serviceCharge, int numberOfPeople) {
		super(customerName,pizzaSize,numberOfToppings,toppingPrice);
		this.serviceCharge = serviceCharge;
		this.numberOfPeople = numberOfPeople;
	}
	//toString method for Seated class
	@Override
	public String toString() {
		if(pizzaSize==1)
		 return "customerName = " + customerName + "\n\ndateOrder = " + dateOrder + "\n\npizzaSize = " + "small"
				+ "\n\nNumber of Toppings = " + numberOfToppings + "\n\n Topping Price = " + toppingPrice 
				+ "\n\nService Charge = " + serviceCharge + "\n\nNumber of people = " + numberOfPeople + "\n\nOrder Price = " + calculateOrderPrice();
		if(pizzaSize==2)
			return "customerName = " + customerName + "\n\ndateOrder = " + dateOrder + "\n\npizzaSize = " + "medium"
					+ "\n\nNumber of Toppings = " + numberOfToppings + "\n\n Topping Price = " + toppingPrice 
					+ "\n\nService Charge = " + serviceCharge + "\n\nNumber of people = " + numberOfPeople + "\n\nOrder Price = " + calculateOrderPrice();
		else
			return "customerName = " + customerName + "\n\ndateOrder = " + dateOrder + "\n\npizzaSize = " + "large"
					+ "\n\nNumber of Toppings = " + numberOfToppings + "\n\n Topping Price = " + toppingPrice 
					+ "\n\nService Charge = " + serviceCharge + "\n\nNumber of people = " + numberOfPeople + "\n\nOrder Price = " + calculateOrderPrice();
	}
	//method to calculate the price if the order is with Seated
	@Override
	public int calculateOrderPrice() {
		double price = numberOfToppings * toppingPrice * pizzaSize;
		return (int)(price + (serviceCharge * numberOfPeople));
	}

}


