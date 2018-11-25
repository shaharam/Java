package Maman12.question1;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;

public class PointsJPanel extends JPanel {
	ArrayList<Point> points_arr = new ArrayList<Point>();
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		for (int i = 0; i < points_arr.size(); i++) {
			if (i == 0)
				g.fillOval(points_arr.get(i).x, points_arr.get(i).y, 10, 10);
			else {
				g.fillOval(points_arr.get(i).x, points_arr.get(i).y, 10, 10);
				g.setColor(Color.RED);
				g.drawLine(points_arr.get(i-1).x, points_arr.get(i-1).y, points_arr.get(i).x, points_arr.get(i).y);
				String distance = String.valueOf(Math.hypot(points_arr.get(i-1).x - points_arr.get(i).x, points_arr.get(i-1).y - points_arr.get(i).y));
				g.setColor(Color.BLUE);
				g.drawString(distance, (points_arr.get(i-1).x + points_arr.get(i).x) / 2, (points_arr.get(i-1).y + points_arr.get(i).y) / 2);
			}
		}
		repaint();
	}
	
	public void createPoint(int x, int y) {
		points_arr.add(new Point(x, y));
		
	}
}
