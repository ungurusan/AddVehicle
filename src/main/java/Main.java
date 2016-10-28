import javax.swing.*;

/**
 * Created by Alin on 10/28/2016.
 */
public class Main {

    public static void main(String[] args) {
        JFrame mainFrame = new JFrame("AddVehicle");
        mainFrame.setSize(640, 480);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
        




        mainFrame.add(contentPanel);
        mainFrame.setLocationRelativeTo ( null );
        mainFrame.setVisible(true);
    }
}
