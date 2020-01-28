package com.kyhsgeekcode.gdczombie;

public enum Orientation {
	east,
	west,
	south,
	north;
	public static Orientation[] vals = Orientation.values();
	public static final int [][] offsets = new int[][] {
			new int[] {1,0,1,1},
			new int[] {0,0,0,1},
			new int[] {0,1,1,1},
			new int[] {0,0,1,0}
			
			
	};
}
