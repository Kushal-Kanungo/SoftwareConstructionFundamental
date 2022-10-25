package scfc;

import java.util.Objects;

public class Item{
	// Item properties all are private to remove direct access to them from outside class
	private int itemId;
	private String name;
	private String desc;
	private double price; 
	
	
	
	// constructor which takes arguments required in an Item
	public Item(int itemId, String name, String desc, double price){
		this.itemId = itemId;
		this.name = name;
		this.desc = desc;
		this.price = price;				
	}
	
	
	
	//setter and getter function to access properties of Item	
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	

	// we overriding the hashcode() so that we can use Item object as key in Hash Map
	@Override
	public int hashCode() {
		return Objects.hash(itemId);  //only using itemId for hashing
	}
	
	// equals function fill help us to check equality b/w two objects of Item Class
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return itemId == other.itemId;
	}
}