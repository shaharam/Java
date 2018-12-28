package Maman13.question2;

public class Main {

	public static void main(String[] args) {
		Model m = new Model();
		View v = new View("Trivia");
		Controller c = new Controller(m, v); 
	}

}
