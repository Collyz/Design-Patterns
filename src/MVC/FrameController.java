package MVC;

import javax.swing.*;

public class FrameController{
    private final FrameModel model;

    public FrameController(){
        model = new FrameModel();
    }

    /**
     * Text-field text sent to model to be processed.
     * @param text - The text-field to manipulate
     */
    public void sendExpression(JTextField text, JLabel label){
        model.writeToFile(text, label);
    }

    public void requestGraph(JLabel label,JLabel imageLabel){
        model.createGraph(label, imageLabel);
    }

}
