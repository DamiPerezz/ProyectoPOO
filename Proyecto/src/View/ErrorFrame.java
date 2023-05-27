package View;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ErrorFrame extends JFrame{

	public ErrorFrame(String msj) {
	super("Error");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(300, 100);
    setLocationRelativeTo(null);

    JLabel label = new JLabel(msj);
    add(label);
	}
}
