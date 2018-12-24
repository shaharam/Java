package Maman13.question2;

import java.util.ArrayList;
import java.util.Collections;

public class Question {
	private String question;
	private String rightAnswer;
	private ArrayList<String> answers;
	
	public Question(String[] ans) {
		this.question = ans[0];
		this.rightAnswer = ans[1];
		this.answers = new ArrayList<String>();
		this.answers.add(this.rightAnswer);
		for (int i=2; i<ans.length; i++)
			this.answers.add(ans[i]);
		Collections.shuffle(this.answers);
	}

	public String getQuestionText() {
		return question;
	}
	
	public String getRightAnswer() {
		return rightAnswer;
	}

	public ArrayList<String> getAnswers() {
		return answers;
	}
}
