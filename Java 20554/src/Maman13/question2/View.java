package Maman13.question2;

import java.awt.*;

import javax.swing.*;

public class View extends JFrame{
	private JFrame frame;
	private JPanel main_panel;
	private JLabel question;
	private ButtonGroup radioAnswers;
	private JPanel panelAnswers;
	private JPanel buttonsPanel;
	private JPanel submitPanel;
	private JButton submit;
	private JButton newGame;
	private JButton quit;
	
	public View(String title, Model m) {
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setBounds(500, 300, 800, 500);
		main_panel = new JPanel();
		main_panel.setLayout(new BorderLayout());
		
		question = new JLabel("How many kashios do you have?");
		question.setPreferredSize(new Dimension(50, 100));
		question.setFont(new Font("Serif", Font.PLAIN, 20));
		main_panel.add(question, BorderLayout.PAGE_START);
		
		JRadioButton answerOne = new JRadioButton("1");
		JRadioButton answerTwo = new JRadioButton("2");
		JRadioButton answerThree = new JRadioButton("3");
		JRadioButton answerFour = new JRadioButton("4");
		
		radioAnswers = new ButtonGroup();
		radioAnswers.add(answerOne);
		radioAnswers.add(answerTwo);
		radioAnswers.add(answerThree);
		radioAnswers.add(answerFour);
		
		panelAnswers = new JPanel();
		panelAnswers.setLayout(new BoxLayout(panelAnswers, BoxLayout.Y_AXIS));
		panelAnswers.add(answerOne);
		panelAnswers.add(answerTwo);
		panelAnswers.add(answerThree);
		panelAnswers.add(answerFour);
		panelAnswers.setPreferredSize(new Dimension(600, 100));
		main_panel.add(panelAnswers, BorderLayout.LINE_START);
		
		submit = new JButton("SUBMIT");
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
