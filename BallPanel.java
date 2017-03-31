import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.lang.Math;




public class BallPanel extends JPanel implements MouseListener, ActionListener{


	ArrayList<Ball> balls = new ArrayList<Ball>();
	
	boolean barrierUp;
	
	public BallPanel()
	{
		this.setBackground(Color.PINK);
		for(int i = 0; i < 8; i++)
		{
			Ball toAdd = new Ball();
			if (i % 2  == 0)
				toAdd.setRed(true);
			else
				toAdd.setRed(false);
			
			if (i < 4)
				toAdd.setLeft();
			else
				toAdd.setRight();
			
			balls.add(toAdd);
		}
			
		System.out.println(balls.size());
		
		addMouseListener(this);
		
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
		
		if(count == 0)
			return "0";
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
		if(count == 0)
			return "0";
		rightSideSpeed /= count;
		str = rightSideSpeed.toString();
		str = str.substring(0,4);
		return str;
	}
	

	public static void main(String[] args) {
		
	/*	JFrame frame = new JFrame("Maxwell's Demons");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setDefaultLookAndFeelDecorated(true);
		frame.setSize(900,900);
		frame.setLayout(new BorderLayout(10, 10));
		*/
		BallPanel p = new BallPanel();
		
		JFrame optionFrame = new JFrame("Maxwell's Demons Buttons");
		optionFrame.setDefaultCloseOperation(optionFrame.EXIT_ON_CLOSE);
		optionFrame.setDefaultLookAndFeelDecorated(true);
		optionFrame.setSize(820, 900);
		optionFrame.setLayout(new BorderLayout());
		
		p.addButtons(optionFrame);
		
		optionFrame.add(p, BorderLayout.CENTER);

	//	frame.setVisible(true);
		optionFrame.setVisible(true);

	}
	
	public void addButtons(JFrame buttonFrame)
	{
		JButton addBalls = new JButton("Add New Balls");
		JButton reset = new JButton("Reset");
		
		buttonFrame.add(addBalls, BorderLayout.NORTH);
		buttonFrame.add(reset, BorderLayout.SOUTH);
		
		addBalls.addActionListener(new BallButtonListener());
		reset.addActionListener(new ResetButtonListener());
		
	}
	
	public class BallButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Ball toAdd1 = new Ball();
			toAdd1.setLeft();
			toAdd1.setRed(true);
			
			Ball toAdd2 = new Ball();
			toAdd2.setLeft();
			toAdd2.setRed(false);
			
			Ball toAdd3 = new Ball();
			toAdd3.setRight();
			toAdd3.setRed(true);
			
			Ball toAdd4 = new Ball();
			toAdd4.setRight();
			toAdd4.setRed(false);
			
			balls.add(toAdd1);
			balls.add(toAdd2);
			balls.add(toAdd3);
			balls.add(toAdd4);

		}
	}
	
	public class ResetButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			balls.clear();
			
			for(int i = 0; i < 8; i++)
			{
				Ball toAdd = new Ball();
				if (i % 2  == 0)
					toAdd.setRed(true);
				else
					toAdd.setRed(false);
				
				if (i < 4)
					toAdd.setLeft();
				else
					toAdd.setRight();
				
				balls.add(toAdd);
			}
			

		}
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

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}