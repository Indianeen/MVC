package MVCSolo; /**
 * Created by magnus on 2017-01-27.
 */
// This is the View
// Its only job is to display what the user sees
// It performs no calculations, but instead passes
// information entered by the user to whomever needs
// it.

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SoloView extends JFrame {
    private JTextArea bodyField = new JTextArea(1,10);
    private JTextArea descriptionsField = new JTextArea(1,10);
    private JButton selectButton = new JButton("Select");
    private JTextField choiceField = new JTextField(10);

    SoloView() {
        // Sets up the view and adds the components
        JPanel calcPanel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);
        calcPanel.add(bodyField);
        calcPanel.add(descriptionsField);
        calcPanel.add(selectButton);
        calcPanel.add(choiceField);
        this.add(calcPanel);
        // End of setting up the components --------
    }

    public int getChoice() {
        try {
            return Integer.parseInt(choiceField.getText());
        } catch (NumberFormatException ex) {
            displayErrorMessage("Please enter a valid Choice");
            return -1;
        }
    }

    public void setBody(String body) {
        bodyField.setText(body);
    }

    public void setDescriptions(ArrayList<String> descriptions) {
        descriptionsField.setText("");
        for (int i = 0 ; i < descriptions.size() ; i++) {
            descriptionsField.append((i+1) + ":" + descriptions.get(i) + "\n");
        }
    }

    public void addSelectListener(ActionListener listenForSelectButton) {
        selectButton.addActionListener(listenForSelectButton);
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}