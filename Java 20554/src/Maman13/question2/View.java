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
	protected JButton submit;
	protected JButton newGame;
	protected JButton quit;
	
	public View(String title) {
		frame = new JFrame(title);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setBounds(500, 300, 800, 500);
		frame.setResizable(false);
		main_panel = new JPanel();
		main_panel.setLayout(new BorderLayout());
		createQuestionLabel();
		createAnswersPanel();
		createButtonsPanel();
		main_panel.add(buttonsPanel, BorderLayout.PAGE_END);
		setContentPane(main_panel);
		frame.add(main_panel);
		frame.setVisible(true);
	}

	private void createButtonsPanel() {
		buttonsPanel = new JPanel(new BorderLayout());
		createSubmitButton();
		createNewGameButton();
		createQuitButton();
		buttonsPanel.add(submitPanel, BorderLayout.PAGE_START);
		buttonsPanel.add(newGame, BorderLayout.LINE_START);
		buttonsPanel.add(quit, BorderLayout.LINE_END);
	}

	private void createQuitButton() {
		quit = new JButton("Quit game");
		quit.setActionCommand("quit");
		quit.setPreferredSize(new Dimension(150, 30));
	}

	private void createNewGameButton() {
		newGame = new JButton("Start New Game");
		newGame.setActionCommand("new");
		newGame.setPreferredSize(new Dimension(150, 30));
	}

	private void createSubmitButton() {
		submitPanel = new JPanel();
		submit = new JButton("SUBMIT");
		submit.setActionCommand("submit");
		submit.setPreferredSize(new Dimension(300, 100));
		submitPanel.add(submit);
	}

	private void createAnswersPanel() {
		panelAnswers = new JPanel();
		panelAnswers.setLayout(new BoxLayout(panelAnswers, BoxLayout.Y_AXIS));
		panelAnswers.setPreferredSize(new Dimension(600, 100));
		answers = new JRadioButton[Model.ANSWERS_PER_QUESTIONS];
		radioGroup = new ButtonGroup();
		for (int i=0; i<answers.length; i++) {
			answers[i] = new JRadioButton();
			radioGroup.add(answers[i]);
			panelAnswers.add(answers[i]);
		}
		main_panel.add(panelAnswers, BorderLayout.LINE_START);
	}

	private void createQuestionLabel() {
		question = new JLabel();
		question.setPreferredSize(new Dimension(50, 100));
		question.setFont(new Font("Serif", Font.PLAIN, 20));
		main_panel.add(question, BorderLayout.PAGE_START);
	}
}
