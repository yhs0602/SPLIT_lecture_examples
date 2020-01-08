package com.kyhsgeekcode.gdczombie;

public class Board {
	Unit unit;
	public boolean hasUnit()
	{
		return this.unit != null;
	}
	public void SetUnit(Unit unit)
	{
		this.unit = unit;
		Main.Invalidate();
	}
	public void Bye()
	{
		unit = null;
	}
	
	public boolean hasBaricade[] = new boolean[] {false,false,false,false};
	public Unit getUnit() {
		// TODO Auto-generated method stub
		return unit;
	}
	public void SetBaricade(Orientation ori, boolean has)
	{
		hasBaricade[ori.ordinal()] = has;
	}
	public boolean hasBaricadee(Orientation orientation) {
		if(orientation ==null)
			return false;
		return hasBaricade[orientation.ordinal()];
	}
}
