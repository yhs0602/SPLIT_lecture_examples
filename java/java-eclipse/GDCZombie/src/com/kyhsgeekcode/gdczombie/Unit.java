package com.kyhsgeekcode.gdczombie;

public class Unit {
	int x, y;
	public Unit(int ix, int iy)
	{
		this.x = ix;
		this.y = iy;
	}
	public void moveTo(int i, int j) {
		if(i>= Main.boards.length || i <0)
			return;
		
		if(j>= Main.boards.length || j <0)
			return;
		
		if(Main.boards[i][j].hasUnit())
		{
			Unit theUnit = Main.getUnit(i, j);
			if(this instanceof Zombie)
			{
				if(theUnit instanceof Zombie)
					return;
				theUnit.Die();
				Main.boards[i][j].SetUnit(new Zombie(i,j));
				return;
			} else if(this instanceof Party)
			{
				if(theUnit instanceof Civilian)
				{
					theUnit.Die();
					Main.boards[i][j].SetUnit(new Party(i,j));
					return;
				} else if(theUnit instanceof Zombie)
				{
					
				}
			} else if(this instanceof Civilian)
			{
				if(theUnit instanceof Zombie)
				{
					this.Die();
					Main.boards[x][y].SetUnit(new Zombie(x,y));
				}
				
			}
		} else {
			Main.boards[x][y].Bye();
			x = i;
			y = j;
			Main.boards[x][y].SetUnit(this);
		}
	}
	
	private void Die() {
		Main.unitToList.get(this.getClass()).remove(this);
	}
	
	public void move()
	{
		Orientation orie = Orientation.values()[Main.random.nextInt(3)];
		int dx=0, dy=0;
		switch(orie)
		{
		case east:
			dx = 1;
			dy = 0;
			break;
		case west:
			dx = -1;
			dy = 0;
			break;
		case south:
			dx = 0;
			dy = 1;
			break;
		case north:
			dx = 0;
			dy = -1;
			break;
		}
		moveTo(x + dx,y + dy);
	}
	public boolean canPlayerControl(Player localPlayer) {
		return this instanceof Party;
	}
}
