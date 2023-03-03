package MVC;

import javax.swing.*;

public class FrameController{
    private FrameModel model;

    public FrameController(){
        model = new FrameModel();
    }

    /**
     * Text-field text sent to model to be processed.
     * @param text - The text-field to manipulate
     */
    public void sendInformation(JTextField text){
        model.processExpression(text);
    }

}
