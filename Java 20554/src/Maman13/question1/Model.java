package Maman13.question1;

import javax.swing.JOptionPane;

public class Model {
	private static final int cols = 7;
	private static final int rows = 6;
    protected int[][] matrix;
    static int cells_left = cols * rows;
    private static int player=1;

    public Model() {
        initMatrix();
    }
    
    public void initMatrix() {
    	matrix = new int[rows][cols];
    	cells_left = cols * rows;
    }
    
    public Disc discAdd(int row, int col) {
    	matrix[row][col] = player;
    	Model.cells_left--;
    	Disc temp = new Disc(player);
//    	checkWin(row, col);
    	if (player == 1)
    		player = 2;
    	else
    		player = 1;
    	return temp;
    }

	public int getEmptyCell(int col) {
		for (int i=rows-1; i>=0; i--) {
			if (matrix[i][col] == 0) {
				return i;
			}
		}
		return 0;
	}

	public boolean colIsFull(int col) {
		return matrix[0][col] != 0;
	}

	public void newGame() {
		initMatrix();
	}

	public void checkWin(int row, int col) {
		int checkRow = 1;
		for (int i=col-1; i>=0; i--)
			while (matrix[row][i] == player)
				checkRow++;
		for (int i=col+1; i<=6; i++)
			while (matrix[row][i] == player)
				checkRow++;
		if (checkRow >= 4)
			System.out.println("WINNER");
	}
}
