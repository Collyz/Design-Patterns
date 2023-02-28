package template;

public class TemplateTester {
    public static void main(String[] args) {
        Tea myTea = new Tea();
        Coffee myCoffee = new Coffee();

        myTea.prepareRecipe();
        myCoffee.prepareRecipe();
    }
}