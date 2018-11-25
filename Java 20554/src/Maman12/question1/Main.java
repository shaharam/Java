package Maman12.question1;
import java.awt.Color;
import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Graph");
		PointsJPanel panel = new PointsJPanel();
		
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setBackground(Color.WHITE);
	    frame.setSize(400, 400);
	    frame.setLocation(1000, 100);
	    frame.add(panel);
	    frame.setVisible(true);
	}
}

