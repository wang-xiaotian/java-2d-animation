import javax.swing.*;
import java.awt.*;

class MyFrame extends JFrame {

    GameMapPanel panel;
    MyFrame(){
        panel = new GameMapPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(800, 600));
        this.pack(); // fit preferred size
        this.add(panel); // include my gameMapPanle
        this.setLocationRelativeTo(null); // will alien to main panel
        this.setVisible(true);
    }
}
