package com.kyhsgeekcode.gdczombie;

public class Player {
	String name;
	int leftMovements;
	public boolean canMove(int amount)
	{
		return leftMovements >= amount;
	}
	public void Move(int amount)
	{
		leftMovements -= amount;
	}
	public Player()
	{
		this.leftMovements = LEFTMOVEMENT; 
	}
	public void NewTurn()
	{
		this.leftMovements = LEFTMOVEMENT; 
	}
	public int getLeftMovements()
	{
		return leftMovements;
	}
	static final int LEFTMOVEMENT = 10;
}
