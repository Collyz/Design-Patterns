package MVC;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewFrame implements ActionListener{
    private JFrame frame;
    private JTextField text1;
    protected JButton btn1, btn2;
    private JLabel label1, respLabel;
    private GroupLayout gl;
    FrameController fc;


    /**
     * Empty constructor
     */
    public ViewFrame() {
        fc = new FrameController();
        initializeComponents();
    }

    /**
     * Performs necessary steps to create a usable frame
     */
    public void run(){
        setComponentBounds();
        addToFrame();
        setVisible();
    }

    /**
     * Initializes all components of the container
     */
    public void initializeComponents(){
        //Initialized components added required eventListeners and set size of JFrame
        frame = new JFrame("Graphs");
        frame.setSize(700, 500);
        gl = new GroupLayout(frame);
        text1 = new JTextField();
        btn1 = new JButton("Calculate");
        btn2 = new JButton("Get Graph");
        label1 = new JLabel("Enter a 2D function: f(x) = ");
        respLabel = new JLabel("");

        //Action listeners being added.
        btn1.addActionListener(this);
    }

    /**
     * Adds components to frame
     */
    public void addToFrame(){
        frame.add(text1);
        frame.add(btn1);
        frame.add(btn2);
        frame.add(label1);
        frame.add(respLabel);
    }

    public void setComponentBounds(){
        //Arbitrary specific x for text-field
        int middleX = (frame.getWidth()/2) - (300/4);
        text1.setBounds(middleX, 50, 300, 30);

        //Buttons and their backgrounds
        btn1.setBounds(150, 200, 100, 30);
        btn1.setBackground(new Color(180, 231, 250));
        btn2.setBounds(450, 200, 100, 30);
        btn2.setBackground(new Color(180, 231, 250));

        //Labels
        label1.setBounds(120, 50, 250, 30);
        respLabel.setBounds(275, 80, 250, 30);
    }

    /**
     * Makes the container visible or otherwise nothing ever is visible.
     */
    public void setVisible(){
        this.frame.getContentPane().setBackground(new Color(180, 231, 250));
        this.frame.setLayout(null);
        this.frame.setVisible(true);
    }

    /**
     * When btn1 is clicked, the text-field is passed to
     * controller to send data to model to be processed.
     * @param event the event to be processed
     */
    public void actionPerformed(ActionEvent event) {
        fc.sendInformation(text1);
    }

}
