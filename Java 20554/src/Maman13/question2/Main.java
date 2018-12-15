package Maman13.question2;

public class Main {

	public static void main(String[] args) {
		Model m = new Model();
		View v = new View("Trivia", m);
		Controller c = new Controller(m, v); 
	}

}
