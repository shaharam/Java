package Maman13.question1;

public class Model {
	private static final int cols = 7;
	private static final int rows = 6;
    protected int[][] matrix;
    private static int cells_left = cols * rows;
    private static int player=1;

    public Model() {
        initMatrix();
    }
    
    public void initMatrix() {
    	matrix = new int[rows][cols];
//    	for (int i = 0; i < rows; i++) {
//    		for (int j = 0; j < cols; j++) {
//                matrix[i][j] = 0;
//            }
//        }
    }
    
    public Disc discAdd(int row, int col) {
    	matrix[row][col] = player;
    	Model.cells_left--;
    	Disc temp = new Disc(player);
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
}
