package Maman13.question1;

import javax.swing.JOptionPane;

public class Model {
	private static final int cols = 7;
	private static final int rows = 6;
    protected int[][] matrix;
    static int cells_left = cols * rows;
    static int player=1;

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
//    	if (player == 1)
//    		player = 2;
//    	else
//    		player = 1;
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

	public boolean checkWin(int row, int col) {
		if (checkWinRow(row, col) || checkWinCol(row, col) || checkWinBackSlash(row, col) || checkWinForwardSlash(row, col))
			return true;
		return false;
	}
	
	private boolean checkWinRow(int row, int col) {
		int checkRow = 1;
		int i = col-1;
		while (i>=0 && matrix[row][i] == player) {
			checkRow++;
			i--;
		}
		int j = col+1;
		while (j<=6 && matrix[row][j] == player) {
			checkRow++;
			j++;
		}
		if (checkRow >= 4)
			return true;
		return false;
	}

	private boolean checkWinCol(int row, int col) {
		int checkCol = 1;
		int i = row-1;
		while (i>=0 && matrix[i][col] == player) {
			checkCol++;
			i--;
		}
		int j = row+1;
		while (j<=5 && matrix[j][col] == player) {
			checkCol++;
			j++;
		}
		if (checkCol >= 4)
			return true;
		return false;
	}
	
	private boolean checkWinBackSlash(int row, int col) {
		int checkBackSlash = 1;
		int i = row-1, j = col-1;
		while (i>=0 && j>=0 && matrix[i][j] == player) {
			checkBackSlash++;
			i--;
			j--;
		}
		int k = row+1, h = col+1;
		while (k<=5 && h<=6 && matrix[k][h] == player) {
			checkBackSlash++;
			k++;
			h++;
		}
		if (checkBackSlash >= 4)
			return true;
		return false;
	}
	
	private boolean checkWinForwardSlash(int row, int col) {
		int checkForwardSlash = 1;
		int i = row-1, j = col+1;
		while (i>=0 && j<=6 && matrix[i][j] == player) {
			checkForwardSlash++;
			i--;
			j++;
		}
		int k = row+1, h = col-1;
		while (k<=5 && h>=0 && matrix[k][h] == player) {
			checkForwardSlash++;
			k++;
			h--;
		}
		if (checkForwardSlash >= 4)
			return true;
		return false;
	}
}
