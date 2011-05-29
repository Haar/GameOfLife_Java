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
		Coordinate[] liveCells = {new Coordinate(0,0), new Coordinate(0,1)};
		env.setLiveCells(liveCells);
		assertEquals(env.cellAt(0,0).alive, true);
		assertEquals(env.cellAt(0,1).alive, true);
	}

	@Test
	public void testGridCorrectlyCalculatesNeighboursForTopLeftCell()
	{
		Coordinate[] liveCells = {new Coordinate(0,0), new Coordinate(0,1), new Coordinate(1,0)};
		env.setLiveCells(liveCells);
		assertEquals(2, env.neighboursOf(0,0));
	}

	@Test
	public void testGridCorrectlyCalculatesNeighboursForTopRightCell()
	{
		Coordinate[] liveCells = {new Coordinate(3,0), new Coordinate(4,0), new Coordinate (4,1)};
		env.setLiveCells(liveCells);
		assertEquals(2, env.neighboursOf(0, 4));
	}
}
