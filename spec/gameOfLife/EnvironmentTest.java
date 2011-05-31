package gameOfLife;

import static org.junit.Assert.*;
import org.junit.*;

public class EnvironmentTest {

	private Environment env;

	@Before
	public void SetUpDefaultGrid()
	{
		env = new Environment();
	}

	@Test
	public void testDefaultGridContainsNoLiveCells()
	{
		Cell defCell = env.cellAt(0,0);
		assertFalse(defCell.alive);
	}

	@Test
	public void testGridGivenLiveCellsHasLiveCellsAtGivenCoOrdinates()
	{
		Coordinate[] liveCells = {new Coordinate(0,0), new Coordinate(0,1)};
		env.setLiveCells(liveCells);
		assertTrue(env.cellAt(0,0).alive);
		assertTrue(env.cellAt(0,1).alive);
	}

	@Test
	public void testGridCorrectlyCalculatesNeighboursForTopLeftCell()
	{
		Coordinate[] liveCells = {new Coordinate(0,0), new Coordinate(0,1), new Coordinate(1,0)};
		env.setLiveCells(liveCells);
		assertEquals(2, env.neighboursOf(0,0));
	}

	@Test
	public void testGridCorrectlyCalculatesNeighboursForCorners()
	{
		Coordinate[] liveCells = {new Coordinate(3,0), new Coordinate(4,0), new Coordinate(4,1)};
		env.setLiveCells(liveCells);
		assertEquals(2, env.neighboursOf(4, 0));
	}

	@Test
	public void testGridCorrectlyCalculatesNeighboursForEdges()
	{
		Coordinate[] liveCells = {new Coordinate(0,2), new Coordinate(0,3), new Coordinate(0,4)};
		env.setLiveCells(liveCells);
		assertEquals(2, env.neighboursOf(0, 3));

	}

	@Test
	public void testGridCorrectlyCalculatesNeighboursForCellClusters()
	{
		Coordinate[] liveCells = {new Coordinate(1,1), new Coordinate (1,2), new Coordinate(1,3),
								  new Coordinate(2,1), new Coordinate (2,2),new Coordinate (2,3),
								  new Coordinate(3,1), new Coordinate(3,2), new Coordinate(3,3)};
		env.setLiveCells(liveCells);
		assertEquals(8, env.neighboursOf(2, 2));
	}

	@Test
	public void testGridCorrectlyIteratesOverMultipleGenerations()
	{
		Coordinate[] liveCells = {new Coordinate(1,3), new Coordinate(2,3), new Coordinate(3,3)};
		Coordinate[] secondGen = {new Coordinate(2,2), new Coordinate(2,3), new Coordinate(2,4)};
		Environment expectedEnv = new Environment();

		env.setLiveCells(liveCells);
		expectedEnv.setLiveCells(secondGen);
		env.iterate();

		assertArrayEquals(expectedEnv.visual(),env.visual());

		env.iterate();
		expectedEnv.setLiveCells(liveCells);

		assertArrayEquals(expectedEnv.visual(),env.visual());
	}

	@Test
	public void testGridCanGenerateContentForDisplayPurposes()
	{
		Coordinate[] liveCells = {new Coordinate(0,0), new Coordinate(3,0),
								  new Coordinate(1,3), new Coordinate(4,3)};
		env.setLiveCells(liveCells);

		assertEquals("10010", env.getRow(0));
		assertEquals("01001", env.getRow(3));
	}
}
