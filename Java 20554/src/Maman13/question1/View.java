package Maman13.question1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class View {
	private JFrame frame;
	private JPanel main_panel;
	private JPanel table;
	private JPanel button_panels;
	private JLabel[][] cells;
	private JButton[] buttons;
	private JButton clear;
	private final int cols = 7;
	private final int rows = 6;
	
	public View(String title) {
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(1000, 50, 500, 550);
		main_panel = new JPanel();
		createTablePanel();
		createButtonsPanel();
		createClearButton();
		main_panel.add(table);
		main_panel.add(button_panels);
		main_panel.add(clear);
		frame.add(main_panel);
		frame.setVisible(true);
	}
	
	private void createTablePanel() {
		table = new JPanel();
		table.setPreferredSize(new Dimension(500, 400));
		table.setLayout(new GridLayout(rows, cols));
		cells = new JLabel[rows][cols];
		for (int col = 0; col < cols; col++) {
			for (int row = 0; row < rows; row++) {
				cells[row][col] = new JLabel();
				cells[row][col].setHorizontalAlignment(SwingConstants.CENTER);
				cells[row][col].setBorder(new LineBorder(Color.black));
				table.add(cells[row][col]);
			}
		}
	}
	
	private void createButtonsPanel() {
		buttons = new JButton[cols];
		button_panels = new JPanel();
		button_panels.setLayout(new GridLayout(1, 7));
		button_panels.setPreferredSize(new Dimension(500, 50));
		for (int i = 0; i < cols; i++) {
			buttons[i] = new JButton("" + (i + 1));
			button_panels.add(buttons[i]);
		}
	}
	
	private void createClearButton() {
		clear = new JButton("Clear");
	}
}
