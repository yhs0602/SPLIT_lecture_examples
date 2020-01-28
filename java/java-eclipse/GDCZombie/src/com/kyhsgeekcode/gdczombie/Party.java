package com.kyhsgeekcode.gdczombie;

public class Party extends Unit{
	public Party(int ix, int iy)
	{
		super(ix,iy);
		Main.parties.add(this);
	}
	private void setZombie() {
		Main.parties.remove(this);
	}
}
