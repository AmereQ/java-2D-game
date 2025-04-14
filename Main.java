import javax.swing.JFrame;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Panel panel = new Panel();
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Demo");
        frame.setBounds(400,200,905,600);

        frame.add(panel);
    }
}