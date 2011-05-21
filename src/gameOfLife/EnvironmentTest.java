package gameOfLife;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EnvironmentTest {

	@Test
	public void testDefaultGridContainsNoLiveCells()
	{
		Environment env = new Environment();
		assertEquals(env.population, 0);
	}
}
