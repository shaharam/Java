package Maman13.question2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class View extends JFrame {
	private JFrame frame;
	protected JPanel main_panel;
	protected JLabel question;
	protected JRadioButton[] answers;
	protected ButtonGroup radioGroup;
	private JPanel panelAnswers;
	private JPanel buttonsPanel;
	private JPanel submitPanel;
	private JButton submit;
	private JButton newGame;
	private JButton quit;
	private Model model;
	
	public View(String title, Model m) {
		this.model = m;
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setBounds(500, 300, 800, 500);
		main_panel = new JPanel();
		main_panel.setLayout(new BorderLayout());
		
		question = new JLabel();
		question.setPreferredSize(new Dimension(50, 100));
		question.setFont(new Font("Serif", Font.PLAIN, 20));
		main_panel.add(question, BorderLayout.PAGE_START);
		
		panelAnswers = new JPanel();
		panelAnswers.setLayout(new BoxLayout(panelAnswers, BoxLayout.Y_AXIS));
		panelAnswers.setPreferredSize(new Dimension(600, 100));
		answers = new JRadioButton[4];
		radioGroup = new ButtonGroup();
		for (int i=0; i<answers.length; i++) {
			answers[i] = new JRadioButton();
			radioGroup.add(answers[i]);
			panelAnswers.add(answers[i]);
		}
		answers[0].setSelected(true); //Check the first radio button by default in order to avoid clicking the submit button without selection
		main_panel.add(panelAnswers, BorderLayout.LINE_START);
		
		submit = new JButton("SUBMIT");
		submit.setActionCommand("submit");
		submit.setPreferredSize(new Dimension(300, 100));
		submitPanel = new JPanel();
		submitPanel.add(submit);

		buttonsPanel = new JPanel(new BorderLayout());
		buttonsPanel.add(submitPanel, BorderLayout.PAGE_START);
		
		newGame = new JButton("Start New Game");
		newGame.setPreferredSize(new Dimension(150, 30));
		buttonsPanel.add(newGame, BorderLayout.LINE_START);
		
		quit = new JButton("Quit game");
		quit.setPreferredSize(new Dimension(150, 30));
		buttonsPanel.add(quit, BorderLayout.LINE_END);
		
		main_panel.add(buttonsPanel, BorderLayout.PAGE_END);
		
		setContentPane(main_panel);
		frame.add(main_panel);
		frame.setVisible(true);
	}
	
	

}
