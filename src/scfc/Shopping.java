package scfc;

import java.util.HashMap;
/**
 * Description: 
 * Name: Shopping
 *
 * @author Kushal 
 * 14 October 2020 4:47 PM
 *
 */

public class Shopping {
 
	public static void main(String[] args) {
		/*
	 <-------------------Driver Code---------------------------->
		*/
		
		// Creating a database for items so that we can easily pass them as argument
		HashMap<Integer, Item> store = new HashMap<Integer, Item>();
		store.put(1, new Item(1, "Coco-Cola", "Soft drink", 50));
		store.put(2, new Item(2, "Keyboard", "mechanical", 150));
		store.put(3, new Item(3, "Usb Cable", "micro-typeC", 200));
		store.put(4, new Item(4, "Headphone", "Best sound", 5000));
		
		
		//creating a Shopping Cart object
		ShoppingCart cart = new ShoppingCart();
		
		
		//adding items in our cart using addToCart() function
		cart.addToCart(store.get(1), 3); // passing Item object and quantity we want in cart
		cart.addToCart(store.get(2), 5);
		cart.addToCart(store.get(3), 1);
		cart.addToCart(store.get(4), 1);
		
		
		// display all the items present in our cart
		cart.displayAllItems();
		
		
		//updating item in cart using updateQty() function
		cart.updateQty(store.get(1), 5);
		cart.updateQty(store.get(3), 2);
		
		
		cart.showCartPrice();
		
		
		//removing item from cart
		cart.deleteItem(store.get(3));
		cart.deleteItem(store.get(1));
		
		
		// display all the items present in our cart to check changes
		cart.displayAllItems();

		
		//displaying total price of cart
		cart.showCartPrice();
		
		
		System.out.println(""); // for line space
		
		// display quantity and properties of single item
		cart.displayItem(store.get(10000));
  
		/*
		 <-------------Some Tests---------->
		 */
		
		// If we try to display item which is not in Cart then then it will show error message
		cart.displayItem(store.get(3)); // Item not present in cart
		cart.displayItem(store.get(1)); // Item not present in cart
		
		//If we try to add two same object in Cart it will not add duplicate as we are using itemID for hashing
		
		// If we try to enter negative quantity it will ask for valid quantity
		cart.addToCart(store.get(3), -5); // Please enter valid quantity
		
	}
}
