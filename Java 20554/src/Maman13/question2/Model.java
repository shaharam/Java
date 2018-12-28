package Maman13.question2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Model {
	protected static final int ANSWERS_PER_QUESTIONS = 4;
	private Scanner input;
	protected ArrayList<Question> questions;
	
	public Model() {
		startGame();
	}
	
	public void startGame() {
		try  {
			input = new Scanner(new File("trivia.txt")); //trivia file should be on project main folder
			initQuestions();
			input.close();
		}
		catch (IOException e) {
			System.out.println("Unable to open file!");
			e.printStackTrace();
		}
	}
	
	public void initQuestions() {
		this.questions = new ArrayList<Question>();
		String[] questionTemp = new String[ANSWERS_PER_QUESTIONS+1];
		while (input.hasNext()) {
			for (int i=0; i<ANSWERS_PER_QUESTIONS+1; i++) {
				questionTemp[i] = input.nextLine();
			}
			this.questions.add(new Question(questionTemp));
		}
		Collections.shuffle(this.questions); //shuffle the questions
	}

	public Question getQuestion() {
		return this.questions.get(0); //return the first question every time because questions are removed after displayed
	}
}
