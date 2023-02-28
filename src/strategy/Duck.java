package strategy;

public class Duck {
    private String name;
    private String type;
    QuackBehavior quackBehavior;
    FlyBehavior flyBehavior;

    public Duck(String name, String type){
        this.name = name;
        this.type = type;
    }

    public void swim(){
        System.out.println("I can swim!");
    }

    public void quack(){
        quackBehavior.quack();
    }
    public void fly(){
        flyBehavior.fly();
    }

    public void getType(){
        System.out.println(type);
    }
}
