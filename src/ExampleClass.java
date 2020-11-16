import java.io.Serializable;

/**
 * This is a class
 * Created 2020-11-16
 *
 * @author Magnus Silverdal
 */
public class ExampleClass implements Serializable {
    double x;
    double y;
    private static final long serialVersionUID = 1234L;

    public ExampleClass() {
        x = 3.14;
        y = 2.72;
    }

}
