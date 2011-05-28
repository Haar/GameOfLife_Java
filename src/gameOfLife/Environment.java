package gameOfLife;

public class Environment {

	private Cell[][] env;
	private final int ROWS;
	private final int COLS;

	public Environment(int rows, int cols) {
		env = new Cell[rows][cols];
		ROWS = rows;
		COLS = cols;
		setAllCellsDead();
	}

	public Environment()
	{
		ROWS = 5;
		COLS = 10;
		env = new Cell[ROWS][COLS];
		setAllCellsDead();
	}

	public void setLiveCells(Coordinate[] liveCells) {
		for (Coordinate cell : liveCells)
		{
			env[cell.x][cell.y].alive = true;
		}
	}

	private void setAllCellsDead()
	{
		for (int r = 0; r < ROWS; r++)
		{
			for (int c = 0; c < COLS; c++)
			{
				env[r][c] = new Cell();
			}
		}
	}

	public Cell cellAt(int i, int j) {
		return env[i][j];
	}
}
