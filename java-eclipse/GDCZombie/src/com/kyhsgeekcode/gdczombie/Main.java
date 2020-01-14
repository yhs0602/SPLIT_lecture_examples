package com.kyhsgeekcode.gdczombie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(); 
            }

			private void createAndShowGUI() {
				// TODO Auto-generated method stub
				System.out.println("Created GUI on EDT? "+
				        SwingUtilities.isEventDispatchThread());
				        frame = new JFrame("GDC Zombie game");
				        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				        JPanel panel = new JPanel();
				        frame.add(panel);
				        panel.add(mypanel = new MyPanel());
				        JButton nextButton = new JButton("Next Turn");
				        nextButton.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								//GetInput();
								MoveCivilians();
								if(MoveZombies())
								{
									nextButton.setEnabled(false);
								}
								PrintCircumstance();
								ApplyEventCard();
								PrintCircumstance();
								localplayer.NewTurn();
								mypanel.EnableInput();
							}
				        });
				        panel.add(nextButton);
				        frame.pack();
				        frame.setVisible(true);

			}
        });

		PrepareBoard();
		SpawnParties();
		SpawnCivilians();
		SpawnZombies();
		
		//PrintCircumstance();
		//CreateEventCards();
		//while(true)
		//{
			//ApplyEventCard();
			//GetInput();
			//MoveCivilians();
			//if(MoveZombies())
			//{
			//	break;
			//}
			//PrintCircumstance();
		//}
		
	}
	
	static final int BOARDSIZEX = 16;
	static final int BOARDSIZEY = 16;
	
	static Board [][] boards = new Board[BOARDSIZEX][BOARDSIZEY];

	static void PrepareBoard()
	{
		for(int i=0;i<boards.length;i++)
		{
			for(int j=0;j<boards[0].length;j++)
			{
				boards[i][j] = new Board();
			}
		}
	}
	static void SpawnParties()
	{
		for(int i=0; i<4; i++)
		{
			int x = random.nextInt(boards.length-1);
			int y = random.nextInt(boards[0].length-1);
			if(!boards[x][y].hasUnit())
				boards[x][y].SetUnit(new Party(x, y));
			else
				i--;
		}
	}
	
	static void SpawnCivilians()
	{
		for(int i=0; i<4; i++)
		{
			int x = random.nextInt(boards.length-1);
			int y = random.nextInt(boards[0].length-1);
			if(!boards[x][y].hasUnit())
				boards[x][y].SetUnit(new Civilian(x, y));
			else
				i--;
		}
	}
	static void SpawnZombies()
	{
		for(int i=0; i<4; i++)
		{
			int x = random.nextInt(boards.length-1);
			int y = random.nextInt(boards[0].length-1);
			if(!boards[x][y].hasUnit())
				boards[x][y].SetUnit(new Zombie(x, y));
			else
				i--;
		}
	}
	
	static void ApplyEventCard()
	{
		Field[] cards =  EventCard.class.getDeclaredFields();
		ArrayList<EventCard> ecards = new ArrayList<EventCard>();
		for(Field card: cards)
		{
			if(card.getType().equals(EventCard.class))
			{
				try {
					ecards.add((EventCard)card.get(null));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		ecards.get(random.nextInt(ecards.size()-1)).Apply();
	}
	
	static void MoveCivilians()
	{
		ArrayList<Civilian> az = new ArrayList<>();
		az.addAll(civilians);
		for(Civilian z: az)
		{
			z.move();
		}
		//return civilians.isEmpty() && parties.isEmpty();
	}
	
	static boolean MoveZombies()
	{
		ArrayList<Zombie> az = new ArrayList<>();
		az.addAll(zombies);
		for(Zombie z: az)
		{
			z.move();
		}
		return civilians.isEmpty() && parties.isEmpty();
	}
	
	static void GetInput()
	{
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			String command = sc.next();
			command = command.toLowerCase();
			if(command.compareTo("end")==0)
			{
				return;
			} else if (command.equals( "move")) {
				int from = sc.nextInt();
				//int to = sc.nextInt();
				int fx = from / Main.BOARDSIZEX;
				int fy = from % Main.BOARDSIZEX;
				//int tx = to % Main.BOARDSIZEX;
				//int ty = to / Main.BOARDSIZEX;
				String ori = sc.next();
				Orientation orie = Orientation.valueOf(ori);
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
				
				boards[fx][fy].getUnit().moveTo(fx + dx,fy + dy);
		//		int fx = getX(from);
		//		int fy = getY(from);
		//		int tx = getX(from);
		///		int ty = getY(from);
			} else if (command.equals( "bar"))
			{
				int from = sc.nextInt();
				int fx = from / Main.BOARDSIZEX;
				int fy = from % Main.BOARDSIZEX;
				String ori = sc.next();
				Orientation orie = Orientation.valueOf(ori);
				Main.boards[fx][fy].hasBaricade[orie.ordinal()]= true;
			}
			
		}
	}
	
	
	static void PrintCircumstance()
	{
		//frame.invalidate();
		mypanel.repaint();
		
		//for(int i=0; i< boards.length; i++)
		//{
		//	for(int j = 0; j < boards[0].length; j++)
		//	{
		//		System.out.print(getCharacter(boards[i][j]));
		//	}
		//	System.out.println();
		//}
	}
	
	public static Unit getUnit(int i, int j)
	{
		return boards[i][j].getUnit();
	}
	
	static String getCharacter(Board b)
	{
		if(b.hasUnit())
		{
			Unit u = b.getUnit();
			if(u instanceof Zombie)
			{
				return "좀";
			} if(u instanceof Civilian)
			{
				return "시";
			} if(u instanceof Party)
			{
				return "당";
			}
		}
		return "ㅡ";
	}
	public static void MessageBox(String msg, String title)
	{
		JOptionPane.showMessageDialog(null, 
				msg, 
				title, 
				JOptionPane.WARNING_MESSAGE);
	}
	/*
	static int getX(String s)
	{
		char [] cs = s.toCharArray();
		int i=0;
		String alphabet = "";
		while(i < cs. length && Character.isAlphabetic(cs[i]))
		{
			alphabet += cs[i];
		}
		
	}
	*/
	//static void CreateEventCards()
	//{
	//	
	//}
	static Random random = new Random();
	static ArrayList<Civilian> civilians = new ArrayList<>();
	static ArrayList<Zombie> zombies = new ArrayList<>();
	static ArrayList<Party> parties = new ArrayList<>();
	static HashMap<Class, ArrayList> unitToList = new HashMap<Class,ArrayList>();
	static {
		unitToList.put(Civilian.class, civilians);
		unitToList.put(Party.class, parties);
		unitToList.put(Zombie.class, zombies);
	}
	
	static JFrame frame;
	static MyPanel mypanel;
	static Player localplayer = new Player();
	public static Player getLocalPlayer() {
		// TODO Auto-generated method stub
		return localplayer;
	}
	public static int TaxiDist(int selectedI, int selectedJ, int i, int j) {
		return Math.abs(selectedI-i) + Math.abs(selectedJ-j);
	}
	public static void Invalidate() {
		if(mypanel != null)
			mypanel.repaint();
		
	}
	public static boolean hasBaricade(int x, int y, int i, int j) {
		// x, y기준 i, j 상대위치
		int dx = i-x+1; //2 이면 오른족
		int dy = j-y+1;
		//dx, dy는 0, 
		int orindex = delta2orindex[dx][dy];
		Orientation[] oris = orindex2ori[orindex];
		Board origin = Main.getBoard(x,y);
		Board to = Main.getBoard(i,j);
		if(origin.hasBaricadee(oris[0])||to.hasBaricadee(oris[1]))
			return true;
		return false;
	}
	private static Board getBoard(int x, int y) {
		return boards[x][y];
	}

	//0 : minus 1: zero 2: plus, 기본위치 기준
	public static int[][] delta2orindex = new int[][] {
		// dx >0 dy>0
		//First row:0
		new int[] {0, 1, 0},
		new int[] {2, 0, 3},
		new int[] {0, 4, 0}
	};

	public static Orientation [][] orindex2ori = new Orientation[][] {
		new Orientation [] {null, null},
		new Orientation [] {Orientation.north,Orientation.south},
		new Orientation [] {Orientation.west,Orientation.east},
		new Orientation [] {Orientation.east,Orientation.west},
		new Orientation [] {Orientation.south,Orientation.north},
	};
}
