import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class pongGame extends JComponent implements ActionListener,
	MouseMotionListener{
	
	public static void main(String[] args)
	{
		JFrame window = new JFrame("Pong Game by Priyanka");
		
		pongGame game = new pongGame();
		
		window.add(game);
		window.pack();
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		Timer t = new Timer(100, game);
		t.start();
		
		window.addMouseMotionListener(game);
	}

	private int ballX = 400;
	private int ballY = 150;
	private int paddleX = 0;
	private int ballYSpeed = 7;
	private int ballXSpeed = 5;
	
	public Dimension getPreferredSize()
	{
		return new Dimension(800,600);
	}

	@Override
	protected void paintComponent(Graphics g)
	{	
		//draw the sky
		//g.setColor(Color.ORANGE);
		g.setColor(new Color(178,223,224));
		g.fillRect(0, 0, 800, 600);
		
		//draw the paddle
		g.setColor(new Color(110,65,23));
		g.fillRect(paddleX,510,150,15);
		
		//draw the ball
		g.setColor(new Color(155,95,170));
		g.fillOval(ballX, ballY, 30, 30);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ballX = ballX + ballXSpeed;
		ballY = ballY + ballYSpeed;
		if(ballY >= 510) 
		{
			ballYSpeed  = -7;
		}
		//-30 to consider the ball inside the screen
		if(ballX >= 800-30) 
		{
			ballXSpeed  = -5;
		}
		
		if(ballX <=0) 
		{
			ballXSpeed  = 5;
		}
		
		if(ballY <= 0) 
		{
			ballYSpeed  = 7;
		}
		
		repaint();
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		paddleX  = e.getX() - 75;
		repaint();
		
	}
	
	

}