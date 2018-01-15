
public class Organism {

	int row, col, neighbors, totalRows, totalCols;
	boolean alive;
	public Organism(int row, int col, boolean alive) {
		this.row = row;
		this.col = col;
		this.alive = alive;
	}
	public boolean getAlive() {
		return alive;
	}
	public void setAlive(boolean set) {
		alive = set;
	}
	public void getUR(Organism[][] grid) {
		if(row + 1 < totalRows && col + 1 < totalCols) {
		if(grid[row+1][col+1].getAlive()) {
			neighbors++;
		}
		}

	}
	public void getUL(Organism[][] grid) {
		if(row + 1 < totalRows && col -1 > 0) {
		if(grid[row+1][col-1].getAlive()) {
			neighbors++;
		}
		}


	}
	public void getU(Organism[][] grid) {
		if(row + 1 < totalRows) {
		if(grid[row+1][col].getAlive()) {
			neighbors++;
		}
		}

	}
	public void getR(Organism[][] grid) {
		if(col + 1 < totalCols) {
		if(grid[row][col+1].getAlive()) {
			neighbors++;
		}
		}

	}
	public void getL(Organism[][] grid) {
		if(col - 1 > 0) {
		if(grid[row][col-1].getAlive()) {
			neighbors++;
		}
		}
	}
	public void getBR(Organism[][] grid) {
		if(row - 1 >0 && col + 1 > totalCols) 
		if(grid[row-1][col+1].getAlive()) {
			neighbors++;
		}

	}
	public void getBL(Organism[][] grid) {
		if(row -1 > 0 && col - 1 > 0) {
		if(grid[row-1][col-1].getAlive()) {
			neighbors++;
		}
		}

	}
	public void getB(Organism[][] grid) {
		if(row -1 > 0) {
		if(grid[row-1][col].getAlive()) {
			neighbors++;
		}
		}

	}
	public void step(Organism[][] grid) {
		neighbors = 0;
		totalRows = grid.length;
		totalCols = grid[0].length;
		getR(grid);
		getBR(grid);
		getUR(grid);
		getU(grid);
		getB(grid);
		getL(grid);
		getBL(grid);
		getUL(grid);
		if(alive) {
			if(neighbors <= 1) {
				this.alive = false;
			}
			else if(neighbors >= 4) {
				this.alive = false;
			}
			else if(neighbors == 2 || neighbors == 3) {
				this.alive = true;
			}
		}
		else if(!alive) {
			if(neighbors == 3) {
				this.alive = true;
			}
		}

	}
}
