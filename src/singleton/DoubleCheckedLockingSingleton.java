package singleton;

public class DoubleCheckedLockingSingleton {
    /*
    * The volatile keyword ensures that threads handle the static variable
    * correctly when it is being initialized to the DoubleCheckedLockingSingleton
    * instance.
    * */
    private volatile static DoubleCheckedLockingSingleton uniqueInstance;

    private DoubleCheckedLockingSingleton(){}

    /*
    If performance is an issue in the use of getInstance() then this
    implementation of Singleton it can drastically reduce the overhead.
     */
    public static DoubleCheckedLockingSingleton getInstance(){
        if(uniqueInstance == null){
            synchronized (DoubleCheckedLockingSingleton.class){
                if(uniqueInstance == null){
                    uniqueInstance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return uniqueInstance;
    }
}
