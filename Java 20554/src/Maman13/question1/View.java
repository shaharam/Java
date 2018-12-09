package Maman13.question1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class View extends JFrame implements ActionListener {
	private JPanel main_panel;
	private JPanel table;
	private Disc[][] cells = new Disc[rows][cols];
	private JPanel button_panels;
	private JButton[] buttons;
	private JButton clear;
	public static final int cols = 7;
	public static final int rows = 6;
	private Model model;
	
	public View(String title, Model m) {
		super(title);
		model = m;
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(1000, 50, 530, 530);
		setResizable(false);
		main_panel = new JPanel();
		
		//Create matrix of panels
		table = new JPanel();
		table.setPreferredSize(new Dimension(500, 400));
		table.setLayout(new GridLayout(rows, cols));
		for (int row=0; row < rows; row++) {
			for (int col=0; col < cols; col++) {
				cells[row][col] = new Disc();
				cells[row][col].setBorder(BorderFactory.createLineBorder(Color.black));
				table.add(cells[row][col]);
			}
		}
		main_panel.add(table);
		
		//Create panel of buttons
		button_panels = new JPanel();
		button_panels.setLayout(new GridLayout(1, cols));
		button_panels.setPreferredSize(new Dimension(500, 50));
		buttons = new JButton[cols];
		for (int i=0; i < cols; i++) {
			buttons[i] = new JButton("" + (i + 1));
			buttons[i].setActionCommand("" + i);
			buttons[i].addActionListener(this);
			button_panels.add(buttons[i]);
		}
		main_panel.add(button_panels);

		//Create clear button
		clear = new JButton("Clear");
		clear.setActionCommand("clear");
		clear.addActionListener(this);
		main_panel.add(clear);
		
		add(main_panel);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if (button.equals("clear")) {
//			cells = new Disc[rows][cols];
			for (int row=0; row < rows; row++) {
				for (int col=0; col < cols; col++) {
					cells[row][col] = new Disc();
					cells[row][col].setBorder(BorderFactory.createLineBorder(Color.black));
					table.add(cells[row][col]);
				}
			}
//			setContentPane(main_panel);
			model.newGame();
		}
		else {
			int col = Integer.parseInt(button);
			if (model.colIsFull(col))
				JOptionPane.showMessageDialog(null, "Column is full. Please choose other column", "Column is full", JOptionPane.WARNING_MESSAGE);
			else {
			int row = model.getEmptyCell(col);
			Disc d = model.discAdd(row,col);
			d.setPreferredSize(new Dimension(50, 50));
			cells[row][col].add(d);
			setContentPane(main_panel);
			}
		}
	}	
}
