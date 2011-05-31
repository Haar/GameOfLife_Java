package gameOfLife;

import static org.junit.Assert.*;
import org.junit.*;

public class GameTest
{
	private Game game;

	@Test
	public void testGameInitialisesGridWithCorrectProperties()
	{
		int rows = 5;
		int cols = 10;
		Coordinate[] liveCells = {new Coordinate(1,3), new Coordinate(2,3), new Coordinate(3,3)};
		
		game = new Game(rows,cols,liveCells);
		
		Environment env = game.getEnv();
		Environment expectedEnv = new Environment(rows, cols);
		expectedEnv.setLiveCells(liveCells);
		
		assertEquals(5,game.rows);
		assertEquals(10,game.cols);
		assertArrayEquals(expectedEnv.visual(),env.visual());
	}
	
	@Test
	public void testGameRunsVisually()
	{
		Coordinate[] liveCells = {new Coordinate(1,3), new Coordinate(2,3), new Coordinate(3,3)};
		game = new Game(6,6,liveCells);
		game.play(100);
	}
}
