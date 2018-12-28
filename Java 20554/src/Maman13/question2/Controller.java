package Maman13.question2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Controller implements ActionListener {
	private Model model;
	private View view;
	private Timer timer;
	private final int TIME_FOR_ANSWER = 15;
	private final int CORRECT_ANSWER = 10;
	private final int WRONG_ANSWER = 5;
	private int counter = TIME_FOR_ANSWER-1;
	private JLabel timer_lbl;
	private int score;

	public Controller(Model m, View v) {
		this.model = m;
		this.view = v;
		createTimerLabel();
		addListeners();
		displayQuestion(); //Display question for the first time
		timer = new Timer(1000, new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
				if (counter == -1) { //if time is over
					timer.stop();
					score-=WRONG_ANSWER;
					JOptionPane.showMessageDialog(null, "Time is over!");
					nextQuestion();
				}
                timer_lbl.setText(String.valueOf(counter));
                counter--;
            }
		});
		timer.start();
	}
	
	private void addListeners() {
		view.submit.addActionListener(this);
		view.newGame.addActionListener(this);
		view.quit.addActionListener(this);
	}

	private void createTimerLabel() {
		timer_lbl = new JLabel(Integer.toString(TIME_FOR_ANSWER));
		timer_lbl.setPreferredSize(new Dimension(100, 100));
		timer_lbl.setFont(new Font("Serif", Font.PLAIN, 40));
		view.main_panel.add(timer_lbl, BorderLayout.LINE_END);
	}

	private void displayQuestion() {
		int input;
		if (model.questions.size() > 0) { //check if question exists in the arraylist
			Question q = model.getQuestion(); //get the question object
			view.question.setText(q.getQuestionText());
			view.answers[0].setSelected(true);	//Check the first radio button by default for better appearance and to avoid 'submit' without a selection
			for (int i=0; i<Model.ANSWERS_PER_QUESTIONS; i++) {
				view.answers[i].setText(q.getAnswers().get(i));
				view.answers[i].setActionCommand(q.getAnswers().get(i));
			}
		}
		else {
			input = JOptionPane.showConfirmDialog(null, "Game is over!\nYour score is: " + String.valueOf(this.score) + "\nNew game?", "Game Over", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (input == 0)
				newGame();
			else //No or X button
				System.exit(0);
		}
	}
	
	private void newGame() {
		this.score = 0; //reset score
		model.startGame();
		displayQuestion();
		resetCounter();
	}

	private void checkAnswer() {
		if (view.radioGroup.getSelection().getActionCommand().equals(model.getQuestion().getRightAnswer())) { //if answer is correct
			JOptionPane.showMessageDialog(null, "Correct answer!", null, JOptionPane.INFORMATION_MESSAGE);
			this.score+=CORRECT_ANSWER;
		}
		else {
			JOptionPane.showMessageDialog(null, "Wrong answer!", null, JOptionPane.WARNING_MESSAGE);
			this.score-=WRONG_ANSWER;
		}
		nextQuestion();
	}
	
	private void removeQuestion() { //removing question from arraylist
		model.questions.remove(0);
	}
	
	private void nextQuestion() {
		removeQuestion();
		displayQuestion();
		resetCounter();
	}
	
	private void resetCounter() { //reset the counter every new question or new game
		counter = TIME_FOR_ANSWER;
		timer.restart();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if (button == "submit") {
			timer.stop();
			checkAnswer();
		}
		else if (button == "new")
			newGame();
		else { //quit button pressed
			System.exit(0);
		}
	}
}