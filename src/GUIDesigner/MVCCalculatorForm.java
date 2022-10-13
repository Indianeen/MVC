package GUIDesigner;

import javax.swing.*;

/**
 * This is a class
 * Created 2020-11-10
 *
 * @author Magnus Silverdal
 */
public class MVCCalculatorForm {
    public static void main(String[] args) {
        CalculatorViewForm theView = new CalculatorViewForm();
        CalculatorModel theModel = new CalculatorModel();
        CalculatorControllerForm theController = new CalculatorControllerForm(theView,theModel);

        JFrame frame = new JFrame("MVCViewForm");
        frame.setContentPane(theView.getMVCPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
