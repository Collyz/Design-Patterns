import ChapterOne.Duck;
import ChapterOne.MallardDuck;
import ChapterOne.RubberDuck;

public class Main {
    public static void main(String[] args) {

        MallardDuck duck = new MallardDuck("Billy", "");
        RubberDuck duck2 = new RubberDuck("Joe", "");
        duck.getType();
        duck.quack();
        duck.fly();
        duck2.getType();
        duck2.quack();
        duck2.fly();
    }
}