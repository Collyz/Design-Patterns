package factory;

import com.sun.security.jgss.GSSUtil;

public class ClamPizza extends Pizza{

    public void prepare() {
        System.out.println("First dough, then sauce, then clams, finally ready to bake");
    }

}
