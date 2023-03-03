package factory;

import factory.Pizza;

public class VeggiePizza extends Pizza {

    public VeggiePizza(){
        this.name = "Veggie Pizza";
        this.dough = "Regular Dough";
        this.sauce = "Regular Sauce";
        this.toppings.add("Low Moisture Mozzarella");
        this.toppings.add("Vegetables");
    }

}
