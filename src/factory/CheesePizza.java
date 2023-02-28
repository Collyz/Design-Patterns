package factory;

public class CheesePizza extends Pizza {

    public void prepare() {
        System.out.println("First dough, then sauce, then cheese, finally ready to bake");
    }

}
