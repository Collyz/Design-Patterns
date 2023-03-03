package MVC;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FrameModel {
    String expression;

    public FrameModel(){
        this.expression = "";
    }

    public void processExpression(JTextField text){
        setExpression(text.getText());
        writeToFile();
        text.setText("");
    }

    public double evaluateExp(int value){
        Expression exp = new ExpressionBuilder(this.expression)
                .variables("x")
                .build()
                .setVariable("x", value);
        return exp.evaluate();
    }

    public void setExpression(String expression){
        this.expression = expression;
    }

    public void writeToFile(){
        try{
            File file = new File("graph-data.csv");
            BufferedWriter br = new BufferedWriter(new FileWriter(file));
            br.write("X-Values, Y-Values\n");
            for(int i = 0; i <= 100; i++){
                br.write(i + "," + evaluateExp(i) + "\n");
            }
            br.close();
        }catch(IOException e){
            System.out.println("IOException occurred, check writeToFile() method");
        }
    }

    public void createGraph(){
    }

}
