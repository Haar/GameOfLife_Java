package gameOfLife;

public class Cell {

	public boolean alive;
	public int neighbours;
	
	public void iterate() {
		if (neighbours == 3)
			alive = true;
		else if (alive && neighbours == 2)
			alive = true;
		else 
			alive = false;
	}
}
