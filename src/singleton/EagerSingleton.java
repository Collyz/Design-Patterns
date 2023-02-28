package singleton;

public class EagerSingleton {
    /*
    Here we create the instance of the object when the program is being
    compiled which prevents the issue with the threads. Very "eager" since
    the object is created before any other aspect of the program needs it.
    The JVM guarantees that the instance will be created before any thread
    accesses the static variable.
     */
    private static EagerSingleton uniqueInstance = new EagerSingleton();

    private EagerSingleton(){}

    public static EagerSingleton getInstance(){
        return uniqueInstance;
    }
}
