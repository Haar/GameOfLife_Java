package gameOfLife;

import static org.junit.Assert.*;
import org.junit.*;

public class EnvironmentTest {

	private Environment env;

	@Before
	public void SetUpDefaulGrid()
	{
		env = new Environment();
	}

	@Test
	public void testDefaultGridContainsNoLiveCells()
	{
		Cell defCell = env.cellAt(0,0);
		assertEquals(defCell.alive, false);
	}

	@Test
	public void testGridGivenLiveCellsHasLiveCellsAtGivenCoOrdinates()
	{
		Coordinate[] liveCells = {new Coordinate(0, 0), new Coordinate(0,1)};
		env = new Environment();
		env.setLiveCells(liveCells);
		assertEquals(env.cellAt(0,0).alive, true);
		assertEquals(env.cellAt(0,1).alive, true);
	}

}
