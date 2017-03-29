import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.lang.Math;




public class BallPanel extends JPanel implements MouseListener, KeyListener{

	
	
	ArrayList<Ball> balls = new ArrayList<Ball>();
	
	boolean barrierUp;
	
	public BallPanel()
	{
		this.setBackground(Color.PINK);
		for(int i = 0; i < 5; i++)
			balls.add(new Ball());
		System.out.println(balls.size());
		
		addMouseListener(this);
		addKeyListener(this);
		
		barrierUp = true;
		
		
		start();
	}
	
	public void start()
	{
		Thread t = new Thread()
				{
					public void run()
					{
						while (true)
						{
							moveBalls();
							repaint();
							
							try
							{
								Thread.sleep(40);
							}
							
							catch (InterruptedException e)
							{
								
							}
							
						}
					}
				} ;
				
				t.start();
	}
	
	
	public void moveBalls()
	{
		for (Ball b : balls)
			b.move();
	}
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		int leftSideSpeed = 0;
		int rightSideSpeed = 0;
		
		for (Ball b : balls)
		{
			b.paint(g);
			if (b.X < (this.getWidth() / 2) )
			{
				leftSideSpeed += Math.sqrt( Math.pow(b.dx, 2) + Math.pow(b.dy, 2) );
				
			}
			else if (b.X > (this.getWidth() / 2) )
			{
				rightSideSpeed += Math.sqrt( Math.pow(b.dx, 2) + Math.pow(b.dy, 2) );
				
			}
		}
		
		
		if (barrierUp)
		{
			g.setColor(Color.BLACK);
			g.drawLine(390, 0, 390, 800);
		}
		else 
		{
			g.setColor(Color.BLACK);
			g.drawLine(390, 0, 390, 300);
			g.drawLine(390, 800, 390, 500);
		}
	}
	
	

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Maxwell's Demons");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setDefaultLookAndFeelDecorated(true);
		frame.setSize(800,800);
		
		BallPanel p = new BallPanel();
	
		
		
		frame.add(p);
		
		frame.setVisible(true);
		
		
		
	}


	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//balls.add(new Ball());
		//System.out.println("Mouse clicked");
		
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		barrierUp = false;
		for (Ball b: balls)
		{
			b.barrierUp = false;
		}
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		barrierUp = true;
		
		for (Ball b: balls)
		{
			b.barrierUp = true;
		}
		
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

		
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		//System.out.println(e.getKeyChar());
		char character = '?';
		character = e.getKeyChar();
		System.out.println(character);
		
		
	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyChar());
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyChar());
		
	}
	
	
	
	
}
