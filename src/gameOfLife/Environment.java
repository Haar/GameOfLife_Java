package gameOfLife;

public class Environment
{

	private Cell[][] env;
	private final int ROWS;
	private final int COLS;

	public Environment(int rows, int cols)
	{
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

	public void setLiveCells(Coordinate[] liveCells)
	{
		setAllCellsDead();

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

		for (int i = x - 1; i < x+2; i++)
		{
			for (int j = y-1; j < y+2; j++)
			{
				if ((i != x || j != y) && i < ROWS && j < COLS && i >= 0 && j >= 0)
				{
					if (cellAt(i,j).alive)
						neighbourCount++;
				}

			}
		}
		return neighbourCount;
	}

	public void iterate()
	{
		for (int i = 0; i < ROWS; i++)
		{
			for (int j = 0; j < COLS; j++)
			{
				env[i][j].neighbours = neighboursOf(i,j);
			}
		}

		for (int i = 0; i < ROWS; i++)
		{
			for (int j = 0; j < COLS; j++)
			{
				env[i][j].iterate();
			}
		}
	}

	public int[][] visual()
	{
		int[][] visual = new int[ROWS][COLS];

		for (int i = 0; i < ROWS; i++)
		{
			for (int j = 0; j < COLS; j++)
			{
				if(env[i][j].alive)
					visual[i][j] = 1;
				else
					visual[i][j] = 0;
			}
		}
		return visual;
	}

	public String getRow(int y)
	{
		int[][] visual = visual();
		StringBuffer row = new StringBuffer();

		for (int i = 0; i < ROWS; i++)
			row.append(visual[i][y]);

		return row.toString();
	}

	public void print() {
		for (int i = 0; i < COLS; i++)
			System.out.println(getRow(i));
	}
}
