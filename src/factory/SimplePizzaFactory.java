package factory;

public class SimplePizzaFactory {
    public Pizza createPizza(String type){
        Pizza pizza = null;

        if(type.equals("cheese")){
            pizza = new CheesePizza();
        }
        else if(type.equals("pepperoni")){
            pizza = new PepperoniPizza();
        }else if(type.equals("VeggiePizza")){
            pizza = new VeggiePizza();
        }
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
}
