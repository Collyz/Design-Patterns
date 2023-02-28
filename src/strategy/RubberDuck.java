package strategy;

public class RubberDuck extends Duck {

    public RubberDuck(String name, String type){
        super(name, type = "Rubber Duck");
        quackBehavior = new Squeak();
        flyBehavior = new NoWingsFly();
    }
}
