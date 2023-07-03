public class Generation {

private int[][] grid;
private int rows;
private int cols;
private static char live = '@';
private static char dead = '*';

	public Generation(int rows, int cols) {
		grid = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				grid[i][j] = (int)(Math.random() * 2);
			}
		}
		this.rows = rows;
		this.cols = cols;
	}

	public Generation(int[][] grid) {
		this.grid = grid;
		rows = grid.length;
		cols = grid[0].length;
	}

	public Generation next() {//generates the next generation
		int[][] next = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				next[i][j] = nextCell(i, j);		
			}
		}
		return new Generation(next);
	}

	private int nextCell(int x, int y) {//given the coords of a cell, compute what it will become in the next generation
		int count = 0;
		for (int dX = -1; dX <= 1; dX++) {//dX and dY are offsets to check neighbors in a 3x3 area around a cell
			for (int dY = -1; dY <= 1; dY++) {
				count += (x+dX >= 0 && x+dX < rows && y+dY >= 0 && y+dY < cols) ? (grid[x+dX][y+dY]) : (0);	
			}
		}
		count -= grid[x][y];//doesn't count itself

		int nextCell = grid[x][y];//the next cell starts out as being the current cell and only changes if the rules apply
		if (grid[x][y] == 0 && count == 3) {
		       	nextCell = 1;
	       	} else if (grid[x][y] == 1 && (count < 2 || count > 3)) {
		       	nextCell = 0;
	       	}

		return nextCell;
	}

	public static void setLive(char c) {
		live = c;
	}

	public static void setDead(char c) {
		dead = c;
	}

	public String toString() {
		String output = "";
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				output += (grid[i][j] == 1) ? live : dead;
				output += '\s';
			}
			output += '\n';
		}
		return output;
	}










}
