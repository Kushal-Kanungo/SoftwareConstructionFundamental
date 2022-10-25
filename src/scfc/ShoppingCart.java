package scfc;

import java.util.HashMap;

//import java.util.HashMap;

public class ShoppingCart {
	/*
	 <--------------Properties--------------->
	 */
	//We are storing Items in a Hash Map where Key -> Item &  Value -> Quantity
	private HashMap<Item, Integer> cartItems = new HashMap<Item, Integer>();
	private double totalPrice; // this will store the cart price
	
	
	/*
	 <--------------Functions--------------->
	 */
	
	// this function will add item to our hashmap (item as key and quantity as value)
	public void addToCart(Item item, int quantity) {
		if (quantity > 0) {
			this.cartItems.put(item, quantity);
		}
		else {
			System.out.println("Please enter valid quantity");
		}		
	}
	
	// this function will change the quantity in cart
	public void updateQty(Item item, int quantity) {
		this.cartItems.put(item, quantity);
		//we can also use addtoCart function here it will 
	}
	
	
	// this function will delete item from our cart 
	public void deleteItem(Item item) {
		this.cartItems.remove(item);
	}
	
	
	// this function will take the item object and find it in the cart in constant time
	/**
	 * this function will take the item object and find it in the cart in constant time
	
	 * @param item
	 */
	public void displayItem(Item item) {
		if (this.cartItems.containsKey(item)) {
		System.out.println(item.getName()+"\t|"+item.getDesc()+"\t|"+item.getPrice()+"\t|"+this.cartItems.get(item)+" Units   |");
		}
		else {
			System.out.println("Item  not found in the cart");
		}	
	}
	
	
	// this function will call displayItem function for each item
	// We are iterating in hashmap and calling displayItem for each Item
	/**
	 * Description
	 * @params
	 * @author Kushal
	 * Date & time
	 */
	public void displayAllItems() {
		System.out.println(""); // spacing
		this.cartItems.forEach((key,val)->{
			displayItem(key);
		});	
	}
	
	
	// this function fill iterate in hashmap of cart and add the price*quantity
	public void showCartPrice() {
		this.totalPrice = 0;
		this.cartItems.forEach((key,val)-> {
			this.totalPrice+=val*key.getPrice();
		});
		System.out.println("Cart Price Rs."+ this.totalPrice);
	}
}
