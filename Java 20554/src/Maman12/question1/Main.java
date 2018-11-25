package Maman12.question1;
import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Graph");
		PointsJPanel panel = new PointsJPanel();
		
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(400, 400);
	    frame.setLocation(950, 100);
	    frame.add(panel);
	    frame.setVisible(true);
	    
	    while (true) {
		    String x_str = JOptionPane.showInputDialog("Enter the X coordinate between 0-400");
		    if (x_str.isEmpty()) {
		    	JOptionPane.showMessageDialog(null, "Program aborted by user", "Program Aborted", JOptionPane.INFORMATION_MESSAGE);
		    	System.exit(0);
		    }
		    int x = Integer.parseInt(x_str);
	    	while (x < 0 || x > 400) {
	    		x = Integer.parseInt(JOptionPane.showInputDialog(null, "X coordinate should be between 0-400", "Wrong number", JOptionPane.WARNING_MESSAGE));
	    	}
	    	
		    String y_str = JOptionPane.showInputDialog("Enter the Y coordinate between 0-400");
		    if (y_str.isEmpty()) {
		    	JOptionPane.showMessageDialog(null, "Program aborted by user", "Program Aborted", JOptionPane.INFORMATION_MESSAGE);
		    	System.exit(0);
		    }
		    int y = Integer.parseInt(y_str);
	    	while (y < 0 || y > 400) {
	    		y = Integer.parseInt(JOptionPane.showInputDialog(null, "Y coordinate should be between 0-400", "Wrong number", JOptionPane.WARNING_MESSAGE));
		    }
	    	
	    	panel.createPoint(x, y);
	    }
	}
}

