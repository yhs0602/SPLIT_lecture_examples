package com.kyhsgeekcode.gdczombie;

public class Zombie extends Unit{
	public Zombie(int ix, int iy)
	{
		super(ix,iy);
		Main.zombies.add(this);
	}
	private void setZombie() {
		return;
	}
}
