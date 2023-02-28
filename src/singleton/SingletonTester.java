package singleton;

public class SingletonTester {
    public static void main(String[] args) {
        myObject test = myObject.getInstance();
        test.workingSingleton();
    }
}
