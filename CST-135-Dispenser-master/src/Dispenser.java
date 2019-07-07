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
 * This is our main Dispenser class.  Its main method is used currently to test method calls to other classes
 * here are the creation criteria: String name, String brand, int quantity, int price, String productID
 */
public class Dispenser {
	public static Product[][] productGrid = new Product[5][5];

	public static void main(String[] args) {

		Product myProduct = new Product();
		System.out.println(myProduct.toString());
		myProduct = new Product("This is a product", "ACME", 100, 120, "Product01");
		System.out.println(myProduct.toString());

		Product myDrink = new Drink();
		System.out.println(myDrink.toString());
		myDrink = new Drink("This is a drink", "Drink-a-licious", 120, 180, "Product03");
		System.out.println(myDrink.toString());

		Product mySnack = new Snack();
		System.out.println(mySnack.toString());
		mySnack = new Snack("This is a snack", "Snacktastic", 130, 1289, "Product05");
		System.out.println(mySnack.toString());

		Product myGum = new Gum();
		System.out.println(myGum.toString());
		myGum = new Product("This is America...err gum", "Gum4LyfYo", 1020, 12, "Productgummy");
		System.out.println(myGum.toString());

		Product myChips = new Chips();
		System.out.println(myChips.toString());
		myChips = new Drink("This is a chips", "insert your own idea here man!", 120, 180, "Product03");
		System.out.println(myChips.toString());

		Product myCandy = new Candy();
		System.out.println(myCandy.toString());
		myCandy = new Candy("This is a candy", "Snacktastic", 130, 1289, "Product05");
		System.out.println(myCandy.toString());

		//to test: comment out all of the above products and run the code below
		displayProducts(fillDispenser());

	}

	//I created this method to just fill the dispenser with some stuff in order to display
	// it in the displayProducts method
	public static Product[][] fillDispenser() {

		for (int i = 0; i < productGrid.length; i++){
			for (int j = 0; j < productGrid[0].length; j++){
				productGrid[i][j] = new Product();
				productGrid[i][j].setPrice(100);
				productGrid[i][j].setQuantity(20);
			}
		}
		productGrid[0][0].setName("Cheetos Crunchy");
		productGrid[0][1].setName("Lays");
		productGrid[0][2].setName("Sour Patch Yellow");
		productGrid[0][3].setName("Orbit");
		productGrid[0][4].setName("Fanta");
		productGrid[1][0].setName("Lays");
		productGrid[1][1].setName("Reeses Pieces");
		productGrid[1][2].setName("Skittles Green");
		productGrid[1][3].setName("Trident");
		productGrid[1][4].setName("Gatorade");
		productGrid[2][0].setName("Doritos Purple");
		productGrid[2][1].setName("Skittles Red");
		productGrid[2][2].setName("Sour Patch Pink");
		productGrid[2][3].setName("5");
		productGrid[2][4].setName("Monster");
		productGrid[3][0].setName("Doritos Blue");
		productGrid[3][1].setName("Doritos Purple");
		productGrid[3][2].setName("Extra");
		productGrid[3][3].setName("Water");
		productGrid[3][4].setName("Powerade");
		productGrid[4][0].setName("Cheetos Hot");
		productGrid[4][1].setName("Snickers");
		productGrid[4][2].setName("Hubba Bubba");
		productGrid[4][3].setName("Coke");
		productGrid[4][4].setName("Sprite");
		return productGrid;
	}

	//This method takes in a product grid and spits out the toString of each product contained therein
	public static void displayProducts(Product[][] productGrid) {
		for (int i = 0; i < productGrid.length; i++){
			for (int j = 0; j < productGrid[0].length; j++){
				System.out.println(productGrid[i][j].toString());
			}
		}
	}

}

/* possible changes:

I could make the products array a 3D array. This would allow us to have a row column access system but the third
dimension could allow for us to track quantity that way instead of using quantity as a variable inside the object
I wold be willing to update the code to reflect this change but it's totally up to you guys. I'm not sure what we want
to do and how in depth we want to go with this.


-- David Pratt Jr.
 */
