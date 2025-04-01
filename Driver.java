//name : yaman lutfi abu jazar
//id : 1212199
//lab section : 6
package application;
import java.util.ArrayList;
import java.util.Collections;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Driver extends Application {
// ArrayList to store all the orders
private ArrayList<PizzaOrder> orders = new ArrayList<>();

private Label customerNameLabel = new Label("Customer Name:");
private TextField customerNameField = new TextField();
private Label orderTypeLabel = new Label("Order Type:");
private ToggleGroup orderTypeGroup = new ToggleGroup();
private RadioButton toGoRadio = new RadioButton("ToGo");
private RadioButton deliveryRadio = new RadioButton("Delivery");
private RadioButton seatedRadio = new RadioButton("Seated");
private Label pizzaSizeLabel = new Label("Pizza Size:");
private ComboBox<String> pizzaSizeCombo = new ComboBox<>();
private ObservableList<String> pizzaSizeOptions = FXCollections.observableArrayList("Small", "Medium", "Large");
private Label toppingsLabel = new Label("Toppings:");
private CheckBox onionCheck = new CheckBox("Onions");
private CheckBox oliveCheck = new CheckBox("Olives");
private CheckBox greenPepperCheck = new CheckBox("Green Peppers");
private Label toppingPriceLabel = new Label("Topping Price:");
private TextField toppingPriceField = new TextField();
private Label orderPriceLabel = new Label("Order Price:");
private TextField orderPriceField = new TextField();
private Label tripRateLabel = new Label("Trip Rate:");
private TextField tripRateField = new TextField();
private Label zoneLabel = new Label("Zone:");
private TextField zoneField = new TextField();
private Label serviceChargeLabel = new Label("Service Charge:");
private TextField serviceChargeField = new TextField();
private Label numberOfPeopleLabel = new Label("Number of People:");
private TextField numberOfPeopleField = new TextField();

private Button processOrderButton = new Button("Process Order");
private Button printOrdersButton = new Button("Print Orders");
private Button resetButton = new Button("Reset");

@Override
public void start(Stage primaryStage) {
  // Initialize the pizza size ComboBox
  pizzaSizeCombo.setItems(pizzaSizeOptions);
  pizzaSizeCombo.getSelectionModel().selectFirst();
  // Set the toggle group for the order type RadioButtons
  toGoRadio.setToggleGroup(orderTypeGroup);
  deliveryRadio.setToggleGroup(orderTypeGroup);
  seatedRadio.setToggleGroup(orderTypeGroup);
  
  

  // Create a HBox for the order type RadioButtons
  HBox orderTypeBox = new HBox(10, toGoRadio, deliveryRadio, seatedRadio);
  orderTypeBox.setAlignment(Pos.CENTER_LEFT);

  // Create a GridPane for the order form
  GridPane form = new GridPane();
  form.setAlignment(Pos.CENTER);
  form.setPadding(new Insets(20, 20, 20, 20));
  form.setHgap(10);
  form.setVgap(10);

  // Add the components to the GridPane
  form.add(customerNameLabel, 0, 0);
  form.add(customerNameField, 1, 0);
  form.add(orderTypeLabel, 0, 1);
  form.add(orderTypeBox, 1, 1);
  form.add(pizzaSizeLabel, 0, 2);
  form.add(pizzaSizeCombo, 1, 2);
  form.add(toppingsLabel, 0, 3);
  form.add(onionCheck, 1, 3);
  form.add(oliveCheck, 1, 4);
  form.add(greenPepperCheck, 1, 5);
  form.add(toppingPriceLabel, 2, 3);
  form.add(toppingPriceField, 3, 3);
  form.add(orderPriceLabel, 2, 4);
  form.add(orderPriceField, 3, 4);
  form.add(tripRateLabel, 2, 5);
  form.add(tripRateField, 3, 5);
  tripRateLabel.setVisible(false);
  tripRateField.setVisible(false);
  form.add(zoneLabel, 2, 6);
  form.add(zoneField, 3, 6);	
  zoneLabel.setVisible(false);
  zoneField.setVisible(false);
  form.add(serviceChargeLabel, 2, 6);
  form.add(serviceChargeField, 3, 6);
  serviceChargeLabel.setVisible(false);
  serviceChargeField.setVisible(false);
  form.add(numberOfPeopleLabel, 2, 5);
  form.add(numberOfPeopleField, 3, 5);
  numberOfPeopleLabel.setVisible(false);
  numberOfPeopleField.setVisible(false);
  toGoRadio.setOnAction(event -> {
  	  // Show/hide the appropriate fields based on the selected order type
  	  tripRateLabel.setVisible(false);
  	  tripRateField.setVisible(false);
  	  zoneLabel.setVisible(false);
  	  zoneField.setVisible(false);
  	  serviceChargeLabel.setVisible(false);
  	  serviceChargeField.setVisible(false);
  	  // Show the number of people field
  	  numberOfPeopleLabel.setVisible(false);
  	  numberOfPeopleField.setVisible(false);
  	  });
  deliveryRadio.setOnAction(event -> {
	  // Show/hide the appropriate fields based on the selected order type
	  tripRateLabel.setVisible(true);
	  tripRateField.setVisible(true);
	  zoneLabel.setVisible(true);
	  zoneField.setVisible(true);
	  serviceChargeLabel.setVisible(false);
	  serviceChargeField.setVisible(false);
	  // Show the number of people field
	  numberOfPeopleLabel.setVisible(false);
	  numberOfPeopleField.setVisible(false);
	  });
  seatedRadio.setOnAction(event -> {
  	  // Show/hide the appropriate fields based on the selected order type
  	  tripRateLabel.setVisible(false);
  	  tripRateField.setVisible(false); 
  	  zoneLabel.setVisible(false);
  	  zoneField.setVisible(false);
  	  serviceChargeLabel.setVisible(true);
  	  serviceChargeField.setVisible(true);
  	  // Show the number of people field
  	  numberOfPeopleLabel.setVisible(true);
  	  numberOfPeopleField.setVisible(true);
  	  });
      processOrderButton.setOnAction(e -> {
      	  String customerName = customerNameField.getText();
      	  double toppingPrice = Double.parseDouble(toppingPriceField.getText());
      	  boolean hasOnion = onionCheck.isSelected();
      	  boolean hasOlive = oliveCheck.isSelected();
      	  boolean hasGreenPepper = greenPepperCheck.isSelected();
      	  int pizzaSize = 0;
      	  if ("Small".equals(pizzaSizeCombo.getValue())) {
      		  pizzaSize = 1;
      	  }
      	  else if ("Medium".equals(pizzaSizeCombo.getValue())) {
      		  pizzaSize = 2;
      	  }
      	  else if ("Large".equals(pizzaSizeCombo.getValue())) {
      		  pizzaSize = 3;
      	  }
      	  int numoftop=1;
      	  if(hasOnion==true)
      		  numoftop++;
      	  if(hasOlive==true)
      		  numoftop++;
      	  if(hasGreenPepper==true)
      		  numoftop++;
      	  PizzaOrder order;
      	  if (toGoRadio.isSelected()) {
      	    order = new ToGo(customerName, pizzaSize,numoftop, toppingPrice);
      	  } else if (deliveryRadio.isSelected()) {
      	    double tripRate = Double.parseDouble(tripRateField.getText());
      	    int zone = Integer.parseInt(zoneField.getText());
      	    order = new Delivery(customerName, pizzaSize,numoftop, toppingPrice, tripRate, zone);
      	  } else {
      	    double serviceCharge = Double.parseDouble(serviceChargeField.getText());
      	    int numberOfPeople = Integer.parseInt(numberOfPeopleField.getText());
      	    order = new Seated(customerName, pizzaSize,numoftop,toppingPrice, serviceCharge, numberOfPeople);
      	  }
      	  
      	  orders.add(order);
      	  orderPriceField.setText(String.valueOf( order.calculateOrderPrice()));
      	});





  // Code for the PrintOrders button
  printOrdersButton.setOnAction(e -> {
    // Sort the orders by oreder price
	Collections.sort(orders);
   
    // Create a new stage to display the order list
    Stage orderListStage = new Stage();
    orderListStage.setTitle("Order List");

    // Create a GridPane to display the order list
    GridPane orderList = new GridPane();
    orderList.setAlignment(Pos.CENTER);
    orderList.setPadding(new Insets(20, 20, 20, 20));
    orderList.setHgap(10);
    orderList.setVgap(10);

    // Add headers for the customer name and order price columns
    Label customerNameHeader = new Label("Customer Name");
    Label orderPriceHeader = new Label("Order Price");
    orderList.add(customerNameHeader, 0, 0);
    orderList.add(orderPriceHeader, 1, 0);

    // Add a row for each order with the customer name and order price
    int row = 1;
    for (PizzaOrder order : orders) {
      Label customerName = new Label(order.getCustomerName());
      Label orderPrice = new Label(String.valueOf(order.calculateOrderPrice()));
      orderList.add(customerName, 0, row);
      orderList.add(orderPrice, 1, row);
      row++;
    }

    // Show the order list stage
    Scene orderListScene = new Scene(orderList, 300, 300);
    orderListStage.setScene(orderListScene);
    orderListStage.show();
  });

  // Code for the Reset button
  resetButton.setOnAction(e -> {
    // Reset the customer name field
    customerNameField.clear();

    // Reset the order type radio buttons
    toGoRadio.setSelected(false);
    deliveryRadio.setSelected(false);
    seatedRadio.setSelected(false);

    // Reset the pizza size ComboBox
    pizzaSizeCombo.getSelectionModel().selectFirst();

    // Reset the toppings check boxes
    onionCheck.setSelected(false);
    oliveCheck.setSelected(false);
    greenPepperCheck.setSelected(false);

    // Reset the topping price field
    toppingPriceField.clear();

    // Reset the order price field
    orderPriceField.clear();

    // Reset the trip rate field
    tripRateField.clear();

    // Reset the zone field
    zoneField.clear();

    // Reset the service charge field
    serviceChargeField.clear();

    // Reset the number of people field
    numberOfPeopleField.clear();

    // Clear the orders ArrayList
    orders.clear();
    tripRateLabel.setVisible(false);
    tripRateField.setVisible(false); 
	zoneLabel.setVisible(false);
	zoneField.setVisible(false);
	serviceChargeLabel.setVisible(false);
	serviceChargeField.setVisible(false);
	numberOfPeopleLabel.setVisible(false);
	numberOfPeopleField.setVisible(false);
  });

  


  // Create a HBox for the buttons
  HBox buttons = new HBox(10, processOrderButton, printOrdersButton, resetButton);
  buttons.setAlignment(Pos.CENTER);

  // Add the form and buttons to the root pane
  form.add(buttons, 0, 8, 4, 1);

  
   
   

    // Show the scene
    Scene scene = new Scene(form, 800, 500);
    primaryStage.setScene(scene);
    primaryStage.show();
}
    public static void main(String[] args) {
  	    launch(args);
  	}
}


  
