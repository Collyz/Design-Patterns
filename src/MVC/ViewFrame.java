package MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class ViewFrame{
    JFrame frame;
    private JTextField text1;
    protected JButton btn1, btn2;
    private JLabel label1, respLabel, imgLabel;

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
        frame.setSize(1280, 720);
        text1 = new JTextField("");
        label1 = new JLabel("Enter a 2D function: f(x) = ");
        respLabel = new JLabel("");
        imgLabel = new JLabel();

        //Abstract Action for buttons specifically
        btn1 = new JButton(new AbstractAction("Calculate"){
            @Override
            public void actionPerformed(ActionEvent e) {
                fc.sendExpression(text1, respLabel);
            }
        });
        btn2 = new JButton(new AbstractAction("Get Graph") {
            @Override
            public void actionPerformed(ActionEvent e) {
                fc.requestGraph(respLabel, imgLabel);
            }
        });
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
        frame.add(imgLabel);
    }

    /**
     * Sets the component xy positions as well as other properties
     */
    public void setComponentBounds(){
        //Arbitrary specific x for text-field
        text1.setBounds(300, 30, 300, 30);

        //Buttons and their backgrounds
        btn1.setBounds(150, 420, 100, 30);
        btn1.setBackground(new Color(250, 234, 180));
        btn2.setBounds(450, 420, 100, 30);
        btn2.setBackground(new Color(250, 180, 197));

        //Labels
        label1.setBounds(120, 30, 250, 30);
        respLabel.setBounds(275, 60, 250, 30);
        imgLabel.setBounds(20, 90, 600, 370);
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
