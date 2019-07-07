public class test {
    public static void main(String[] args) {
        Snack[] snacks = {
                new Snack("butter popcorn", "Orville Redenbacher", 5, 2, "ao239"),
                new Snack("pretzels", "Rold Gold", 5, 2, "ao249"),
                new Snack("Chips a'hoy", "Lays", 5, 4, "ao456"),
                new Snack("chips", "Nestle", 5, 4, "ao520"),
        };
        java.util.Arrays.sort(snacks);

        for (Snack snack: snacks){
            System.out.println(snack.toString() + " ");
        }

        Drink[] drinks = {
                new Drink("Dr. Pepper", "Pepsico", 5, 4, "ad455"),
                new Drink("Dr. Pepper", "Pepsico", 5, 3, "ad455"),
                new Drink("Coke", "Coca-Cola", 5, 3, "ad487"),
                new Drink("Gatorade", "7-UP", 5, 2, "ad672"),
                new Drink("YooHoo", "YooHoo", 5, 7, "ad690"),
        };

        java.util.Arrays.sort(drinks);

        for (Drink drink: drinks){
            System.out.println(drink.toString() + " ");
        }
    }
}
