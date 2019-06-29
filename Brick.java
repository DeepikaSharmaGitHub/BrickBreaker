package BrickBracker;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class Brick {
	int bri[] [];
	int brickWidth;
	int brickHeight;
	
	Brick(int row, int col){
		
		bri=new int[row][col];
		for(int i = 0;i<bri.length;i++) {
			for(int j=0;j<bri[1].length;j++) {
				bri[i][j]=1;
			}
			
		}
		brickWidth=550/col;
		brickHeight=200/row;
		
		
	}
	
	public void BrickGenerater(Graphics2D g) {
		for(int i = 0;i<bri.length;i++) {
			for(int j=0;j<bri[1].length;j++) {
				if(bri [i][j]>0){
				g.setColor(Color.lightGray);
				g.fillRect(j*brickWidth+80,i*brickHeight+50,brickWidth,brickHeight);
				
				g.setColor(Color.BLACK);
				g.setStroke(new BasicStroke(3));
				g.drawRect(j*brickWidth+80,i*brickHeight+50,brickWidth,brickHeight);
			}
				
			}
		}
	}
	
	public void setValue(int value,int i,int j) {
		bri[i][j]=value;
		
	}
	
	
	 
		
}
