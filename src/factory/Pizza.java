package factory;

public abstract class Pizza {

    public abstract void prepare();

    public void bake(){
        System.out.println("Baking the " + getClass());
    }

    public void cut(){
        System.out.println("Cutting " + getClass() + " into 8 slices");
    }
    public void box(){
        System.out.println("Putting " + getClass() +"into pizza box");
    }

}
