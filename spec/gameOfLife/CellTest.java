package gameOfLife;

import static org.junit.Assert.*;
import org.junit.*;

public class CellTest {

	private Cell cell;

	@Before
	public void DefaultCellSetup()
	{
		cell = new Cell();
	}

	@Test
	public void NewCellShouldBeDead()
	{
		assertEquals(cell.alive, false);
	}

	@Test
	public void LiveCellWithFewerThanTwoNeighboursShouldDie()
	{
		cell.alive = true;
		cell.neighbours = 1;
		cell.iterate();
		assertEquals(cell.alive, false);
	}

	@Test
	public void LiveCellWithMoreThanThreeNeighboursShouldDie()
	{
		cell.alive = true;
		cell.neighbours = 4;
		cell.iterate();
		assertEquals(cell.alive, false);
	}
	
	@Test
	public void DeadCellWithMoreThanThreeNeighboursShouldStayDead()
	{
		cell.alive = false;
		cell.neighbours = 4;
		cell.iterate();
		assertEquals(cell.alive, false);
	}

	@Test
	public void LiveCellWithThreeNeighboursShouldBeAlive()
	{
		cell.alive = true;
		cell.neighbours = 3;
		cell.iterate();
		assertEquals(cell.alive, true);
	}

	@Test
	public void DeadCellWithThreeNeighboursShouldComeBackToLife()
	{
		cell.alive = false;
		cell.neighbours = 3;
		cell.iterate();
		assertEquals(cell.alive, true);
	}
	
	@Test
	public void DeadCellWithTwoNeighboursShouldStayDead()
	{
		cell.alive = false;
		cell.neighbours = 2;
		cell.iterate();
		assertEquals(cell.alive, false);
	}

	@Test
	public void LiveCellWithTwoNeighboursShouldBeAlive()
	{
		cell.alive = true;
		cell.neighbours = 2;
		cell.iterate();
		assertEquals(cell.alive, true);
	}
}
