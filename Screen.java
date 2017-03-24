//package gui;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;




public class Screen extends JFrame {


	BouncingBall ball1;
	BouncingBall ball2;
	BouncingBall ball3;


	public Screen()
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setDefaultLookAndFeelDecorated(true);
		setSize(800,800);
	    setTitle("Layout practice");
	    setLayout( new GridLayout( 2,2 )); // whole window
	    
	    ball1 = new BouncingBall(5);
	    ball2 = new BouncingBall(10);
	    add(ball1);
	    add(ball2);
	    
	    
		setVisible(true);

	}


	public class BouncingBall extends JPanel {


		//	ArrayList<Thread> balls = new ArrayList();
		// Box height and width
		int width;
		int height;

		// Ball Size
		float radius = 40; 
		float diameter = radius * 2;

		// Center of Call
		float X = radius + 50;
		float Y = radius + 20;

		// Direction (Speed)
		float dx; //= 5;
		float dy; //= 5;

		public BouncingBall(int speed) {

			dx = speed;
			dy = speed;

			Thread thread = new Thread() {
				public void run() {
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
						repaint();

						try {
							Thread.sleep(30);
						} catch (InterruptedException ex) {
						}

					}
				}
			};

			//  balls.add(thread);
			thread.start();


		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			g.fillOval((int)(X-radius), (int)(Y-radius), (int)diameter, (int)diameter);
		}
	}

	public static void main(String[] args) {
		
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

	}
}
