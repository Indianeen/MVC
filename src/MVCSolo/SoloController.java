package MVCSolo; /**
 * Created by magnus on 2017-01-27.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// The Controller coordinates interactions
// between the View and Model
public class SoloController {
    private SoloView theView;
    private SoloModel theModel;

    public SoloController(SoloView theView, SoloModel theModel) {
        this.theView = theView;
        this.theModel = theModel;
        theView.setBody(theModel.getBody());
        theView.setDescriptions(theModel.getDescriptions());

        this.theView.addSelectListener(new SelectListener());
    }

    private class SelectListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int choice;
            choice = theView.getChoice();
            if (choice > 0 && choice < theModel.getStoryLinks().size()) {
                theModel.setStoryId(theModel.getStoryLinks().get(choice - 1));
                theView.setBody(theModel.getBody());
                theView.setDescriptions(theModel.getDescriptions());
            } else {
                theView.displayErrorMessage("Please select a valid Number.");
            }
        }
    }
}