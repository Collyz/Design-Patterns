package singleton;

public class myObject {
    private static myObject uniqueInstance;
    private myObject(){}

    public static myObject getInstance(){
        if(uniqueInstance == null) {
            uniqueInstance = new myObject();
        }
        return uniqueInstance;
    }

    public void workingSingleton(){
        System.out.println("Its working!");
    }
}
