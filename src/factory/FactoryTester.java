package factory;

import java.util.Scanner;

public class FactoryTester {
    public static void main(String[] args) {
        SimplePizzaFactory factory = new SimplePizzaFactory();

        Scanner in = new Scanner(System.in);
        String input = "";
        while(input != "exit"){
            System.out.println("\nEnter \"exit\" to leave program");
            System.out.print("Enter a pizza from the listing:\n" +
                    "\"cheese\", \"pepperoni\", \"veggie\", \"clam\"\n" +
                    "Your input: ");
            input = in.nextLine();
            if(!input.equals("exit")){
                factory.createPizza(input);
            }else{
                System.out.println("Exiting!");
                break;
            }
            input = "";
        }


    }
}
