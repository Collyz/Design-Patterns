package factory;

public class CheesePizza extends Pizza {

    public CheesePizza(){
        this.name = "Cheese Pizza";
        this.dough = "Regular Dough";
        this.sauce = "Regular Sauce";
        this.toppings.add("Low Moisture Mozzarella");
    }
}
