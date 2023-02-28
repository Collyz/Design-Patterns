package factory;

public class VeggiePizza extends Pizza{

    public void prepare() {
        System.out.println("Dough, then sauce, then vegetables, finally ready to bake");
    }
}
