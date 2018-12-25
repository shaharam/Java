package Maman13.question2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Controller implements ActionListener {
	private Model model;
	private View view;
	private Timer timer;
	private int counter = 14;
	private JLabel timer_lbl;
	private int score;

	public Controller(Model m, View v) {
		this.model = m;
		this.view = v;
		timer_lbl = new JLabel(Integer.toString(counter+1));
		timer_lbl.setPreferredSize(new Dimension(100, 100));
		timer_lbl.setFont(new Font("Serif", Font.PLAIN, 40));
		view.submit.addActionListener(this);
		view.main_panel.add(timer_lbl, BorderLayout.LINE_END);
		displayQuestion();
		timer = new Timer(1000, new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e) {
				if (counter == -1) {
					timer.stop();
					JOptionPane.showMessageDialog(null, "Time is over!");
					removeQuestion();
					displayQuestion();
					//TODO: Add -5 points to here?
					counter = 15;
					timer.restart();
				}
                timer_lbl.setText(String.valueOf(counter));
                counter--;
            }
		});
		timer.start();
		
	}
	
	private void displayQuestion() {
		if (model.questions.size() > 0) {
			Question q = model.getQuestion();
			view.question.setText(q.getQuestionText());
			for (int i=0; i<4; i++) {
				view.answers[i].setText(q.getAnswers().get(i));
				view.answers[i].setActionCommand(q.getAnswers().get(i));
			}
		}
//		else
//			gameFinished();
	}
	
	private void checkAnswer() {
		if (view.radioGroup.getSelection().getActionCommand().equals(model.getQuestion().getRightAnswer()))
			this.score+=10;
		for (int i=0; i<3; i++) {
			if (view.answers[i].getText().equals(model.getQuestion().getRightAnswer()))
				for (int j=0; j<10; j++) {
					view.answers[i].setForeground(Color.GREEN);
					//sleep
					view.answers[i].setForeground(Color.BLACK);					
				}
		}
	}
	
	private void removeQuestion() {
		model.questions.remove(0);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		if (button == "submit")
			checkAnswer();
	}
	
}
