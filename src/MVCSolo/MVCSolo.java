package MVCSolo;

/**
 * This is a class
 * Created 2020-04-01
 *
 * @author Magnus Silverdal
 */
public class MVCSolo {
    public static void main(String[] args) {
        SoloView theView = new SoloView();
        SoloModel theModel = new SoloModel();
        SoloController theController = new SoloController(theView,theModel);
        theView.setVisible(true);
    }
}
