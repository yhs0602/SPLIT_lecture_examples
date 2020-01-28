package com.kyhsgeekcode.gdczombie;

public class Civilian extends Unit{
	public Civilian(int ix, int iy)
	{
		super(ix,iy);
		Main.civilians.add(this);
	}
	private void setZombie() {
		Main.civilians.remove(this);
	}
}
