package MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class FrameView {
    JFrame frame;
    private JTextField text1;
    protected JButton btnCalculate, btnGraph,btnClear;
    private JLabel label1, respLabel, imgLabel;

    FrameController fc;


    /**
     * Empty constructor
     */
    public FrameView() {
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
        frame.setSize(1200, 720);
        text1 = new JTextField("");
        label1 = new JLabel("Enter a 2D function: f(x) = ");
        respLabel = new JLabel("");
        imgLabel = new JLabel();

        //Abstract Action for buttons specifically
        //clearing the text-field and passing the expression to the model
        btnCalculate = new JButton(new AbstractAction("Calculate"){
            @Override
            public void actionPerformed(ActionEvent e) {
                fc.sendExpression(text1, respLabel);
            }
        });
        //Gives the image label the graph created by model
        btnGraph = new JButton(new AbstractAction("Get Graph") {
            @Override
            public void actionPerformed(ActionEvent e) {
                fc.requestGraph(respLabel, imgLabel);
            }
        });
        //Clears the image label
        btnClear = new JButton(new AbstractAction("Clear") {
            @Override
            public void actionPerformed(ActionEvent e) {
                imgLabel.setIcon(new ImageIcon());
            }
        });
    }

    /**
     * Adds components to frame
     */
    public void addToFrame(){
        frame.add(text1);
        frame.add(btnCalculate);
        frame.add(btnGraph);
        frame.add(btnClear);
        frame.add(label1);
        frame.add(respLabel);
        frame.add(imgLabel);
    }

    /**
     * Sets the component xy positions as well as other properties
     */
    public void setComponentBounds(){
        //Arbitrary specific x for text-field
        text1.setBounds(270, 30, 300, 30);

        //Buttons and their backgrounds
        btnCalculate.setBounds(600, 30, 100, 30);
        btnCalculate.setBackground(new Color(250, 234, 180));
        btnGraph.setBounds(720, 30, 100, 30);
        btnGraph.setBackground(new Color(250, 180, 197));
        btnClear.setBounds(840,30, 100, 30);
        btnClear.setBackground(new  Color(255, 102, 112));

        //Labels
        label1.setBounds(120, 30, 250, 30);
        respLabel.setBounds(275, 60, 250, 30);
        imgLabel.setBounds(20, 90, 1100, 550);
    }

    /**
     * Makes the container visible or otherwise nothing ever is visible.
     */
    public void setVisible(){
        this.frame.getContentPane().setBackground(new Color(180, 231, 250));
        this.frame.setLayout(null);
        this.frame.setVisible(true);
    }

}
