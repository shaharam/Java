package Maman12.question1;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PointsJPanel extends JPanel {
	ArrayList<Point> points_arr = new ArrayList<Point>();
	Boolean drawGraph = true;
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		pointCreate(g);
//		revalidate();
		repaint();
	}

	private void pointCreate(Graphics g) {
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
    	
	    points_arr.add(new Point(x, y));
	    
	    
		for (int i = 0; i < points_arr.size(); i++) {
			if (i == 0)
				g.fillOval(points_arr.get(i).x, points_arr.get(i).y, 10, 10);
			else {
				g.fillOval(points_arr.get(i).x, points_arr.get(i).y, 10, 10);
				g.drawLine(points_arr.get(i-1).x, points_arr.get(i-1).y, points_arr.get(i).x, points_arr.get(i).y);
				String distance = String.valueOf(Math.hypot(points_arr.get(i-1).x - points_arr.get(i).x, points_arr.get(i-1).y - points_arr.get(i).y));
				g.drawString(distance, (points_arr.get(i-1).x + points_arr.get(i).x) / 2, (points_arr.get(i-1).y + points_arr.get(i).y) / 2);
			}
//			revalidate();
//			repaint();
		}
	}
}
