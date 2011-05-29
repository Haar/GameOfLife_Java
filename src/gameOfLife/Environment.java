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

	public Cell cellAt(int x, int y)
	{
		return env[x][y];
	}

	public int neighboursOf(int x, int y)
	{
		int neighbourCount = 0;

		if (x == 0 && y == 0)
			neighbourCount = calculateTopLeftCornerNeighbours();
		else if (x == 0 && y == ROWS-1)
			neighbourCount = calculateTopRightCornerNeighbours();

		return neighbourCount;
	}

	private int calculateTopLeftCornerNeighbours()
	{
		int neighbourCount = 0;

		for (int i = 0; i < 2; i++)
		{
			for (int j = 0; j < 2; j++)
			{
				if (i > 0 || j > 0)
				{
					if (cellAt(i,j).alive)
						neighbourCount++;
				}
			}
		}
		return neighbourCount;
	}

	private int calculateTopRightCornerNeighbours()
	{
		int neighbourCount = 0;

		for (int i = ROWS - 2; i < ROWS; i++)
		{
			for (int j = 0; j < 2; j++)
			{
				if  (i != (ROWS-1) || j != 0)
				{
					System.out.println("Row: "+i+" Col: "+j);
					System.out.println("Cell Status: "+cellAt(i,j).alive);
					if(cellAt(i,j).alive)
						neighbourCount++;
				}
			}
		}
		return neighbourCount;
	}
}
