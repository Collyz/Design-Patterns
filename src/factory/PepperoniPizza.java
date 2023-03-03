package factory;

import factory.Pizza;

public class PepperoniPizza extends Pizza {

    public PepperoniPizza(){
        this.name = "Cheese Pizza";
        this.dough = "Regular Dough";
        this.sauce = "Regular Sauce";
        this.toppings.add("Low Moisture Mozzarella");
        this.toppings.add("Pepperoni");
    }

}
