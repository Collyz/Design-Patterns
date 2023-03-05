package MVC;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class FrameModel {
    String expression;

    public FrameModel(){
        this.expression = "";
    }

    /**
     * Checks if the expression is empty or not, expression cannot be empty
     * Thinking of adding better checks but TBD...
     * @param text - The JTextField that the expression is taken from.
     * @return boolean if the text-field is not blank
     */
    public boolean checkExpression(JTextField text){
        return !text.getText().isEmpty() && text.getText() != null;
    }

    public boolean checkExpression(){
        return !this.expression.isEmpty();
    }

    /**
     * Evaluates the expression for a given integer value
     * @param value - The value to be used in the place of variable X
     * @return double calculated for that integer value 'value'
     */
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

    public void writeToFile(JTextField text, JLabel label){
        //If the expressions is valid, then graph-data.csv is created
        if(checkExpression(text)){
            setExpression(text.getText());
            try {
                File file = new File("graph-data.csv");
                BufferedWriter br = new BufferedWriter(new FileWriter(file));
                br.write("X-Values, Y-Values\n");
                for (int i = -100; i <= 100; i++) {
                    br.write(i + "," + evaluateExp(i) + "\n");
                }
                br.close();
                text.setText("");
                label.setText("Expression evaluated");
            } catch (IOException e) {
                System.out.println("IOException occurred, check writeToFile() method");
            }
        }else{
            label.setText("Enter a valid expression!");
        }
    }

    public void createGraph(JLabel label, JLabel imageLabel){
        if(checkExpression()){
            File imageFile = new File("XYLineChart.png");
            int width = imageLabel.getWidth();
            int height = imageLabel.getHeight();
            try {
                //Title and axes labels
                String title = "Graph of: " + expression;
                String xAxisLabel = "X";
                String yAxisLabel = "Y";
                //Dataset for graph
                XYSeriesCollection dataset = new XYSeriesCollection();
                //One line-graph, therefore only one XYSeries
                XYSeries series1 = new XYSeries("Line");
                //Reading the file
                BufferedReader br = new BufferedReader(new FileReader("graph-data.csv"));
                String temp;
                //Skips label line
                br.readLine();
                //Add data to dataset
                while ((temp = br.readLine()) != null) {
                    String[] tempXY = temp.split(",");
                    double tempX = Double.parseDouble(tempXY[0]);
                    double tempY = Double.parseDouble(tempXY[1]);
                    series1.add(tempX, tempY);
                }
                //Series added to dataset
                dataset.addSeries(series1);
                //Graph created with no legend, tooltips, or url
                JFreeChart lineChart = ChartFactory.createXYLineChart(title, xAxisLabel, yAxisLabel, dataset,
                        PlotOrientation.VERTICAL, false, false, false);
                //Adding the image to the frame
                try {
                    ChartUtils.saveChartAsPNG(imageFile, lineChart, width, height);
                    BufferedImage graphPicture = ImageIO.read(new File("XYLineChart.png"));
                    ImageIcon image = new ImageIcon(graphPicture);
                    imageLabel.setIcon(image);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                label.setText("Your graph:");
            } catch (IOException e) {
                System.out.println("Error");
            }
        }else{
            label.setText("You haven't calculated an expression yet");
        }
    }

}
