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
 * This is our main product class.  It has overloaded creation and generic/naked creation method
 * copy method is also in place as are all relevant sets and gets
 */
public class Product {
	
	String ProductID;
	int Product;
    String Name;
    String Brand;
    int Quantity;
    int Price;
    
    private String name;
	private double price;
	
	
	public Product(String name, String brand, int quantity, int price, String productID) {
		this.setProductID(productID);
		this.setName(name);
		this.setBrand(brand);
		this.setQuantity(quantity);
		this.setPrice(price);
	}
	

	public Product() {
		this.setProductID("none");
		this.setBrand("default");
		this.setName("default");
		this.setQuantity(10);
		this.setPrice(100);
	}
	
	public Product(Product copyProduct) {
		this.setName(copyProduct.getName());
		this.setQuantity(copyProduct.getQuantity1());
		this.setPrice(copyProduct.getPrice());
	}

	public String getProductID() {
		return this.ProductID;
	}

	public void setProductID(String productID) {
		this.ProductID = productID;
	}
	
	public String getName() {
		return this.Name;
	}
	
	public int getQuantity1() {
		return this.Quantity;
	}
	
	public int getPrice() {
		return this.Price;
	}
	
	public void setName(String name) {
		this.Name = name;
	}
	
	public void setBrand(String brand) {
		this.Brand = brand;
	}
	
	public String getBrand() {
		return this.Brand;
	}
	
	public void setPrice(int price) {
		this.Price = price;
	}
	
	 public void setQuantity(int quantity) {
	        this.Quantity = quantity;
	 }

	
	public String toString() {
		return "\n"
		+ getName()
		+"\nPrice: " + this.getPrice()
		+"\nBrand: " + this.getBrand()
		+"\nQuantity: " + this.getQuantity()
		+"\nProductID: " + this.getProductID();
		
	}

	public String nameAndPrice(){
		return "\n"
				+ this.getName()
				+"\nPrice: " + this.getPrice();
	}

	public String nameAndPriceOneLine(){
		return this.getName() + " " + this.getPrice() + " cents.";
	}

	public int getQuantity() {
		// returns quantity
		return this.Quantity;
	}

	public int compareTo(Product arg0) {
		// for future
		return 0;
	}

	public void changeQuantity(int quantity) {
		this.Quantity = this.Quantity + quantity;
		
	}

	
}

