import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;





public class BallPanel extends JPanel{

	
	
	ArrayList<Ball> balls = new ArrayList<Ball>();
	
	public BallPanel()
	{
		this.setBackground(Color.PINK);
		for(int i = 0; i < 5; i++)
			balls.add(new Ball());
		System.out.println(balls.size());
		
		
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
			b.paint(g);
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
	
	
	
	
}
