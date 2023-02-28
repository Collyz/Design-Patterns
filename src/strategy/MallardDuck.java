package strategy;

public class MallardDuck extends Duck{


    public MallardDuck(String name, String type) {
        super(name, type="Mallard Duck");
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }


}
