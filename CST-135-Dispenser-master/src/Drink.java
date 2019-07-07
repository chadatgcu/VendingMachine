/**
 * Grand Canyon University 
 * CST-135
 * Brandon Bass
 * 
 * Daniel"Thad"Dittmer
 * Chad Wierick
 * David Pratt
 * Zachary Swoveland
 * 
 * This is our drink class which extends product
 */
public class Drink extends Product implements Comparable<Drink>{

	@Override
	public int compareTo(Drink drink) {
		int result = this.Name.toLowerCase().compareTo(drink.getName().toLowerCase());
		if (result != 0){
			return result;
		} else if (result == 0){
			result = Integer.compare(this.Price, drink.getPrice());
		}
		return result;
	}

	public Drink(String name, String brand, int quantity, int price, String productID) {
		this.setProductID(productID);
		this.setName(name);
		this.setBrand(brand);
		this.setQuantity(quantity);
		this.setPrice(price);
	}
	

	public Drink() {
		this.setProductID("none");
		this.setBrand("default");
		this.setName("default");
		this.setQuantity(10);
		this.setPrice(100);
	}
	
	public String toString() {
		return "\n"
		+ getName()
		+"\nPrice: " + getPrice()
		+"\nBrand: " + getBrand()
		+"\nQuantity: " + getQuantity()
		+"\nProductID: " + getProductID();
		
	}
	
}

