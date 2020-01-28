package com.kyhsgeekcode.gdczombie;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class MyPanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener{
	public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
        try {
			imgZombie = ImageIO.read(new File("zombie.png"));
			imgCivilian = ImageIO.read(new File("civilian.png"));
			imgParty = ImageIO.read(new File("party.png"));
			imgEmpty = ImageIO.read(new File("empty.png"));
			this.addMouseListener(this);
			this.addMouseMotionListener(this);
			
			this.addKeyListener(this);
			this.windowFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public Dimension getPreferredSize() {
        return new Dimension(480,480);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i=0; i<Main.boards.length; i++ )
        {
        	for(int j=0; j<Main.boards.length; j++ )
        	{
        		int x = i * ImgSizeX;
        		int y = j * ImgSizeY;
        		Board b = Main.boards[i][j];
        		Unit u = b.getUnit();
        		Image img = imgEmpty;
        		if(u != null)
        		{
        			if(u instanceof Civilian)
        			{
        				img = imgCivilian;
        			} else if (u instanceof Zombie)
        			{
        				img = imgZombie;
        			} else if (u instanceof Party)
        			{
        				img = imgParty;
        			}
        		}
        		g.drawImage(img, x, y, ImgSizeX, ImgSizeY, null);
                boolean[] hasbar = b.hasBaricade;
                for(int k = 0; k<4; k++)
                {
                	if(hasbar[k]==true)
                	{
                		int [] offs = Orientation.offsets[k];
                		int sx = (int) x + offs[0]*(ImgSizeX-2)+1;
                		int sy = (int) y + offs[1]*(ImgSizeY-2)+1;
                		int ex = (int) x + offs[2]*(ImgSizeX-2)+1;
                		int ey = (int) y + offs[3]*(ImgSizeY-2)+1;
                		g.setColor(Color.DARK_GRAY);
                		g.drawLine(sx, sy, ex, ey);
                		System.out.println(sx+""+sy+""+ex+""+ey);
                	}
                }
        	}
        }
        if(selectedI != -1 && selectedJ != -1)
        {
        	g.setColor(Color.BLUE);
        	g.drawRect(selectedI*ImgSizeX, selectedJ*ImgSizeY, ImgSizeX, ImgSizeY);
        }
        if(hoverI != -1 && hoverJ != -1)
        {
        	g.setColor(Color.YELLOW);
        	g.drawRect(hoverI*ImgSizeX, hoverJ*ImgSizeY, ImgSizeX, ImgSizeY);
        }
        if(targetI != -1 && targetJ != -1)
        {
        	g.setColor(Color.RED);
        	g.drawRect(hoverI*ImgSizeX, hoverJ*ImgSizeY, ImgSizeX, ImgSizeY);
        }

        // Draw Text
        //g.drawString("This is my custom Panel!",10,20);
    }  
    Image imgZombie;
    Image imgCivilian;
    Image imgParty;
    Image imgEmpty;
    public static final int ImgSizeX = 30;
    public static final int ImgSizeY = 30;
    int selectedI = -1;
    int selectedJ = -1;
    int hoverI = -1;
    int hoverJ = -1;
    int targetI = -1;
    int targetJ = -1;
    
    JFrame windowFrame ;
	@Override
	public void mouseClicked(MouseEvent e) {
		this.requestFocusInWindow();
		int x = e.getX();
		int y = e.getY();
		int i = x / ImgSizeX;
		int j = y / ImgSizeY;
		if(i<0 || i >= Main.boards.length)
			return;
		if(j<0 || j >= Main.boards[0].length)
			return;
		if(selectedI == -1 || selectedJ == -1)
		{
			selectedI = i;
			selectedJ = j;
		} else {		//Å¸°ÙÀ» °ñ¶ú´Ù.
			Unit u = Main.getUnit(selectedI, selectedJ);
			if(u!=null && u.canPlayerControl(Main.getLocalPlayer()))
			{				
				{
					int dist = Main.TaxiDist(selectedI, selectedJ,  i, j);
					if(Main.getLocalPlayer().canMove(dist) && dist < 2)	//ÇÑÄ­¾¿¸¸ °¥ ¼ö ÀÖ°Ô Á¦ÇÑ Ãß°¡
					{
						if(Main.hasBaricade(u.x,u.y,i,j))
							return;
						Main.getLocalPlayer().Move(dist);
						targetI = i;
						targetJ = j;
						selectedI = -1;
						selectedJ = -1;
						u.moveTo(i, j);
					}
				}
			} else {
				selectedI = i;
				selectedJ = j;
			}
			
		}
		Main.frame.setTitle( "GDC Zombie Game : "+Main.getLocalPlayer().getLeftMovements()+" actions left");
		this.repaint();
	}

	//Do nothing
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	//Do nothing
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub	
	}

	// Do nothing
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	//Do nothing
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub	
		hoverI = -1;
		hoverJ = -1;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getX();
		int y = e.getY();
		int i = x / ImgSizeX;
		int j = y / ImgSizeY;
		if(i<0 || i >= Main.boards.length)
			return;
		if(j<0 || j >= Main.boards[0].length)
			return;
		hoverI = i;
		hoverJ = j;
		this.repaint();
	}

	public void EnableInput() {
		selectedI = -1;
		selectedJ = -1;
		targetI = -1;
		targetJ = -1;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	void SetBaricade(Orientation ori, boolean has)
	{
		Board b = Main.boards[selectedI][selectedJ];		
		b.SetBaricade(ori, has);
		Main.getLocalPlayer().Move(1);
		repaint();
	}
	//Do Nothing
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	//Do Nothing
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(selectedI<0 || selectedI >= Main.boards.length)
			return;
		if(selectedJ<0 || selectedJ >= Main.boards.length)
			return;
		Unit u = Main.getUnit(selectedI, selectedJ);
		if(u != null && u.canPlayerControl(Main.getLocalPlayer()))
		{
			if(Main.getLocalPlayer().canMove(1))
			{
				switch(e.getKeyCode())
				{
				case KeyEvent.VK_A:
					SetBaricade(Orientation.west, true);
					break;
				case KeyEvent.VK_W:
					SetBaricade(Orientation.north, true);
					break;
				case KeyEvent.VK_X:
					SetBaricade(Orientation.south, true);
					break;
				case KeyEvent.VK_D:
					SetBaricade(Orientation.east, true);
					break;
				case KeyEvent.VK_I:
					SetBaricade(Orientation.north, false);
					break;
				case KeyEvent.VK_J:
					SetBaricade(Orientation.west, false);
					break;
				case KeyEvent.VK_M:
					SetBaricade(Orientation.south, false);
					break;
				case KeyEvent.VK_L:
					SetBaricade(Orientation.east, false);
					break;
				}
			}
		}
		System.out.println("Key pressed"+e.getKeyCode());
	}
    
}
