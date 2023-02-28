package template;

public abstract class CaffeineBeverage {

    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if(customerWantsCondiments()){
            addCondiment();
        }
        System.out.println("");
    }

    abstract void brew();

    abstract void addCondiment();

    void boilWater(){
        System.out.println("Boiling water");
    }

    public void pourInCup(){
        System.out.println("Pouring into cup");
    }

    public boolean customerWantsCondiments(){
        return true;
    }
}
