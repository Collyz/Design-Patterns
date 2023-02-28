package singleton;

public class ChocolateBoiler {
    private boolean empty;
    private boolean boiled;
    private static ChocolateBoiler uniqueInstance;

    private ChocolateBoiler(){
        empty = true;
        boiled = true;
    }

    /*
    Here synchronized is used to force all threads to wait their turn
    using the method preventing multiple threads simultaneously creating more
    than one instance of the class. This only matters if the instance of the
    object hasn't been made yet. Afterwards its irrelevant
     */
    public static synchronized ChocolateBoiler getInstance(){
        if(uniqueInstance == null){
            uniqueInstance = new ChocolateBoiler();
        }
        return uniqueInstance;
    }

    public void fill(){
        if(isEmpty()){
            empty = true;
        }
    }

    public boolean isEmpty(){
        return this.empty;
    }

}
