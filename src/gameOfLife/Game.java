package gameOfLife;

public class Game
{
	private Environment env;
	public int rows;
	public int cols;

	public Game(int rows, int cols, Coordinate[] liveCells)
	{
		env = new Environment(rows, cols);
		env.setLiveCells(liveCells);
		this.rows = rows;
		this.cols = cols;
	}

	public Environment getEnv()
	{
		return env;
	}

	public void play(int iterations)
	{
		env.print();
		for (int i = 0; i <= iterations; i++)
		{
			System.out.print('\f');
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			env.iterate();
			env.print();
		}
	}
}
