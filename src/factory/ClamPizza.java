package factory;

public class ClamPizza extends Pizza {

    public ClamPizza(){
        this.name = "Clam Pizza";
        this.dough = "Regular Dough";
        this.sauce = "Regular Sauce";
        this.toppings.add("Buffalo Mozzarella");
        this.toppings.add("Clams");
    }

}
