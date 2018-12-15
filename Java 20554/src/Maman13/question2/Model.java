package Maman13.question2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Model {
	private ArrayList<Question> questions;
	
	public Model() {
		try {
			Scanner input = new Scanner(new File("trivia.txt"));
			this.questions = new ArrayList<Question>();
			String[] questionTemp = new String[5];
			while (input.hasNext()) {
				for (int i=0; i<5; i++) {
					questionTemp[i] = input.nextLine();
				}
				this.questions.add(new Question(questionTemp));
			}
		input.close();
		}
		
		catch (IOException e) {
			System.out.println("Unable to open file!");
			e.printStackTrace();
		}
	}
}