package strategy;

public class NoWingsFly implements FlyBehavior{
    public void fly(){
        System.out.println("I can't fly!");
    }
}
