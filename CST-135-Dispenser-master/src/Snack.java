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
 * This is our snack class which extends product
 */
public class Snack extends Product implements Comparable<Snack> {

	@Override
	public int compareTo(Snack snack) {

		int result = this.Name.toLowerCase().compareTo(snack.getName().toLowerCase());
		if (result != 0){
			return result;
		} else if (result == 0){
			result = Integer.compare(this.Price, snack.getPrice());
		}
		return result;
	}
	
	public Snack(String name, String brand, int quantity, int price, String productID) {
		this.setProductID(productID);
		this.setName(name);
		this.setBrand(brand);
		this.setQuantity(quantity);
		this.setPrice(price);
	}
	

	public Snack() {
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

