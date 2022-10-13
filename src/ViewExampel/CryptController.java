package ViewExampel;

import MVCCalculator.Crypt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CryptController {
    CryptView view;

    public CryptController(CryptView v) {
        view = v;
        JFrame frame = new JFrame("CryptView");
        frame.setContentPane(v.getRoot());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        view.setButton1Listener(new Button1Listener());
    }

    public static void main(String[] args) {
        CryptView v = new CryptView();
        CryptController controller = new CryptController(v);
    }

    private class Button1Listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Hej!");
            view.appendTextInTextField("Hej");
        }
    }
}
