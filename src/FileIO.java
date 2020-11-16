/**
 * This is a class
 * Created 2020-11-16
 *
 * @author Magnus Silverdal
 */
import java.io.*;


public class FileIO {
    String textFile = "data.txt";
    String objectFile = "data.obj";
    String dataFile = "data.dat";
    double[] data;

    public FileIO() {
        int size = 10000;
        data = new double[size];
        for (int i = 0 ; i < size ; i++) {
            data[i] = Math.sin(i);
        }
    }

    public static void main(String[] args) {
        FileIO f = new FileIO();

        try {
            f.CharStreamExample();
            f.DataStreamExample();
            f.ObjectStreamExample();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void CharStreamExample() throws IOException {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new FileWriter(textFile)));
            for (int i = 0; i < data.length ; i ++) {
                out.println(data[i]);
            }
        } finally {
            out.close();
        }

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(textFile));
            System.out.println("Reading from textfile " + textFile);
            for (int i = 0 ; i < data.length ; i++) {
                double d = Double.parseDouble(in.readLine());
                System.out.println(d);
            }
        } finally {
            in.close();
        }
    }

    public void DataStreamExample() throws IOException {
        DataOutputStream out = null;

        try {
            out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)));
            for (int i = 0; i < data.length ; i ++) {
                out.writeDouble(data[i]);
            }
        } finally {
            out.close();
        }

        DataInputStream in = null;
        try {
            in = new DataInputStream(new BufferedInputStream(new FileInputStream(dataFile)));
            System.out.println("Reading from binary file " + dataFile);
            for (int i = 0 ; i < data.length ; i++) {
                double d = in.readDouble();
                System.out.println(d);
            }
        } finally {
            in.close();
        }
    }

    public void ObjectStreamExample() throws IOException, ClassNotFoundException {
        ObjectOutputStream out = null;
        ExampleClass example = new ExampleClass();

        try {
            out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(objectFile)));
            out.writeObject(example);
        } finally {
            out.close();
        }

        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(objectFile)));
            ExampleClass copy = (ExampleClass) in.readObject();
            System.out.println("Reading objectFile " + objectFile);
            System.out.println("Was " + example.x + " , " + example.y);
            System.out.println("Is " + copy.x + " , " + copy.y);
        } finally {
            in.close();
        }
    }
}