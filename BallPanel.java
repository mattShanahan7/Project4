import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
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
		
		for (Ball b : balls)
		{
			b.paint(g);
		}
		
		if (barrierUp)
		{
			g.setColor(Color.BLACK);
			g.drawLine(400, 0, 400, 800);
		}
		else 
		{
			g.setColor(Color.BLACK);
			g.drawLine(400, 0, 400, 300);
			g.drawLine(400, 800, 400, 500);
		}
		
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(10));
		g2.drawLine(0, 0, 0, 800);
		g2.drawLine(0, 800, 800, 800);
		g2.drawLine(800, 800, 800, 0);
		g2.drawLine(800, 0, 0, 0);
		
		g2.setFont(new Font("TimesRoman", Font.PLAIN, 40));
		g2.drawString(getRightSpeed(), 600, 100);
		g2.drawString(getLeftSpeed(), 200, 100);
		
		
	}
	
	public String getLeftSpeed()
	{
		String str = "";
		Double leftSideSpeed = 0.0;
		int count = 0;
		for (Ball b : balls)
		{
			if (b.X < (800 / 2) )
			{
				leftSideSpeed += Math.sqrt( Math.pow(b.dx, 2) + Math.pow(b.dy, 2) );
				count++;
			}
		}
		
		leftSideSpeed /= count;
		str = leftSideSpeed.toString();
		str = str.substring(0,4);
		return str;
	}
	
	public String getRightSpeed()
	{
		String str = "";
		Double rightSideSpeed = 0.0;
		int count = 0;
		for (Ball b : balls)
		{
			if (b.X > (800 / 2) )
			{
				rightSideSpeed += Math.sqrt( Math.pow(b.dx, 2) + Math.pow(b.dy, 2) );
				count++;
			}
		}
		
		rightSideSpeed /= count;
		str = rightSideSpeed.toString();
		str = str.substring(0,4);
		return str;
	}
	

	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Maxwell's Demons");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setDefaultLookAndFeelDecorated(true);
		frame.setSize(900,900);
		frame.setLayout(new BorderLayout(10, 10));
		
		BallPanel p = new BallPanel();
	
		
		
		frame.add(p, BorderLayout.CENTER);
	//	frame.add(new JButton(), BorderLayout.NORTH);
	//	frame.add(new JButton(), BorderLayout.WEST);

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