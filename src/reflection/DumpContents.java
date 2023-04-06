package reflection;

import java.lang.reflect.*;

public class DumpContents {
    public static void main(String args[])
    {
        //Getting object information
        try {
            Object person = new Person("John", 35);
            Class c = person.getClass();
            Constructor[] constructors = c.getDeclaredConstructors();
            Method methods[] = c.getDeclaredMethods();
            Field[] fields = c.getDeclaredFields();
            System.out.println(c.getSimpleName() + ":");
            System.out.println("-------------\nConstructors - ");
            for(int i = 0; i < constructors.length; i++){
                System.out.println(constructors[i].toString());
            }
            System.out.println("\nMethods - ");
            for (int i = 0; i < methods.length; i++) {
                System.out.println(methods[i].toString());
            }
            System.out.println("\nFields - ");
            for(int i = 0; i < fields.length; i++){
                System.out.println(fields[i].toString());
            }
        }
        catch (Throwable e) {
            System.err.println(e);
        }
        //Getting information if we only know its name
        try{
            Class c = Class.forName("reflection.Person");
            System.out.println("\n"+c.getSimpleName());
            System.out.println(c.getName());
            System.out.println(c.getCanonicalName());
        }catch(Throwable e){
            System.err.println(e);
        }

        //Getting the package information from the class
        System.out.println("Package\n");
        Person person = new Person();
        Class personClass = person.getClass();
        Package pkg = personClass.getPackage();
        System.out.println(pkg.getName());

        //Settings and getting field values
        System.out.println("\nSetting the name and age of a Person class during runtime");
        try{
            Class c = Class.forName("reflection.Person");
            Field[] fields = c.getDeclaredFields();
            Person p = (Person) c.getConstructor().newInstance();
            Field fieldName = c.getDeclaredField("name");
            fieldName.setAccessible(true);
            fieldName.set(p, "Billy Bob");
            System.out.println(p.getName());
        }catch(Throwable e){
            System.err.println(e);
        }

    }
}