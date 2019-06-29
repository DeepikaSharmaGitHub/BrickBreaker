package BrickBracker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JPanel;
import javax.swing.Timer;

public class GameDesign extends JPanel implements KeyListener, ActionListener{
	
	private int totalBricks=35;
	private int score=0;
	private int playerpos=350;
	private int ballposx=250;
	private int ballposy=400;
	private Timer timer;
	private int directionx=-1;
	private int directiony=-2;
	private int delay=10;
	private boolean play=false;
	private Brick game;
	
	GameDesign(){
		game=new Brick(5,7);
		addKeyListener(this);
		setFocusable(true);
		timer=new Timer(delay,this);
		timer.start();
		
		
		
	}
	
	public void paint(Graphics g) {
		//BACKGROUND
		g.setColor(Color.BLACK);
		g.fillRect(0,0,700,700);
		//brick
		game.BrickGenerater((Graphics2D) g);
		//border
		g.setColor(Color.CYAN);
		g.fillRect(0,0,3,700);
		g.fillRect(0,0,700,3);
		g.fillRect(691,0,3,700);
		//padle
		g.setColor(Color.BLUE);
		g.fillRect(playerpos,650,80,10);
		//ball
		g.setColor(Color.PINK);
		g.fillOval(ballposx, ballposy, 20, 20);
		//score
		g.setColor(Color.WHITE);
		g.setFont(new Font("serif",Font.ITALIC,30));
		g.drawString("BRICK BREAKER GAME               "+score,200,35);
		//RESET
		if(ballposy>=700) {
		play=false;
		g.setColor(Color.CYAN);
		g.setFont(new Font("serif",Font.ITALIC,30));
		g.drawString("GAME OVER ", 250, 350);
		g.drawString("SCORE : "+score, 250, 400);
		g.drawString("PRESS ENTER TO RESTART ", 250, 450);
		
		
		}
		//CONTINUE
		
		if(totalBricks==0) {
			play=false;
			g.setColor(Color.CYAN);
			g.setFont(new Font("serif",Font.ITALIC,30));
			g.drawString("YOU WON ", 250, 350);
			g.drawString("SCORE : "+score, 250, 400);
			g.drawString("PRESS SHIFT TO CONTINUE ", 250, 450);
			g.drawString("LEVEL 2 ", 250, 500);
			
		}
		
		
		
	
		
		
		//g.dispose();
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		repaint();
		if(play==true) {
		if(new Rectangle(playerpos,650,80,10).intersects(new Rectangle(ballposx, ballposy, 20, 20))) {
			
			directiony=-directiony;
		}
		
		A:for(int i = 0;i<game.bri.length;i++) {
			for(int j=0;j<game.bri[1].length;j++) {
				if(game.bri[i][j]>0) {
				int brickWidth=game.brickWidth;
				int brickHeight=game.brickHeight;
				int brickx=j*brickWidth+80;
				int bricky=i*brickHeight+50;
				Rectangle rec=new Rectangle(brickx,bricky,brickWidth,brickHeight);
				Rectangle brickRec= new Rectangle(ballposx,ballposy,20,20);
				
				if(brickRec.intersects(rec)) {
					
					game.setValue(0,i,j);
					
					directiony=-directiony;
					totalBricks--;
					score+=5;
					
					
				}
				}
				
				
				
			}
			
			}
		
		ballposx+=directionx;
		ballposy+=directiony;
		if(ballposx>=670) {
			directionx=-directionx;
		}
		if(ballposx<=3) {
			directionx=-directionx;
		}
		if(ballposy<3) {
			directiony=-directiony;
		}
		
		}
		repaint();
		
		
		
		
		
		
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
		if(playerpos>=610) {
			playerpos=610;
		}
		else {
			moveRight();
		 }
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
		if(playerpos<=3) {
			playerpos=3;
		}
		else {
			moveLeft();
		}
		
		
		
		}
		
		if(e.getKeyCode()==KeyEvent.VK_ENTER) {
			if(!play) {
			play=true;
			totalBricks=35;
			score=0;
			playerpos=350;
			ballposx=250;
			ballposy=400;
			directionx=-1;
			directiony=-2;
			
			game=new Brick(5,7);
			repaint();
			}
			
		}
		
		if(e.getKeyCode()==KeyEvent.VK_SHIFT) {
			if(!play && totalBricks==0) {
				play=true;
				totalBricks=48;
				score=0;
				playerpos=500;
				ballposx=300;
				ballposy=250;
				directionx=-1;
				directiony=-2;
				
			
				game=new Brick(6,8);
				repaint();
				}
				
			}
			}

		
		
	
		
	
	
	public void moveLeft() {
		play=true;
		playerpos-=10;
		
	}

	public void moveRight() {
		play=true;
		playerpos+=10;
		
	}
	
	

	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	




}
