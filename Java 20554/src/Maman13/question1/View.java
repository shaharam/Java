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
		setBounds(1000, 50, 550, 550);
		setResizable(false);
		main_panel = new JPanel();
		
		//Adding panels to main JPanel
		colorIndication();
		tableDraw();
		buttonsDraw();
		clearDraw();
		
		add(main_panel);
		setVisible(true);
	}

	private void colorIndication() {	//Add players color indication
		JLabel player_1 = new JLabel("Player 1 =");
		JLabel red_color = new JLabel("RED");
		red_color.setForeground(Color.RED);
		JLabel player_2 = new JLabel("Player 2 =");
		JLabel blue_color = new JLabel("BLUE");
		blue_color.setForeground(Color.BLUE);
		main_panel.add(player_1);
		main_panel.add(red_color);
		main_panel.add(player_2);
		main_panel.add(blue_color);
	}
	
	private void tableDraw() {	//Create matrix of panels
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
	}


	private void buttonsDraw() {	//Create panel of buttons
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
	}
	
	private void clearDraw() {	//Create clear button
		clear = new JButton("Clear");
		clear.setActionCommand("clear");
		clear.addActionListener(this);
		main_panel.add(clear);
	}
	
	private void resetGame() {
		for (int row=0; row < rows; row++) {
			for (int col=0; col < cols; col++) {
				cells[row][col].removeAll();
			}
		}
		repaint();
		model.newGame();
	}
	
	private void checkDraw() {
		if (Model.cells_left == 0) {
			int res = JOptionPane.showConfirmDialog(null, "Game status: DRAW\nNew game?", "DRAW", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (res == 0)
				resetGame();
			else
				System.exit(0);
		}
	}
	
	private void winner() {
		int res = JOptionPane.showConfirmDialog(null, "Game status: Player " + Model.player + " WON!" + "\nNew game?", "WIN", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if (res == 0)
			resetGame();
		else
			System.exit(0);
		}
	
	private void changePlayer() {
		if (Model.player == 1)
    		Model.player = 2;
    	else
    		Model.player = 1;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if (button.equals("clear")) {
			resetGame();
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
				checkDraw();
				if (model.checkWin(row, col))
					winner();
				changePlayer();
			}
		}
	}	
}
