


//package gui;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;




public class Screen extends JFrame {

	
	BouncingBall ball1;
	BouncingBall ball2;
	BouncingBall ball3;
	JPanel panel;
	int fwidth;
	int fheight;

	public Screen()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setDefaultLookAndFeelDecorated(true);
		setSize(800,800);
		setTitle("Balls");
		//setLayout( new GridLayout( 2,1 )); // whole window

		panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setLayout(new GridLayout(2,1));
		this.add(panel);
		ball1 = new BouncingBall(5);
		ball2 = new BouncingBall(10);
		//add(ball1);
		//panel.add(new JButton("hello"));
		panel.add(ball2);
		panel.add(ball1);
		

		panel.setVisible(true);
		setVisible(true);
		
		fwidth = this.getWidth();
		fheight = this.getHeight();

	}


	public class BouncingBall extends JPanel {


		//	ArrayList<Thread> balls = new ArrayList();
		ArrayList <BallThread> threads;
		// Box height and width
		int width;
		int height;

		// Ball Size
		float radius = 40; 
		float diameter = radius * 2;

		// Center of Call    what does this do?
		float X = radius + 40;
		float Y = radius + 40;

		// Direction (Speed)
		float dx; //= 5;
		float dy; //= 5;
		int ID;

		public BouncingBall(int speed)
		{
			dx = speed;
			dy = speed;
			ID = 0;
			threads = new ArrayList<BallThread>();
			for(int i = 0; i < 1; i++)
				threads.add(new BallThread());

			for(int i = 0; i < 1; i++)
				threads.get(i).start();
		}

		class BallThread extends Thread
		{
			
			int BallID;

			public BallThread()
			{
				
				BallID = ID++;

			}

			public void run()
			{
				while (true) {

					width = getWidth();
					height = getHeight();

					X = X + dx ;
					Y = Y + dy;

					if (X - radius < 0) {
						dx = -dx; 
						X = radius; 
					} else if (X + radius > width) {
						dx = -dx;
						X = width - radius;
					}

					if (Y - radius < 0) {
						dy = -dy;
						Y = radius;
					} else if (Y + radius > height) {
						dy = -dy;
						Y = height - radius;
					}

					for(int i = 0; i < threads.size(); i++)
						repaint();


					try 
					{
						Thread.sleep(40);
					} catch (InterruptedException ex) 
					{

					}
				}
			}
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			g.fillOval((int)(X-radius), (int)(Y-radius), (int)diameter, (int)diameter);


		}


	}

	/*public static void main(String[] args) {

		Screen frame = new Screen();
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



		//	JPanel mainPane = new JPanel();
		//	frame.add(mainPane);
		//mainPane.add(new JButton("hi"));



		//	mainPane.add(new BouncingBall(5));
		//	frame.setContentPane(mainPane);

		//frame.setContentPane(new JButton("hi"));
		//  mainPane.add(new JButton("hi"));




		//frame.setContentPane(new BouncingBall(10));
		//	mainPane.setVisible(true);
		//	frame.setVisible(true);

	}*/
}




